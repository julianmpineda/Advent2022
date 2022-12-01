import java.util.*;
import java.io.*;
public class day1 {
    public static void main(String[] args) {
        int maxOne = -1;
        int totalCal = 0;
        int count = 0;

        try {
            File myObj = new File("data1.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                if (!temp.equals("")) {
                    System.out.print("new int");
                    totalCal += Integer.parseInt(temp);
                    System.out.println (" " + totalCal);
                } else {
                    count++;
                    max = Math.max(totalCal, max);
                    totalCal = 0;
                    System.out.println("elf " + count + " done");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(max);
    }
}
