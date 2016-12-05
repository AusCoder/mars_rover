import vectors.IntTuple;
import vectors.Direction;

/*
Rover class
It maintains internal state of direction and position.
Has reference to a Plateau object.
It interprets movement commands that modify its internal state.
 */
public class Rover {
    private IntTuple position;
    private Direction direction;
    private Plateau plateau;

    public Rover(int x, int y, char d, Plateau plat) {
        this.position = new IntTuple(x,y);
        this.direction = new Direction(d);
        this.plateau = plat;
    }

    public void move(char command) throws RuntimeException {
        switch (command) {
            case 'M':
                if (!this.canMove()) {
                    throw new RuntimeException("we fell off the plateau! current state: " + this.toString());
                }
                this.position.add(this.direction);
                break;
            case 'L':
                this.direction.rotateLeft();
                break;
            case 'R':
                this.direction.rotateRight();
                break;
            default:
                throw new RuntimeException("unknown move command: " + command);
        }
    }

    private boolean canMove() {
        if (this.position.x + this.direction.x < 0) {
            return false;
        } else if (this.position.x + this.direction.x > this.plateau.boundX) {
            return false;
        } else if (this.position.y + this.direction.y > this.plateau.boundY) {
            return false;
        } else if (this.position.y + this.direction.y < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%d %d %c ", this.position.x, this.position.y, this.convertDirection());
    }

    private char convertDirection() {
        int x = this.direction.x;
        int y = this.direction.y;
        if (x == 0 && y == 1) {
            return 'N';
        } else if (x == 0 && y == -1) {
            return 'S';
        } else if (x == 1 && y == 0) {
            return 'E';
        } else {
            return 'W';
        }
    }
    public IntTuple getPosition() {
        return this.position;
    }
    public Direction getDirection() {
        return this.direction;
    }
}
