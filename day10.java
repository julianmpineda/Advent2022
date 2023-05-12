import java.io.*;
import java.util.*;
public class day10 {
    public static void main(String[] args) {

        int x = 1, i = 0, cycleCount = 0, signalSum = 0;
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

        while (cycleCount < 220) {
            String command = instructions.get(i).substring(0,4);
            if ((cycleCount == 20 || (cycleCount - 20)%40 == 0)) {
                System.out.println("Cycle " + cycleCount + ": x: " + x + " signal strength: " + x*cycleCount);
                signalSum += x*cycleCount;
            }

            if (command.equals("noop")) {
                cycleCount++;
            } else if (command.equals("addx")) {
                    cycleCount++;
                    if (cycleCount == 20 || (cycleCount - 20)%40 == 0 ) {
                        System.out.println("Cycle " + cycleCount + ": x: " + x + " signal strength: " + x*cycleCount);
                        signalSum += x*cycleCount;
                    }
                    x += Integer.parseInt(instructions.get(i).substring(5));
                    cycleCount++;
                }
            i++;
        }
        System.out.println("Signal Strengths Sum: " + signalSum);
    }
}
