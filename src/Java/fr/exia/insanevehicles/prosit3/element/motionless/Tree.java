package fr.exia.insanevehicles.prosit3.element.motionless;

import fr.exia.insanevehicles.prosit3.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class Tree.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Tree extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = '^';
    private static final String IMAGE = "grass.jpg";
    /**
     * Instantiates a new tree.
     */
    Tree() {
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }
}
