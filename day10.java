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
            if (command.equals("noop")) {
                cycleCount++;
                if ((cycleCount == 20 || (cycleCount - 20)%40 == 0)) {
                    signalSum += x*cycleCount;
                }
            } else if (command.equals("addx")) {
                for (int j = 0; j < 2; j++) {
                    cycleCount++;
                    if (cycleCount == 20 || (cycleCount - 20)%40 == 0 ) {
                        signalSum += x*cycleCount;
                    }
                    if (j == 1) {
                        x += Integer.parseInt(instructions.get(i).substring(5));
                    }
                }
            }
            i++;
        }
        System.out.println("Signal Strengths Sum: " + signalSum);
    }
}
