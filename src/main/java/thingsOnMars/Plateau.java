package thingsOnMars;

import java.util.LinkedList;
import java.util.List;

/*
Keeps track of the plateau size and rovers on the plateau
 */
public class Plateau {
    public List<Rover> rovers = new LinkedList<>();
    public int boundX;
    public int boundY;

    public Plateau(int x, int y) {
        this.boundX = x;
        this.boundY = y;
    }

    /*
     * adds a new rover to the plateau
     * throws runtime exception if rover already exists at that position
     */
    public void addRover(Rover newRov) throws RuntimeException {
        int newX = newRov.getPosition().x;
        int newY = newRov.getPosition().y;
        if (newX < 0 || newX > boundX || newY < 0 || newY > boundY) {
            throw new RuntimeException("arrrrrgh! the rover fell into oblivion! position: " + newRov);
        }
        for (Rover rov : this.rovers) {
            int x = rov.getPosition().x;
            int y = rov.getPosition().y;
            if (newRov.getPosition().x == x && newRov.getPosition().y == y) {
                throw new RuntimeException("craaaash! a rover crashed ontop of another rover! position: " + newRov);
            }
        }
        rovers.add(newRov);
    }
}
