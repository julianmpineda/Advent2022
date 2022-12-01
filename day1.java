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
        
        Collections.sort(totals, Collections.reverseOrder());
        
        System.out.println("Part 1: " + totals.get(0));
        
        topThree = totals.get(0) + totals.get(1) + totals.get(2);

        System.out.println("Part 2: " + topThree);
    }
}
