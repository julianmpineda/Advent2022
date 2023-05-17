import java.io.*;
import java.util.*;

public class day11 {
    public static void main(String[] args) {
        List<Long> monkey0 = new ArrayList<Long>(Arrays.asList(59L,65L,86L,56L,74L,57L,56L));
        List<Long> monkey1 = new ArrayList<Long>(Arrays.asList(63L,83L,50L,63L,56L));
        List<Long> monkey2 = new ArrayList<Long>(Arrays.asList(93L,79L,74L,55L));
        List<Long> monkey3 = new ArrayList<Long>(Arrays.asList(86L,61L,67L,88L,94L,69L,56L,91L)) ;
        List<Long> monkey4 = new ArrayList<Long>(Arrays.asList(76L,50L,51L));
        List<Long> monkey5 = new ArrayList<Long>(Arrays.asList(77L,76L));
        List<Long> monkey6 = new ArrayList<Long>(Arrays.asList(74L));
        List<Long> monkey7 = new ArrayList<Long>(Arrays.asList(86L,85L,52L,86L,91L,95L));
        long[] inspections = new long[8];
        int count = 0;
        int worryDiv = 3;
        int rounds = 20;
        int part = 0;

        //set flag for part 1 and part 2
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Part 1 or 2? ");
        try {
            part = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (part == 2) {
            worryDiv = 1;
            rounds = 10000;
        }

        while (count < rounds) {

            //Monkey 0 code
            inspections[0] += monkey0.size();
            for (Long item : monkey0) {
                Long newWorry = item * 17;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 3 == 0) {
                    monkey3.add(newWorry);
                } else {
                    monkey6.add(newWorry);
                }
            }
            monkey0.clear();

            //Monkey 1 code
            inspections[1] += monkey1.size();
            for (Long item : monkey1) {
                Long newWorry = item + 2;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 13 == 0) {
                    monkey3.add(newWorry);
                } else {
                    monkey0.add(newWorry);
                }
            }
            monkey1.clear();

            //Monkey 2 Code
            inspections[2] += monkey2.size();
            for (Long item : monkey2) {
                Long newWorry = item + 1;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 2 == 0) {
                    monkey0.add(newWorry);
                } else {
                    monkey1.add(newWorry);
                }
            }
            monkey2.clear();

            //Monkey 3 code
            inspections[3] += monkey3.size();
            for (Long item : monkey3) {
                Long newWorry = item + 7;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 11 == 0) {
                    monkey6.add(newWorry);
                } else {
                    monkey7.add(newWorry);
                }
            }
            monkey3.clear();

            //Monkey 4 code
            inspections[4] += monkey4.size();
            for (Long item : monkey4) {
                Long newWorry = item * item;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 19 == 0) {
                    monkey2.add(newWorry);
                } else {
                    monkey5.add(newWorry);
                }
            }
            monkey4.clear();

            //Monkey 5 code
            inspections[5] += monkey5.size();
            for (Long item : monkey5) {
                Long newWorry = item + 8;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 17 == 0) {
                    monkey2.add(newWorry);
                } else {
                    monkey1.add(newWorry);
                }
            }
            monkey5.clear();

            //Monkey 6 Code
            inspections[6] += monkey6.size();
            for (Long item : monkey6) {
                Long newWorry = item * 2;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 5 == 0) {
                    monkey4.add(newWorry);
                } else {
                    monkey7.add(newWorry);
                }
            }
            monkey6.clear();

            //Monkey 7 code
            inspections[7] += monkey7.size();
            for (Long item : monkey7) {
                Long newWorry = item + 6;
                newWorry /= worryDiv;
                newWorry %= 9699690;
                if (newWorry % 7 == 0) {
                    monkey4.add(newWorry);
                } else {
                    monkey5.add(newWorry);
                }
            }
            monkey7.clear();

            count++;
        }

        Arrays.sort(inspections);
        System.out.println("Monkey Business Level afer " + rounds + " rounds: " + inspections[6] * inspections[7]);
    }
}
