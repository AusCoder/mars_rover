package vectors;

/*
An integer tuple class for use as rover position and direction.
 */
public class IntTuple {
    public int x;
    public int y;

    public IntTuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public IntTuple(IntTuple t) {
        this.x = t.x;
        this.y = t.y;
    }

    public void add(IntTuple t) {
        this.x += t.x;
        this.y += t.y;
    }

    public boolean equals(IntTuple t) {
        return this.x == t.x && this.y == t.y;
    }
}

