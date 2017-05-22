package fr.exia.insanevehicles.first.element;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>The Class Element.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class Element extends JPanel {

    /** The sprite. */
    private char sprite;
    protected int x, y;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     */
    /**
     * Devra être redéfini pour chaque Element
     * */
    @Override
    public abstract  void paintComponent(Graphics g);

    @Deprecated
    public Element(final char sprite) {
        this.setSprite(sprite);
    }
    public Element(final int x, final int y){
        this.setX(x);
        this.setY(y);
    }
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public final char getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    private void setSprite(final char sprite) {
        this.sprite = sprite;
    }
    //Assesseur
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    //Mutateur
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
