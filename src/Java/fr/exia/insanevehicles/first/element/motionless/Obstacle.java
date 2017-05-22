package fr.exia.insanevehicles.first.element.motionless;

import java.awt.*;

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
    @Override
    public void paintComponent(Graphics g)
    {

    }
    @Deprecated
    Obstacle() {
        super(SPRITE);
    }
    Obstacle(final int x, final int y){
        super(x, y);
    }
}
