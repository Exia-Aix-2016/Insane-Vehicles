package fr.exia.insanevehicles.prosit3.element.motionless;

import fr.exia.insanevehicles.prosit3.element.Permeability;

/**
 * <h1>The Class Obstacle.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Obstacle extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = 'X';

    /**
     * Instantiates a new obstacle.
     */
    Obstacle() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
