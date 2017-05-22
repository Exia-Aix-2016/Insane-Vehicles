package fr.exia.insanevehicles.prosit3;

import fr.exia.insanevehicles.prosit3.element.Element;
import fr.exia.insanevehicles.prosit3.element.motionless.MotionlessElementsFactory;

import java.io.*;
import java.util.Random;

/**
 * <h1>The Class Road.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Road {

    /** The width. */
    private int         width;

    /** The height. */
    private int         height;

    /** The quota. */
    private int         quota;

    /** The on the road. */
    private Element[][] onTheRoad;

    /**
     * Instantiates randomly a new road.
     *
     * @param width
     *            the width
     * @param height
     *            the height
     * @param quota
     *            the quota
     */
    public Road(final int width, final int height, final int quota) {
        this.setWidth(width);
        this.setHeight(height);
        this.setQuota(quota);
        this.onTheRoad = new Element[this.getWidth()][this.getHeight()];
        this.fillOnTheRoad();
    }

    /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @param quota
     *            the quota
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Road(final String fileName, final int quota) throws IOException {
        this.setQuota(quota);
        this.loadFile(fileName);
    }

    /**
     * Fill randomly the road.
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
     * Load file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        InputStream in = getClass().getResourceAsStream(fileName);
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheRoad = new Element[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheRoadXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
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
