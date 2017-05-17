public class MyVehicle extends Element{
    private int x;
    private int y;

    public MyVehicle(char sprite){
           super(sprite);
        }


    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() { return y; }

}
