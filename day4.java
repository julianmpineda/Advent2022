import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) {
        List<int[]> sections = new ArrayList<int[]>(4);
        int fullOverlapCount = 0;
        int anyOverlapCount = 0;

        try {
            File myObj = new File("data4.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] sectionsStr = myReader.nextLine().split(",|-");
                int[] sectionsTemp = new int[4];

                for (int i = 0; i < 4; i++) {
                    sectionsTemp[i] = Integer.parseInt(sectionsStr[i]);
                }

                sections.add(sectionsTemp);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < sections.size(); j++) {
            int[] elves = sections.get(j);

            if ((elves[0] <= elves[2] && elves[1] >= elves[3]) 
                || (elves[2] <= elves[0] && elves[3] >= elves[1])) {
                                fullOverlapCount++;
            }

            // broken down into 2 if-statements; can be done in one single if-statement but hard to parse.

            //check to see if second range starts or ends within first
            if (((elves[0] <= elves[2] && elves[2] <= elves[1])
                    || (elves[0] <= elves[3] && elves[3] <= elves[1]))) {
                anyOverlapCount++;

                //check to see if first range starts or ends within second
            } else if ((elves[2] <= elves[0] && elves[0] <= elves[3])
                    || (elves[2] <= elves[1] && elves[1] <= elves[3])) {
                anyOverlapCount++;
            }
        }

        System.out.println("Part 1: "  + fullOverlapCount);
        System.out.println("Part 2: "  + anyOverlapCount);
    }
}
