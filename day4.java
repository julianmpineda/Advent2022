import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) {
        List<int[]> sections = new ArrayList<int[]>(4);
        int overlapCount = 0;

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
                overlapCount++;
            }
        }
        System.out.println("Part 1: "  + overlapCount);
    }
}
