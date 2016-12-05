import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (String line = stdin.readLine(); line != null; line = stdin.readLine()) {
                String[] splitInputLine = line.split(" ");
                Integer boundX = Integer.parseInt(splitInputLine[0]);
                Integer boundY = Integer.parseInt(splitInputLine[1]);

                Plateau plateau = new Plateau(boundX, boundY);

                for (int roverIdx = 2; roverIdx < splitInputLine.length; roverIdx += 4) {
                    int initX = Integer.parseInt(splitInputLine[roverIdx]);
                    int initY = Integer.parseInt(splitInputLine[roverIdx + 1]);
                    char initDir = splitInputLine[roverIdx + 2].charAt(0);
                    String moves = splitInputLine[roverIdx + 3];

                    try {
                        Rover rudolfTheRover = new Rover(initX, initY, initDir, plateau);
                        for (char command : moves.toCharArray()) {
                            rudolfTheRover.move(command);
                        }
                        System.out.print(rudolfTheRover);
                    }
                    catch (RuntimeException e) {
                        System.out.print("oh no! " + e.getMessage());
                        continue;
                    }
                }
                System.out.println();
            }
        }
        catch (IOException e) {
            System.err.println("error reading file");
            e.printStackTrace();
        }
    }
}