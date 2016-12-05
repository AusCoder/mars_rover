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
        for (Rover rov : this.rovers) {
            int x = rov.getPosition().x;
            int y = rov.getPosition().y;
            if (newRov.getPosition().x == x && newRov.getPosition().y == y) {
                throw new RuntimeException("craaaash! a rover crashed ontop of another! position: " + newRov);
            }
        }
        rovers.add(newRov);
    }
}
