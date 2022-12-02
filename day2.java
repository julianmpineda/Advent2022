import java.util.*;
import java.io.*;

public class day2 {
    public static void main(String[] args) {

        List <String[]> strat = new ArrayList<String[]>();
        int totalHand = 0;

        try {
            File myObj = new File("C:\\Users\\jpin3\\IdeaProjects\\AdventOfCode2022\\src\\data2");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                strat.add(myReader.nextLine().split(" "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < strat.size(); i++) {
            char opponentHand = strat.get(i)[0].charAt(0);
            char playerHand = strat.get(i)[1].charAt(0);

            /*
            A = X = Rock
            B = Y = Paper
            C = Z = Scissors
             */

            switch (playerHand) {
                case 'X':
                    if (opponentHand == 'A') {
                        totalHand += 3;
                    } else if (opponentHand == 'B') {
                        totalHand += 0;
                    } else {
                        totalHand += 6;
                    }
                
                    totalHand += 1;
                    break;
                
                case 'Y':
                    if (opponentHand == 'A') {
                        totalHand += 6;
                    } else if (opponentHand == 'B') {
                        totalHand += 3;
                    } else {
                        totalHand += 0;
                    }
                
                    totalHand += 2;
                    break;
                
                case 'Z':
                    if (opponentHand == 'A') {
                        totalHand += 0;
                    } else if (opponentHand == 'B') {
                        totalHand += 6;
                    } else {
                        totalHand += 3;
                    }
                
                    totalHand += 3;
                    break;
            }
          
        }
        System.out.println(totalHand);
    }
}
