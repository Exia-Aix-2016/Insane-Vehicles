package fr.exia.insanevehicles.first.element.motionless;

import java.awt.*;

/**
 * Created by Mandel on 19/05/2017.
 */
class Finishing_line extends MotionlessElement {
    /** The Constant SPRITE. */
    private static final char SPRITE = '~';

    /**
     * Instantiates a new ditch.
     */
    @Override
    public void paintComponent(Graphics g)
    {

    }
    @Deprecated
    Finishing_line() {
        super(SPRITE);
    }

    Finishing_line(final int x, final int y){
        super(x, y);
    }


}
