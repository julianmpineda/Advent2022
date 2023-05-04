import java.io.*;
import java.util.*;

public class day8 {
    public static void main(String[] args) {

        List<String> fileLines = new ArrayList<String>();
        int xAxis = 0, yAxis = 0;
        int visTreeCount = 0;

        try {
            File myObj = new File("data8.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                fileLines.add(myReader.nextLine());
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        xAxis = fileLines.get(0).length();
        yAxis = fileLines.size();

        //3 Arrays: 1. Data, 2. Data flipped on the diagonal, 3. Tree Visibility Array
        int[][] forest = new int[xAxis][yAxis];
        int[][] forest90 = new int[yAxis][xAxis];
        int[][] visForest = new int[yAxis][xAxis];

        //Create both original and flipped arrays
        for (int i = 0; i < yAxis; i++) {
            char[] temp = fileLines.get(i).toCharArray();
            for (int j = 0; j < yAxis; j++) {
                forest[i][j] = temp[j] - '0';
                forest90[j][i] = forest[i][j];
            }
        }

        //Use recursion to check along line while still shorter than tree
        for (int i = 0; i < xAxis; i++) {
            for (int j = 0; j < yAxis; j++) {
                int tree = forest[i][j];
                if (checkLeft(tree, j, forest[i]) || checkRight(tree, j, forest[i]) || checkUp(tree, i, forest90[j]) || checkDown(tree, i, forest90[j])){
                    visTreeCount++;
                    visForest[j][i] = 1;
                }
            }
        }
        System.out.println(visTreeCount + " trees visible");

    }

    private static boolean checkLeft(int height, int x, int[] test) {
        if (x != 0) {
            if (test[x-1] >= height) {
                return false;
            } else {
                return checkLeft(height, x-1, test);
            }
        }
        return true;
    }

    private static boolean checkRight(int height, int x, int[] test) {
        if (x != test.length-1) {
            if (test[x+1] >= height) {
                return false;
            } else {
                return checkRight(height,x+1, test);
            }
        }
        return true;
    }

    private static boolean checkUp(int height, int y, int[] test) {
        if (y != 0) {
            if (test[y-1] >= height) {
                return false;
            } else {
                return checkUp(height,y-1, test);
            }
        }
        return true;
    }

    private static boolean checkDown(int height, int y, int[] test) {
        if (y != test.length-1) {
            if (test[y+1] >= height) {
                return false;
            } else {
                return checkDown(height,y+1, test);
            }
        }
        return true;
    }
}
