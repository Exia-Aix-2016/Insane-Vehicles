package fr.exia.insanevehicles.first;

import fr.exia.insanevehicles.first.element.Element;
import fr.exia.insanevehicles.first.element.MyVehicle;
import fr.exia.insanevehicles.first.element.motionless.MotionlessElementsFactory;
import java.io.IOException;


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
    private Road road;
    private MyVehicle car;
    Element Macadam;
    /**
     * Instantiates a new insane vehicles games.
     */
    public InsaneVehiclesGames() {
        this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW, ROAD_QUOTA));
        car = new MyVehicle(road.getWidth()/2 , 1);

        Macadam = MotionlessElementsFactory.createMacadam();

    }

    /**
     * Play.
     */
    public final void play() {






        while(road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == Macadam.getSprite()) {
            System.out.println("=================================");
            int prevX = car.getX();
            int prevY = car.getY();

            road.setOnTheRoadXY(car, prevX, prevY);
            this.car.moveForward();


            try
            {
                Runtime.getRuntime().exec("cmd /c cls");
            }
            catch(final Exception e)
            {
                System.out.print(e);
            }
            this.getRoad().show(0);

            road.removeOnTHeRoadXY(prevX, prevY);

        }



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
