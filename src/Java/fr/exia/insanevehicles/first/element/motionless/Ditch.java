package fr.exia.insanevehicles.first.element.motionless;

import java.awt.*;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Ditch extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = '|';

    /**
     * Instantiates a new ditch.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, 10, 10);
    }
    @Deprecated
    Ditch() {
        super(SPRITE);
    }

    Ditch(final int x, final int y){
        super(x, y);
    }
}
