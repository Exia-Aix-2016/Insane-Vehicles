package fr.exia.insanevehicles.first;

import fr.exia.insanevehicles.first.element.Element;
import fr.exia.insanevehicles.first.element.MyVehicle;
import fr.exia.insanevehicles.first.element.motionless.MotionlessElementsFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 * <h1>The Class InsaneVehiclesGames.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class InsaneVehiclesGames {

    /** The Constant ROAD_WIDTH. */
    public static final int ROAD_WIDTH  = 9;

    /** The Constant ROAD_HEIGHT. */
    public static final int ROAD_HEIGHT = 40;

    /** The Constant ROAD_VIEW. */
    public static final int ROAD_VIEW   = 23;

    /** The Constant ROAD_QUOTA. */
    public static final int ROAD_QUOTA  = 20;

    /** The road. */
    private Road road;
    private MyVehicle car;
    Element Macadam;
    Element FinishLine;


    private Window window = new Window();
    private Panel panel = new Panel();
    /**
     * Instantiates a new insane vehicles games.
     */
    public InsaneVehiclesGames() {
        //this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW, ROAD_QUOTA));
        this.setRoad(new RoadLoader(ROAD_VIEW, ROAD_QUOTA, "road.txt").get());

        Macadam = MotionlessElementsFactory.createMacadam();
        FinishLine = MotionlessElementsFactory.createFinishLine();

        window.setContentPane(panel);
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_LEFT:
                        car.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT :
                        car.moveRight();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    public void play(){

        int startY = 0;
        boolean check = false;

        window.setBackground(Color.white);

        car = new MyVehicle(road.getWidth()/2 , 1);

        while(road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == Macadam.getSprite()
                || road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == FinishLine.getSprite()){
            if (car.getY() == road.getHeight()-1){
                check = true;
                break;
            }else {
                int prevX = car.getX();
                int prevY = car.getY();

                road.setOnTheRoadXY(car, prevX, prevY);


                if(!(prevY < road.getView() / 2)) {
                    startY++;
                }
                panel.setText(road.getText(startY));
                window.repaint();

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e){

                }

                this.car.moveForward();

                road.removeOnTHeRoadXY(prevX, prevY);
            }

        }

        if (check) {
            window.setBackground(Color.GREEN);
        }else {
            window.setBackground(Color.RED);
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e){

        }

        play();

    }
    /**
     * Gets the road.
     *
     * @return the road
     */
    public final Road getRoad() {
        return this.road;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setRoad(final Road road) {
        this.road = road;
    }
}
