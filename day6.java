import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {
	    
        int test = 4, testTwo = 14;
        String input = "";
        boolean markerFound = false;
        boolean messageFound = false;

        try {
            File myObj = new File("data6.txt");
            Scanner myReader = new Scanner(myObj);
            input = myReader.nextLine();
            myReader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!(markerFound && messageFound)) {
            //Find Marker first
            if (!markerFound) {
                if (checker(input.substring(test - 4, test)) == true) {
                    System.out.println("Marker after char: " + (test));
                    markerFound = true;
                    testTwo = test + 10;
                } else {
                    test++;
                }
            }

            //Start testing at Marker 0 index to avoid retesting
            if (markerFound && !messageFound) {
                if (checker(input.substring(testTwo - 14, testTwo)) == true) {
                    System.out.println("Marker after char: " + (testTwo));
                    messageFound = true;
                } else {
                    testTwo++;
                }
            }
        }
    }

    //Tests by moving chars into an array and tallying the numbers. Returns false when it detects the first repeat.
    public static boolean checker(String testStr) {
        int testLen = testStr.length();

        char[] alphaArr = new char[26];
        char[] testArr = testStr.toCharArray();

        for (int i = 0; i < testLen; i++) {
            alphaArr[(testArr[i] - 'a')]++;
            if (alphaArr[(testArr[i] - 'a')] > 1) {
                return false;
            }
        }

        return true;
    }
}
