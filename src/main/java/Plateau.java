import java.util.LinkedList;
import java.util.List;

/*
Keeps track of the plateau size and rovers on the plateau
 */
public class Plateau {
    List Rovers = new LinkedList();
    public int boundX;
    public int boundY;

    public Plateau(int x, int y) {
        this.boundX = x;
        this.boundY = y;
    }
}
