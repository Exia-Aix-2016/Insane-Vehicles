import java.util.ArrayList;

public class Road {

    private int width;
    private int height;
    private int view;
    private int quota;

    private ArrayList<Element> onTheRoad;

    Road(int width, int height, int view, int quota){
        this.width = width;
        this.height = height;
        this.view = view;
        this.quota = quota;
    }

    private void fillOnTheRoad(){

    }


    public char getOnTheRoad(int x, int y){
        return ' ';
    }

    public void setOnTheRoad(Element element, int x, int y){

    }
}
