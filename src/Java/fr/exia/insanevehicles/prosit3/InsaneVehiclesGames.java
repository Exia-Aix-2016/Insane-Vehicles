package fr.exia.insanevehicles.prosit3;

import fr.exia.insanevehicles.prosit3.element.mobile.MyVehicle;
import fr.exia.showboard.BoardFrame;

import java.awt.*;
import java.io.IOException;
import java.util.Observable;

/**
 * <h1>The Class InsaneVehiclesGames.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class InsaneVehiclesGames extends Observable implements Runnable{
    /** The Constant roadWidth. */
    public static final int  roadWidth  = 9;

    /** The Constant roadHeight. */
    public static final int  roadHeight = 40;

    /** The Constant roadView. */
    public static final int  roadView   = 9;

    /** The Constant roadQuota. */
    public static final int  roadQuota  = 20;

    /** The Constant startX. */
    private static final int startX     = 5;

    /** The Constant startY. */
    private static final int startY     = 0;

    /** The Constant keyRight. */
    private static final int keyRight   = 51;

    /** The Constant keyLeft. */
    private static final int keyLeft    = 49;

    /** The road. */
    private Road             road;

    /** The my vehicle. */
    private MyVehicle        myVehicle;

    /** The view. */
    private int              view;

    /**
     * Instantiates a new insane vehicles games.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public InsaneVehiclesGames() {
        // this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW,
        // ROAD_QUOTA));
        this.setView(roadView);
        try {
            this.setRoad(new Road("road.txt", roadQuota));
            this.setMyVehicle(new MyVehicle(startX, startY, this.getRoad()));
        } catch (IOException e){}
    }

    /**
     * Play.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void play() throws IOException {
        while (this.getMyVehicle().isAlive()) {
            this.show(this.getMyVehicle().getY());
            final int key = System.in.read();
            switch (key) {
                case keyRight:
                    this.getMyVehicle().moveRight();
                    break;
                case keyLeft:
                    this.getMyVehicle().moveLeft();
                    break;
                default:
                    break;
            }
            while (System.in.available() > 0) {
                System.in.read();
            }
            this.getMyVehicle().moveDown();
        }
        System.out.println("CRASH !!!!!!!!!\n");
    }

    /**
     * Print the road and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getRoad().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getRoad().getWidth(); x++) {
                if ((x == this.getMyVehicle().getX()) && (y == yStart)) {
                    System.out.print(this.getMyVehicle().getSprite());
                } else {
                    System.out.print(this.getRoad().getOnTheRoadXY(x, y).getSprite());
                }
            }
            y = (y + 1) % this.getRoad().getHeight();
            System.out.print("\n");
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

    /**
     * Gets the my vehicle.
     *
     * @return the my vehicle
     */
    public final MyVehicle getMyVehicle() {
        return this.myVehicle;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the new my vehicle
     */
    public final void setMyVehicle(final MyVehicle myVehicle) {
        this.myVehicle = myVehicle;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public final int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    public void run(){
        final BoardFrame frameAllView = new BoardFrame("All view");
        frameAllView.setDimension(new Dimension(this.roadWidth, this.roadHeight));
        frameAllView.setDisplayFrame(new Rectangle(0, 0, this.roadWidth, this.roadHeight));
        this.frameConfigure(frameAllView);
    }

    public final void frameConfigure(final BoardFrame frame) {

        this.addObserver(frame.getObserver());

        frame.setVisible(true);
    }
}
