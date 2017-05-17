package fr.exia.insanevehicles.first;

/**
 * <h1>The Class InsaneVehiclesGames.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class InsaneVehiclesGames {

    /** The Constant ROAD_WIDTH. */
    public static final int ROAD_WIDTH  = 9;

    /** The Constant ROAD_HEIGHT. */
    public static final int ROAD_HEIGHT = 40;

    /** The Constant ROAD_VIEW. */
    public static final int ROAD_VIEW   = 23;

    /** The Constant ROAD_QUOTA. */
    public static final int ROAD_QUOTA  = 20;

    /** The road. */
    private Road            road;

    /**
     * Instantiates a new insane vehicles games.
     */
    public InsaneVehiclesGames() {
        this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW, ROAD_QUOTA));
    }

    /**
     * Play.
     */
    public final void play() {
        this.getRoad().show(0);
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public final Road getRoad() {
        return this.road;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setRoad(final Road road) {
        this.road = road;
    }
}
