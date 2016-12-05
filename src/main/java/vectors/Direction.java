package vectors;

/*
direction class to represent direction of rover
 */
public class Direction extends IntTuple {
    /*
    converts char representation of direction to a tuple
    */
    private static IntTuple directionConverter(char d) throws RuntimeException {
        IntTuple out;
        switch (d) {
            case 'N': out = new IntTuple(0,1);
                break;
            case 'S': out = new IntTuple(0,-1);
                break;
            case 'E': out = new IntTuple(1, 0);
                break;
            case 'W': out = new IntTuple(-1,0);
                break;
            default:
                throw new RuntimeException("bad initial direction: " + d);
        }
        return out;
    }

    public Direction(char dir) throws RuntimeException{
        super(directionConverter(dir));
    }

    /*
    helper function to multiply a direction by the matrix
    [ a00 a10
      a01 a11 ]
     */
    private void matrixMultiply(int a00, int a10, int a01, int a11) {
        int newx = this.x * a00 + this.y * a10;
        int newy = this.x * a01 + this.y * a11;
        this.x = newx;
        this.y = newy;
    }

    /*
    left rotation is multiplication by
    [ 0 -1
      1 0 ]
     */
    public void rotateLeft() {
        this.matrixMultiply(0,-1,1,0);
    }

    /*
    right rotation is multiplication by
    [ 0 1
      -1 0 ]
     */
    public void rotateRight() {
        this.matrixMultiply(0,1,-1,0);
    }
}

