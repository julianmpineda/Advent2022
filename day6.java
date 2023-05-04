import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {

        int test = 3;
        String testSeq = "";
        String input = "";
        boolean markerFound = false;

        try {
            File myObj = new File("data6.txt");
            Scanner myReader = new Scanner(myObj);
            input = myReader.nextLine();
            myReader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

	      //test sequence from the rear, saves time if the matching pair is char 3 and 4. Skip test to remove offending character
        while (!markerFound && test < input.length()) {
            testSeq = input.substring(test - 3, test + 1);

            if (testSeq.charAt(2) == testSeq.charAt(3)) {
                test += 3;
            } else if (testSeq.charAt(1) == testSeq.charAt(2) || testSeq.charAt(1) == testSeq.charAt(3)) {
                test += 2;
            } else if (testSeq.charAt(0) == testSeq.charAt(1) || testSeq.charAt(0) == testSeq.charAt(2) || testSeq.charAt(0) == testSeq.charAt(3)) {
                test++;
            } else {
                markerFound = true;
            }
        }

        System.out.println("Marker after char: " + (test + 1));
	}
}
