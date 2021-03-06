package thingsOnMars;

import vectors.IntTuple;
import vectors.Direction;

/*
Rover class
It maintains internal state of direction and position.
Has reference to a Plateau object.
It interprets movement commands that modify its internal state.
 */
public class Rover {
    IntTuple position;
    Direction direction;
    Plateau plateau;

    public Rover(int x, int y, char d, Plateau plat) {
        this.position = new IntTuple(x,y);
        this.direction = new Direction(d);
        this.plateau = plat;
    }

    /*
    method to move the Rover based on a command
     */
    public void move(char command) throws RuntimeException {
        switch (command) {
            case 'M':
                if (this.willFall()) {
                    throw new RuntimeException("arrrrgh! we fell off the plateau! position: " + this.toString());
                }
                if (this.willCollide()) {
                    throw new RuntimeException("booooom! we ran into another rover! position: " + this.toString());
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
                throw new RuntimeException("this does not compute! unknown command: " + command);
        }
    }

    /*
    method to check if Rover will fall off plateau
     */
    private boolean willFall() {
        if (this.position.x + this.direction.x < 0) {
            return true;
        } else if (this.position.x + this.direction.x > this.plateau.boundX) {
            return true;
        } else if (this.position.y + this.direction.y > this.plateau.boundY) {
            return true;
        } else if (this.position.y + this.direction.y < 0) {
            return true;
        }
        return false;
    }

    /*
    method to check if Rover will collide with another rover
     */
    private boolean willCollide() {
        for (Rover rov : plateau.rovers) {
            if (this.position.x + this.direction.x == rov.position.x && this.position.y + this.direction.y == rov.position.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d %d %c ", this.position.x, this.position.y, this.convertDirectionToChar());
    }

    private char convertDirectionToChar() {
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
