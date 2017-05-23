package fr.exia.insanevehicles.prosit3.element.mobile;

import fr.exia.insanevehicles.prosit3.Road;
import fr.exia.insanevehicles.prosit3.element.Element;
import fr.exia.insanevehicles.prosit3.element.Permeability;
import fr.exia.showboard.IPawn;

import java.awt.*;
import java.io.IOException;

/**
 * <h1>The Class Mobile.</h1>
 *
 * @author Jade
 * @version 0.1
 */
abstract class Mobile extends Element implements IPawn {

    /**
     * The x.
     */
    private int     x;

    /**
     * The y.
     */
    private int     y;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private Road road;

    Mobile(final String filename, final char sprite, final Road road, final Permeability permeability) throws IOException{
        super(filename, sprite, permeability);
        this.setRoad(road);
    }

    Mobile(final int x, final int y, final String filename, final char sprite, final Road road, final Permeability permeability) throws IOException {
        this(filename, sprite, road, permeability);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Move up.
     */
    public void moveUp() {
        this.setY(this.getY() - 1);
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        this.setX(this.getX() - 1);
    }

    /**
     * Move down.
     */
    public void moveDown() {
        this.setY(this.getY() + 1);
    }

    /**
     * Move right.
     */
    public void moveRight() {
        this.setX(this.getX() + 1);
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public final int getX() {
        return this.x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public final int getY() {
        return this.y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.y = (y + this.getRoad().getHeight()) % this.getRoad().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public Road getRoad() {
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

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Die.
     */
    private void die() {
        this.alive = false;
    }

    /**
     * Checks if is crashed.
     *
     * @return the boolean
     */
    public Boolean isCrashed() {
        return this.getRoad().getOnTheRoadXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    public Point getPosition(){
        return new Point(this.getX(), this.getY());
    }
}
