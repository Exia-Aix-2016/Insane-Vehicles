package fr.exia.insanevehicles.prosit3.element.motionless;

import fr.exia.insanevehicles.prosit3.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class DitchRight.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class DitchRight extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = '\\';
    private static final String IMAGE = "dirt.jpg";

    /**
     * Instantiates a new ditchRight.
     */
    DitchRight() {
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }
}
