
import java.io.*;
import java.util.*;

public class day9 {
    public static void main(String[] args) {

        List<String> track = new ArrayList<String>();
        List<String[]> directions = new ArrayList<String[]>();
        int[] posHead = new int[]{0,0};
        int[] posTail = new int[]{0,0};

        track.add("0 0");

        try {
            File myObj = new File("data9.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                directions.add(myReader.nextLine().split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < directions.size(); i++) {
            String[] move = directions.get(i);
            int steps = Integer.parseInt(move[1]);
            int[] temp = new int[4];

            for (int j = 0; j< steps; j++){
                temp = moveKnot(move[0], posHead, posTail);
                String strPos = "" + temp[2] + " " + temp[3];
                if (!track.contains(strPos)) {
                    track.add(strPos);
                }
            }
        }
        System.out.println("sumTrack: " + track.size());
    }
    public static int[] moveKnot(String move, int[] head, int [] tail) {

        int direction = 0, axis = 0;
        int[] headNew = new int[2];

        switch (move) {
            case "R" :
                direction = 1;
                axis = 0;
                break;
            case "U":
                direction = 1;
                axis = 1;
               break;
            case "L":
                direction = -1;
                axis = 0;
                break;
            case "D":
                direction = -1;
                axis  = 1;
                break;
        }
            headNew[axis] = head[axis] + direction;
            if (Math.abs(headNew[axis] - tail[axis]) > 1) {
                tail[0] = head[0];
                tail[1] = head[1];
            }
            head[axis] = headNew[axis];

        return new int[]{headNew[0], headNew[1], tail[0],tail[1]};
    }
}
