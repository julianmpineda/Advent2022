import java.io.*;
import java.util.*;

public class day8 {
    public static void main(String[] args) {

        List<String> fileLines = new ArrayList<String>();
        int xAxis = 0, yAxis = 0;
        int visTreeCount = 0;
        int maxScore = Integer.MIN_VALUE;

        try {
            File myObj = new File("data8.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                fileLines.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        xAxis = fileLines.size();
        yAxis = fileLines.get(0).length();

        //2 Arrays: 1. Data, 2. Data flipped on the diagonal
        int[][] forest = new int[yAxis][xAxis];
        int[][] forest90 = new int[xAxis][yAxis];

        //Create both original and flipped arrays
        for (int i = 0; i < xAxis; i++) {
            char[] temp = fileLines.get(i).toCharArray();
            for (int j = 0; j < xAxis; j++) {
                forest[i][j] = temp[j] - '0';
                forest90[j][i] = forest[i][j];
            }
        }

        //Use recursion to check both visibility and scenic score
        for (int i = 0; i < yAxis; i++) {
            for (int j = 0; j < xAxis; j++) {
                int tree = forest[i][j];
                int[] left = upLeft(tree, j, forest[i]);
                int[] right = downRight(tree, j, forest[i]);
                int[] up = upLeft(tree, i, forest90[j]);
                int[] down = downRight(tree, i, forest90[j]);

                if (left[0] + right[0] + up[0] + down[0] > 0) {
                    visTreeCount++;
                }

                int scenicScore = left[1] * right[1] * up[1] * down[1];
                maxScore = Integer.max(maxScore, scenicScore);
            }

        }

        System.out.println(visTreeCount + " trees visible");
        System.out.println(maxScore + " is the best scenic score");
    }

    //checks both up and left, uses the flipped matrix for vertical
    private static int[] upLeft(int height, int x, int[] test) {
        //return [visible flag 1:0 , count of visible trees]
        int count = 1;
        if (x != 0) {
            if (test[x-1] >= height) {
                return new int[]{0, 1};
            } else {
                int temp[] = upLeft(height, x-1, test);
                count += temp[1];
                return new int[]{temp[0], count};
            }
        }
        return new int[]{1, 0};
    }

    //checks both down and right, uses the flipped matrix for vertical
    private static int[] downRight(int height, int x, int[] test) {
        //return [visible flag 1:0 , count of visible trees]
        int count = 1;
        if (x != test.length-1) {
            if (test[x+1] >= height) {
                return new int[]{0, 1};
            } else {
                int temp[] = downRight(height, x+1, test);
                count += temp[1];
                return new int[]{temp[0], count};
            }
        }
        return new int[]{1, 0};
    }
}
