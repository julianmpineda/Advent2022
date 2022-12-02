import java.util.*;
import java.io.*;

public class day2 {
    public static void main(String[] args) {

        List <String[]> strat = new ArrayList<String[]>();
        int totalHand = 0;

        try {
            File myObj = new File("data2.txt");

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
        System.out.println("Part 1: " + totalHand);

        //Part 2 starts here.
        totalHand = 0;

        for (int j = 0; j < strat.size(); j++) {
            char opponentHand = strat.get(j)[0].charAt(0);
            char playerHand = strat.get(j)[1].charAt(0);

            /*
            A = Rock
            B = Paper
            C = Scissors

            X = Lose
            Y = Draw
            Z = Win
             */

            switch (opponentHand) {
                case 'A':
                    if (playerHand == 'X') {
                        totalHand += 3;
                    } else if (playerHand == 'Y') {
                        totalHand += 4;
                    } else {
                        totalHand += 8;
                    }
                    break;
                case 'B':
                    if (playerHand == 'X') {
                        totalHand += 1;
                    } else if (playerHand == 'Y') {
                        totalHand += 5;
                    } else {
                        totalHand += 9;
                    }
                    break;
                case 'C':
                    if (playerHand == 'X') {
                        totalHand += 2;
                    } else if (playerHand == 'Y') {
                        totalHand += 6;
                    } else {
                        totalHand += 7;
                    }
                    break;
            }

        }
        System.out.println("Part 2: " + totalHand);
    }
}
