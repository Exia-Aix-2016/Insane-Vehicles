package fr.exia.insanevehicles.first.element;

public class MyVehicle extends Element {

    private int x, y;
    private static final char SPRITE = 'H';

    MyVehicle(){
        super(SPRITE);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
