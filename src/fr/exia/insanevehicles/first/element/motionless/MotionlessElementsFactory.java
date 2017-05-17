package fr.exia.insanevehicles.first.element.motionless;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

    /** The Constant DITCH. */
    private static final Ditch    DITCH    = new Ditch();

    /** The Constant MACADAM. */
    private static final Macadam  MACADAM  = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle OBSTACLE = new Obstacle();

    /**
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitch() {
        return DITCH;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }
}
