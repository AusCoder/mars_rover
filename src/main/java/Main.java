import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.LinkedList;

/*
Code structure:
2 main classes: Plateau and Rover
Plateau holds a size and a list of Rovers, it also performs some collision checks when a new Rover is added.
Rover holds position and direction and a reference to the plateau it sits on.
Rover interprets move commands: it first checks for valid move, then makes the move.

The vectors package contains some useful classes for representing positions and directions.
 */

public class Main {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            /* read many lines from stdin
             * each line describes a plateau and one or move rovers */
            for (String line = stdin.readLine(); line != null; line = stdin.readLine()) {
                String[] splitInputLine = line.split(" ");
                /* get plateau size */
                Integer boundX = Integer.parseInt(splitInputLine[0]);
                Integer boundY = Integer.parseInt(splitInputLine[1]);

                /* create new plateau and a list to store the rovers move strings */
                Plateau plateau = new Plateau(boundX, boundY);
                List<String> listOfMoves =  new LinkedList<>();
                
                try {
                    /* read rover information and add to plateau */
                    for (int roverIdx = 2; roverIdx < splitInputLine.length; roverIdx += 4) {
                        int initX = Integer.parseInt(splitInputLine[roverIdx]);
                        int initY = Integer.parseInt(splitInputLine[roverIdx + 1]);
                        char initDir = splitInputLine[roverIdx + 2].charAt(0);
                        String moves = splitInputLine[roverIdx + 3];

                        Rover rudolfTheRover = new Rover(initX, initY, initDir, plateau);
                        plateau.addRover(rudolfTheRover);
                        listOfMoves.add(moves);
                    }
                    /* run through each rover and apply its move commands */
                    for (int idx = 0 ; idx < plateau.rovers.size(); idx++) {
                        Rover rudolfTheRover = plateau.rovers.get(idx);
                        String moves = listOfMoves.get(idx);

                        for (char command : moves.toCharArray()) {
                            rudolfTheRover.move(command);
                        }
                        System.out.print(rudolfTheRover);
                    }
                    System.out.println();
                }
                catch (RuntimeException e) {
                    /* print any unfortunate rover related events! */
                    System.out.println("oh no! " + e.getMessage());
                    continue;
                }
            }
        }
        catch (IOException e) {
            System.err.println("error reading file");
            e.printStackTrace();
        }
    }
}
