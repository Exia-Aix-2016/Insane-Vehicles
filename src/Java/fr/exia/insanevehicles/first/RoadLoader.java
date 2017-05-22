package fr.exia.insanevehicles.first;

import fr.exia.insanevehicles.first.element.Element;
import fr.exia.insanevehicles.first.element.motionless.DitchDirection;
import fr.exia.insanevehicles.first.element.motionless.MotionlessElementsFactory;

import java.io.*;

public class RoadLoader {

    private String filename;
    private int height;
    private int width;
    private int view;
    private int quotaString;
    private BufferedReader br;
    private Element[][] onTheRoad;

    public RoadLoader(final int view, final int quotaString, String filename){
        this.filename = filename;
        this.quotaString = quotaString;
        this.view = view;
        InputStream in = getClass().getResourceAsStream(filename);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            this.br = br;
            this.getDimension();
            this.onTheRoad = new Element[this.width][this.height];
            this.loadRoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDimension(){

        try {
            this.width = Integer.parseInt(this.br.readLine());
            this.height = Integer.parseInt(this.br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRoad(){
        try {

            String sCurrentLine;

            for (int y = 0;  y < this.height; y++){
                sCurrentLine = this.br.readLine();
                char ch[] = sCurrentLine.toCharArray();
                for (int x=0; x < this.width; x++){
                    switch (ch[x]){
                        case ' ':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createMacadam(x, y);
                            if(y == height-1)
                            {
                               onTheRoad[x][y] =  MotionlessElementsFactory.createFinishLine(x, y);
                            }
                            break;
                        case '^':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createBush(x, y);
                            break;
                        case '|':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createDitch(x, y);
                            break;
                        case '\\':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createDitch(DitchDirection.LEFT, x, y);
                            break;
                        case '/':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createDitch(DitchDirection.RIGHT, x, y);
                            break;
                        case 'X':
                            this.onTheRoad[x][y] = MotionlessElementsFactory.createObstacle(x, y);
                            break;

                    }


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Road get(){
        return new Road(this.width, this.height, this.view, this.quotaString, this.onTheRoad);
    }
}
