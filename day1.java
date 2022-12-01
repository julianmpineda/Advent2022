import java.util.*;
import java.io.*;
public class day1 {
    public static void main(String[] args) {
        int max = -1;
        int totalCal = 0;
        int topThree = 0;
        int index = 0;
        List<Integer> totals = new ArrayList<Integer>();

        try {
            File myObj = new File("C:\\Users\\jpin3\\IdeaProjects\\AdventOfCode2022\\src\\day1.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                if (!temp.equals("")) {
                    totalCal += Integer.parseInt(temp);
                } else {
                    totals.add(totalCal);
                    totalCal = 0;
                }
            }
            /* Adds anything left over, otherwise will be lost. */
            totals.add(totalCal);
            totalCal = 0;
            
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 2; i++) {
            max = -1;
            for (int j = 0; j < totals.size(); j++) {
                /* if statement allows us to also set the index, Math.max does not easily allow */
                if (totals.get(j) > max) {
                    max = totals.get(j);
                    index = j;
                }
            }
            if (i == 0) {
                System.out.println("Part 1: " + max);
            }
            totals.remove((totals.indexOf(max)));
            topThree += max;
        }

        System.out.println("Part 2: " + topThree);
    }
}
