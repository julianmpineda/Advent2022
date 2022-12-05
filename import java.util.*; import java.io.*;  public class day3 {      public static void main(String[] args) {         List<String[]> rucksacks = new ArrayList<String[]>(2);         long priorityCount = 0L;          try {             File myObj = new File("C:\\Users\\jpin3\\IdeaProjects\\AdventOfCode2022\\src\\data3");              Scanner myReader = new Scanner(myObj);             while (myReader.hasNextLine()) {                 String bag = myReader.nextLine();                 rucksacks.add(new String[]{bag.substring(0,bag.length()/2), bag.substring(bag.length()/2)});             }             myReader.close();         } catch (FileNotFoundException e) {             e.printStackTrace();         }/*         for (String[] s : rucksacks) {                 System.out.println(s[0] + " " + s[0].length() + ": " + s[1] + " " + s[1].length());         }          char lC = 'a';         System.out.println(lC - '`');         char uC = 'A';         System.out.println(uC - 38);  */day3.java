import java.util.*;
import java.io.*;

public class day3 {

    public static void main(String[] args) {
        List<String[]> rucksacks = new ArrayList<String[]>(2);
        int priorityCount = 0;

        try {
            File myObj = new File("data3");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String bag = myReader.nextLine();
                rucksacks.add(new String[]{bag.substring(0,bag.length()/2), bag.substring(bag.length()/2)});
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < rucksacks.size(); i++) {
            String[] compartments = rucksacks.get(i);
            boolean found = false;
            int count = 0;

            while (!found && count < compartments[0].length()) {
                char item = compartments[0].charAt(count);
                if (compartments[1].indexOf(item) >= 0) {
                    if (Character.isUpperCase(item)) {
                        priorityCount += item - 38;
                    } else {
                        priorityCount += item - '`';
                    }
                    found = true;
                } else {
                    count++;
                }
            }
        }

        System.out.println("Part 1: " + priorityCount);
    }
}
