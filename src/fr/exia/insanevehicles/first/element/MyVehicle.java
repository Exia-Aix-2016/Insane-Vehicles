package fr.exia.insanevehicles.first.element;

public class MyVehicle extends Element {

    private int x, y;
    private static final char SPRITE = 'H';

    public MyVehicle(int X, int Y){
        super(SPRITE);
        x = X;
        y = Y;
    }

    public void moveForward(){
        y += 1;
    }
    public void moveLeft(){
        x -= 1;
    }
    public void moveRight(){
        x += 1;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    
}
