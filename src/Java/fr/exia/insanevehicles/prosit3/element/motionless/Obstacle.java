package fr.exia.insanevehicles.prosit3.element.motionless;

import fr.exia.insanevehicles.prosit3.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class Obstacle.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Obstacle extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = 'X';
    private static final String IMAGE = "BlackTile.jpg";

    /**
     * Instantiates a new obstacle.
     */
    Obstacle(){
        super(IMAGE, Permeability.BLOCKING);
    }
}
