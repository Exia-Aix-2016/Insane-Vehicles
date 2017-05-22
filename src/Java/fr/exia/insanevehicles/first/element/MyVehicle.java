package fr.exia.insanevehicles.first.element;

import com.sun.istack.internal.Nullable;

import java.awt.*;

public class MyVehicle extends Element {

    private int x, y;
    private static final char SPRITE = 'H';

    public MyVehicle(int X, int Y){
        super(SPRITE);
        x = X;
        y = Y;
    }
    @Override
    public  void paintComponent(Graphics g)
    {

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
