import java.io.*;
import java.util.*;
public class day10 {
    public static void main(String[] args) {

        int x = 1, i = 0, cycleCount = 1, signalSum = 0;
        String screen = "";
        List<String> instructions = new ArrayList<String>();


        try {
            File myObj = new File("data10.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                instructions.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (cycleCount <= 240) {
            String command = instructions.get(i).substring(0,4);

            if ((cycleCount - 20)%40 == 0) {
                signalSum += x*cycleCount;
            }

            if (command.equals("noop")) {

                screen += pixelPrint(x, cycleCount-1);
                cycleCount++;

            } else if (command.equals("addx")) {

                screen += pixelPrint(x, cycleCount-1);
                cycleCount++;

                if ((cycleCount - 20)%40 == 0) {
                    signalSum += x*cycleCount;
                }

                screen += pixelPrint(x, cycleCount-1);
                x += Integer.parseInt(instructions.get(i).substring(5));
                cycleCount++;
                }
            i++;
            }

        System.out.println("Signal Strengths Sum: " + signalSum);

        for (int j = 0; j <screen.length(); j++) {
            System.out.print(screen.charAt(j));
            if ((j+1)%40 == 0) {
                System.out.print("\n");
            }
        }
    }
