import org.junit.Test;
import vectors.IntTuple;

import static org.junit.Assert.assertTrue;

public class RoverSpec {
    @Test(expected=RuntimeException.class)
    public void testBadMoveOrigin() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(0,0,'S', plat);
        r1.move('M');
    }
    @Test(expected=RuntimeException.class)
    public void testBadMoveBounds() {
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(5,5,'E', plat);
        r1.move('M');
    }

    @Test
    public void testSampleMovers() {
        char[] moves = {'M', 'R', 'M', 'M', 'L' , 'M'};
        Plateau plat = new Plateau(5, 5);
        Rover r1 = new Rover(1,0,'N', plat);
        for (char command : moves) {
            r1.move(command);
        }
        assertTrue("sample position: ", r1.getPosition().equals(new IntTuple(3, 2)));
        assertTrue("sample direction: ", r1.getDirection().equals(new IntTuple(0, 1)));
    }
}
