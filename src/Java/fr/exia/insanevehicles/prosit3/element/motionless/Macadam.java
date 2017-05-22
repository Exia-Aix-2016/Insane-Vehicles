package fr.exia.insanevehicles.prosit3.element.motionless;

import fr.exia.insanevehicles.prosit3.element.Permeability;

/**
 * <h1>The Class Macadam.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Macadam extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = ' ';

    /**
     * Instantiates a new macadam.
     */
    Macadam() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
