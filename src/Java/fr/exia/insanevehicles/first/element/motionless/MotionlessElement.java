package fr.exia.insanevehicles.first.element.motionless;

import fr.exia.insanevehicles.first.element.Element;

/**
 * <h1>The Class MotionlessElement.</h1>
 *
 * @author Jade
 * @version 0.1
 */
abstract class MotionlessElement extends Element {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     */
    @Deprecated
    MotionlessElement(final char sprite) {
        super(sprite);
    }
    MotionlessElement(final int x, final int y){
        super(x, y);
    }



}
