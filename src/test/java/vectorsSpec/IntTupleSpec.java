package vectorsSpec;

import org.junit.Test;
import static org.junit.Assert.*;

import vectors.IntTuple;

public class IntTupleSpec {
    @Test public void testIntTupleAdd() {
        IntTuple t1 = new IntTuple(0,0);
        IntTuple t2 = new IntTuple(1,0);
        t1.add(t2);

        assertTrue("IntTuple add to identity: ", t1.equals(t2));

        IntTuple t3 = new IntTuple(3,4);
        IntTuple t4 = new IntTuple(-2, 5);
        t3.add(t4);

        assertTrue("IntTuple add: ", t3.equals(new IntTuple(1, 9)));
    }
}
