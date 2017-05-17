package fr.exia.insanevehicles.first;

import java.util.Random;

import fr.exia.insanevehicles.first.element.Element;
import fr.exia.insanevehicles.first.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Class Road.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class Road {

    /** The width. */
    private int               width;

    /** The height. */
    private int               height;

    /** The view. */
    private int               view;

    /** The quota. */
    private int               quota;

    /** The on the road. */
    private final Element[][] onTheRoad;

    /**
     * Instantiates a new road.
     *
     * @param width
     *            the width
     * @param height
     *            the height
     * @param view
     *            the view
     * @param quota
     *            the quota
     */
    public Road(final int width, final int height, final int view, final int quota) {
        this.setWidth(width);
        this.setHeight(height);
        this.setView(view);
        this.setQuota(quota);
        this.onTheRoad = new Element[this.getWidth()][this.getHeight()];
        this.fillOnTheRoad();
    }

    /**
     * Show.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart;
        for (int view = 0; view < this.getView(); view++) {
            y = (y + 1) % this.getHeight();
            for (int x = 0; x < this.getWidth(); x++) {
                System.out.print(this.getOnTheRoadXY(x, y).getSprite());
            }
            System.out.print("\n");
        }
    }

    /**
     * Fill on the road.
     */
    private void fillOnTheRoad() {
        final Random random = new Random();

        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if ((x == 0) || (x == (this.getWidth() - 1))) {
                    this.setOnTheRoadXY(MotionlessElementsFactory.createDitch(), x, y);
                } else if ((random.nextInt() % this.getQuota()) == 0) {
                    this.setOnTheRoadXY(MotionlessElementsFactory.createObstacle(), x, y);
                } else {
                    this.setOnTheRoadXY(MotionlessElementsFactory.createMacadam(), x, y);
                }
            }
        }
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
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

    /**
     * Gets the quota.
     *
     * @return the quota
     */
    public final int getQuota() {
        return this.quota;
    }

    /**
     * Sets the quota.
     *
     * @param quota
     *            the new quota
     */
    private void setQuota(final int quota) {
        this.quota = quota;
    }

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    public final Element getOnTheRoadXY(final int x, final int y) {
        return this.onTheRoad[x][y];
    }

    /**
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public final void setOnTheRoadXY(final Element element, final int x, final int y) {
        this.onTheRoad[x][y] = element;
    }

}
