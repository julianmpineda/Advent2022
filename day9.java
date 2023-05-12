
import java.io.*;
import java.util.*;

public class day9 {
    public static void main(String[] args) {

        List<String> track = new ArrayList<String>();
        List<String[]> directions = new ArrayList<String[]>();
        int[] posHead = new int[]{0, 0};
        int[] posTail = new int[]{0, 0};
        int[] knots = new int[20];
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

            int[] temp = new int[2];
            int[] tempHead = new int[2];
            String[] move = directions.get(i);
            int steps = Integer.parseInt(move[1]);

            for (int j = 0; j < steps; j++) {
                temp = moveKnot(move[0], true, new int[]{knots[0], knots[1]}, new int[]{knots[2], knots[3]});
                knots[0] = temp[0];
                knots[1] = temp[1];
                
                for (int k = 0; k < 17; k++) {
                    temp = moveKnot(move[0], false, new int[]{knots[k], knots[k+1]}, new int[]{knots[k+2], knots[k+3]});
                    knots[k + 2] = temp[0];
                    knots[k + 3] = temp[1];
                    k++;
                }
                String strPos = "" + knots[18] + " " + knots[19];
                
                if (!track.contains(strPos)) {
                    track.add(strPos);
                }
            }
        }
        
        System.out.println("sumTrack: " + track.size());
    }

    public static int[] moveKnot(String move, boolean firstKnot, int[] head, int[] tail) {

        int direction = 0, axis = 0, unAxis = 0;
        int[] posNew = new int[2];

        switch (move) {
            case "R":
                direction = 1;
                unAxis = 1;
                break;
            case "U":
                direction = 1;
                axis = 1;
                break;
            case "L":
                direction = -1;
                unAxis = 1;
                break;
            case "D":
                direction = -1;
                axis = 1;
                break;
        }

        if (firstKnot) {

            posNew[axis] = head[axis] + direction;
            posNew[unAxis] = head[unAxis];

            return new int[]{posNew[0], posNew[1]};

        } else if ((Math.abs(head[0] - tail[0]) + Math.abs(head[1] - tail[1]) > 2)) {
            if (head[0] > tail[0]) {
                posNew[0] = tail[0] + 1;
            } else if (head[0] < tail[0]) {
                posNew[0] = tail[0] - 1;
            }
            if (head[1] > tail[1]) {
                posNew[1] = tail[1] + 1;
            } else if (head[1] < tail[1]) {
                posNew[1] = tail[1] - 1;
            }

        } else {
            if ((Math.abs(head[0] - tail[0])) > 1) {

                if (head[0] > tail[0]) {
                    posNew[0] = tail[0] + 1;
                } else if (head[0] < tail[0]) {
                    posNew[0] = tail[0] - 1;
                }
            } else {
                posNew[0] = tail[0];
            }

            if (Math.abs(head[1] - tail[1]) > 1) {
                if (head[1] > tail[1]) {
                    posNew[1] = tail[1] + 1;
                } else if (head[1] < tail[1]) {
                    posNew[1] = tail[1] - 1;
                }
            } else {
                posNew[1] = tail[1];
            }
        }
        return new int[]{posNew[0], posNew[1]};
    }
}
