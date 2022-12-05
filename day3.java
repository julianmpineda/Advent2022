import java.util.*;
import java.io.*;

public class day3 {

    public static void main(String[] args) {
        List<String> rucksacks = new ArrayList<String>();
        int priorityCount = 0;
        int badgeCount = 0;

        try {
            File myObj = new File("data3.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                rucksacks.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < rucksacks.size(); i++) {
            String bag = rucksacks.get(i);
            String[] compartments = {bag.substring(0, bag.length() / 2), bag.substring(bag.length() / 2)};
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

        for (int j = 0; j < rucksacks.size(); j++) {
            String bagOne = rucksacks.get(j);
            String bagTwo = rucksacks.get(++j);
            String bagThree = rucksacks.get(++j);
            boolean found = false;
            int count = 0;

            while (!found && count < bagOne.length()) {
                char item = bagOne.charAt(count);
                if (bagTwo.indexOf(item) >= 0 && bagThree.indexOf(item) >= 0) {
                    if (Character.isUpperCase(item)) {
                        badgeCount += item - 38;
                    } else {
                        badgeCount += item - '`';
                    }
                    found = true;
                } else {
                    count++;
                }
            }
        }
        System.out.println("Part 2: " + badgeCount);
    }
}
