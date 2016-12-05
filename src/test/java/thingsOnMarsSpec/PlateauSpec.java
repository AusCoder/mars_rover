package thingsOnMarsSpec;

import org.junit.Test;

import thingsOnMars.Rover;
import thingsOnMars.Plateau;

public class PlateauSpec {
    @Test(expected=RuntimeException.class)
    public void badRoverPlacement() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(0,0,'S', plat);
        Rover r2 = new Rover(0,0,'N', plat);
        plat.addRover(r1);
        plat.addRover(r2);
    }
}
