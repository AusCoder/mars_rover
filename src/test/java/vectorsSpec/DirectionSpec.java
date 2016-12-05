package vectorsSpec;

import org.junit.Test;
import static org.junit.Assert.*;

import vectors.Direction;
import vectors.IntTuple;

public class DirectionSpec {
    @Test public void testDirectionRotateLeft() {
        Direction d1 = new Direction('N');
        d1.rotateLeft();
        assertTrue("Direction should be west: ", d1.equals(new IntTuple(-1, 0)));
        d1.rotateLeft();
        assertTrue("Direction should be south: ", d1.equals(new IntTuple(0, -1)));
        d1.rotateLeft();
        assertTrue("Direction should be east: ", d1.equals(new IntTuple(1, 0)));
        d1.rotateLeft();
        assertTrue("Direction should be north: ", d1.equals(new IntTuple(0, 1)));
    }

    @Test public void testDirectionRotateRight() {
        Direction d1 = new Direction('N');
        d1.rotateRight();
        assertTrue("Direction should be east: ", d1.equals(new IntTuple(1, 0)));
        d1.rotateRight();
        assertTrue("Direction should be south: ", d1.equals(new IntTuple(0, -1)));
        d1.rotateRight();
        assertTrue("Direction should be west: ", d1.equals(new IntTuple(-1, 0)));
        d1.rotateRight();
        assertTrue("Direction should be north: ", d1.equals(new IntTuple(0, 1)));
    }

    @Test public void testDirectionRotateRightAndLeft() {
        Direction d1 = new Direction('N');
        d1.rotateRight();
        assertTrue("Direction should be east: ", d1.equals(new IntTuple(1, 0)));
        d1.rotateLeft();
        assertTrue("Direction should be north: ", d1.equals(new IntTuple(0, 1)));
    }
}
