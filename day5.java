/*
[D]                     [N] [F]    
[H] [F]             [L] [J] [H]    
[R] [H]             [F] [V] [G] [H]
[Z] [Q]         [Z] [W] [L] [J] [B]
[S] [W] [H]     [B] [H] [D] [C] [M]
[P] [R] [S] [G] [J] [J] [W] [Z] [V]
[W] [B] [V] [F] [G] [T] [T] [T] [P]
[Q] [V] [C] [H] [P] [Q] [Z] [D] [W]
 1   2   3   4   5   6   7   8   9 
*/

import java.io.*;
import java.util.*;
public class day5 {
    public static void main(String[] args) {

    //Hardcoded Stacks

        List<List<Character>> crates = new ArrayList<>();
        List<Character> boxStack = new ArrayList<Character>();
        Boolean crateMover9001 = true;

        //stack 1, ind 0
        boxStack.add('Q');
        boxStack.add('W');
        boxStack.add('P');
        boxStack.add('S');
        boxStack.add('Z');
        boxStack.add('R');
        boxStack.add('H');
        boxStack.add('D');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 2, ind 1
        boxStack.add('V');
        boxStack.add('B');
        boxStack.add('R');
        boxStack.add('W');
        boxStack.add('Q');
        boxStack.add('H');
        boxStack.add('F');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 3, ind 2
        boxStack.add('C');
        boxStack.add('V');
        boxStack.add('S');
        boxStack.add('H');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 4, ind 3
        boxStack.add('H');
        boxStack.add('F');
        boxStack.add('G');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 5, ind 4
        boxStack.add('P');
        boxStack.add('G');
        boxStack.add('J');
        boxStack.add('B');
        boxStack.add('Z');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 6, ind 5
        boxStack.add('Q');
        boxStack.add('T');
        boxStack.add('J');
        boxStack.add('H');
        boxStack.add('W');
        boxStack.add('F');
        boxStack.add('L');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 7, ind 6
        boxStack.add('Z');
        boxStack.add('T');
        boxStack.add('W');
        boxStack.add('D');
        boxStack.add('L');
        boxStack.add('V');
        boxStack.add('J');
        boxStack.add('N');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 8, ind 7
        boxStack.add('D');
        boxStack.add('T');
        boxStack.add('Z');
        boxStack.add('C');
        boxStack.add('J');
        boxStack.add('G');
        boxStack.add('H');
        boxStack.add('F');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //stack 9, ind 8
        boxStack.add('W');
        boxStack.add('P');
        boxStack.add('V');
        boxStack.add('M');
        boxStack.add('B');
        boxStack.add('H');

        crates.add(new ArrayList<>(boxStack));

        boxStack.clear();

        //end Hardcoded Stacks

        List<String> commands = new ArrayList<String>();

        try {
            File myObj = new File("data5.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                commands.add(myReader.nextLine());
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        
        int count = 0;

        if (crateMover9001) {
            while (count < commands.size()) {

                String comNum = commands.get(count).replaceAll("\\D", " ");
                Scanner comScan = new Scanner(comNum);
                int[] commandNum = new int[3];

                for (int i = 0; i < 3; i++) {
                    commandNum[i] = comScan.nextInt();
                    //change from stack number to index
                    if (i == 1 || i == 2) {
                        commandNum[i] -= 1;
                    }
                }

                String moveStack = "";
                //[Remove X boxes from Y, add to moveStack]
                for (int j = 0; j < commandNum[0]; j++) {
                    char box = crates.get(commandNum[1]).get(crates.get(commandNum[1]).size() - 1);
                    moveStack += box;
                    crates.get(commandNum[1]).remove(crates.get(commandNum[1]).size() - 1);
                }

                //Reverse, now pull from moveStack front and add to the Z stack
                for (int k = commandNum[0]; k > 0; k--) {
                    crates.get(commandNum[2]).add(moveStack.charAt(k-1));
                    moveStack = moveStack.substring(0, moveStack.length()-1);
                }

                count++;
            }
        } else {
            while (count < commands.size()) {

                String comNum = commands.get(count).replaceAll("\\D", " ");
                Scanner comScan = new Scanner(comNum);
                int[] commandNum = new int[3];

                for (int i = 0; i < 3; i++) {
                    commandNum[i] = comScan.nextInt();
                    //change from stack number to index
                    if (i == 1 || i == 2) {
                        commandNum[i] -= 1;
                    }
                }

                //[Move X boxes from Y to Z]
                for (int j = 0; j < commandNum[0]; j++) {
                    char box = crates.get(commandNum[1]).get(crates.get(commandNum[1]).size() - 1);
                    crates.get(commandNum[1]).remove(crates.get(commandNum[1]).size() - 1);
                    crates.get(commandNum[2]).add(box);
                }
                count++;
            }
        }
        //printout result

        for (List<Character> c : crates) {
            System.out.print(c.get(c.size()-1));
        }
    }
}
