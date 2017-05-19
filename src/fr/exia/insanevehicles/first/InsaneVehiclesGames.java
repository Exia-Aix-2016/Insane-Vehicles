package fr.exia.insanevehicles.first;

import fr.exia.insanevehicles.first.element.Element;
import fr.exia.insanevehicles.first.element.MyVehicle;
import fr.exia.insanevehicles.first.element.motionless.MotionlessElementsFactory;

import java.util.Scanner;


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
    Element FinishLine;
    /**
     * Instantiates a new insane vehicles games.
     */
    public InsaneVehiclesGames() {
        //this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW, ROAD_QUOTA));
        this.setRoad(new RoadLoader(ROAD_VIEW, ROAD_QUOTA, "road.txt").get());

        car = new MyVehicle(road.getWidth()/2 , 1);

        Macadam = MotionlessElementsFactory.createMacadam();
        FinishLine = MotionlessElementsFactory.createFinishLine();
    }

    /**
     * Play.
     */
    public final void play() {

        Scanner sc = new Scanner(System.in);

        int startY = 0;
        int tour = 1;
        boolean check = false;

        while(road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == Macadam.getSprite()
                || road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == FinishLine.getSprite()) {

            if (car.getY() == road.getHeight()-1){
                    check = true;
                    break;
            }else {
                System.out.println("==========" + "TOURS " + tour + "==========");
                int prevX = car.getX();
                int prevY = car.getY();

                road.setOnTheRoadXY(car, prevX, prevY);


                if(!(prevY < road.getView() / 2)) {
                    startY++;
                }
                this.getRoad().show(startY);
                if(road.getOnTheRoadXY(car.getX(), car.getY()).getSprite() == FinishLine.getSprite())
                {
                    tour++;
                }

                String str = sc.nextLine();
                if ("q".equals(str)) {
                    this.car.moveLeft();
                } else if ("d".equals(str)) {
                    this.car.moveRight();
                }
                this.car.moveForward();
                
                road.removeOnTHeRoadXY(prevX, prevY);
            }


        }
        if(check == false) {
            System.out.println("Crash !!!");
        }else {
            System.out.println("Win !");
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
