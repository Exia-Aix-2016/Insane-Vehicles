package fr.exia.insanevehicles.first.element.motionless;

import java.awt.*;

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
    @Override
    public void paintComponent(Graphics g)
    {

    }
    @Deprecated
    Macadam() {
        super(SPRITE);
    }

    Macadam(final int x, final int y){
        super(x, y);
    }
}
