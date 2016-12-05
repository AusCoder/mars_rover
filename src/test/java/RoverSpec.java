import org.junit.Test;
import vectors.IntTuple;

import static org.junit.Assert.assertTrue;

public class RoverSpec {
    @Test(expected=RuntimeException.class)
    public void testBadMoveOrigin() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(0,0,'S', plat);
        plat.addRover(r1);
        r1.move('M');
    }
    @Test(expected=RuntimeException.class)
    public void testBadMoveBounds() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(5,5,'E', plat);
        plat.addRover(r1);
        r1.move('M');
    }
    @Test(expected=RuntimeException.class)
    public void testRoverCollision() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(0,0,'E', plat);
        Rover r2 = new Rover(1,0,'N', plat);
        plat.addRover(r1);
        plat.addRover(r2);
        r1.move('M');
    }

    @Test
    public void testSampleMoves() {
        char[] moves = {'M', 'R', 'M', 'M', 'L' , 'M'};
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(1,0,'N', plat);
        plat.addRover(r1);
        for (char command : moves) {
            r1.move(command);
        }
        assertTrue("sample position: ", r1.getPosition().equals(new IntTuple(3, 2)));
        assertTrue("sample direction: ", r1.getDirection().equals(new IntTuple(0, 1)));
    }
}
