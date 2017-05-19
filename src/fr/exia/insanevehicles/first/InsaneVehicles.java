package fr.exia.insanevehicles.first;

import javax.swing.*;

/**
 * <h1>The Class InsaneVehicles.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class InsaneVehicles {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {

        final InsaneVehiclesGames insaneVehiclesGame = new InsaneVehiclesGames();
        //insaneVehiclesGame.play();
        insaneVehiclesGame.playGraphic();
    }
}
