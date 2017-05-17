public class Element {
    private char sprite;
    private int x, y;

    Element(char sprite){
        this.sprite = sprite;
    }

    //Mutateur
    public void setSprite(char SPRITE){//set Sprite Element
        sprite = SPRITE;
    }
    public void setX(int coordX){//set coord x
        x = coordX;
    }
    public void setY(int coordY){//set coord y
        y = coordY;
    }
    //Assesseur
    public char getSprite() {//Return sprite Element
        return sprite;
    }


}
