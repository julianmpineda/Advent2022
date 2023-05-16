import java.util.*;
public class day11 {
    public static void main(String[] args) {
        List<Integer> monkey0 = new ArrayList<Integer>(Arrays.asList(59,65,86,56,74,57,56));
        List<Integer> monkey1 = new ArrayList<Integer>(Arrays.asList(63,83,50,63,56));
        List<Integer> monkey2 = new ArrayList<Integer>(Arrays.asList(93,79,74,55));
        List<Integer> monkey3 = new ArrayList<Integer>(Arrays.asList(86,61,67,88,94,69,56,91)) ;
        List<Integer> monkey4 = new ArrayList<Integer>(Arrays.asList(76,60,61));
        List<Integer> monkey5 = new ArrayList<Integer>(Arrays.asList(77,76));
        List<Integer> monkey6 = new ArrayList<Integer>(Arrays.asList(74));
        List<Integer> monkey7 = new ArrayList<Integer>(Arrays.asList(86,85,52,86,91,95));
        int[] inspections = new int[8];
        int count = 0;

        while (count < 20) {

            //Monkey 0 code
            inspections[0] += monkey0.size();
            for (Integer item : monkey0) {
                int newWorry = item * 17;
                newWorry /= 3;
                if (newWorry % 3 == 0) {
                    monkey3.add(newWorry);
                } else {
                    monkey6.add(newWorry);
                }
            }
            monkey0.clear();

            //Monkey 1 code
            inspections[1] += monkey1.size();
            for (Integer item : monkey1) {
                int newWorry = item + 2;
                newWorry /= 3;
                if (newWorry % 13 == 0) {
                    monkey3.add(newWorry);
                } else {
                    monkey0.add(newWorry);
                }
            }

            monkey1.clear();

            //Monkey 2 Code
            inspections[2] += monkey2.size();
            for (Integer item : monkey2) {
                int newWorry = item + 1;
                newWorry /= 3;
                if (newWorry % 2 == 0) {
                    monkey0.add(newWorry);
                } else {
                    monkey1.add(newWorry);
                }
            }

            monkey2.clear();

            //Monkey 3 code
            inspections[3] += monkey3.size();
            for (Integer item : monkey3) {
                int newWorry = item + 7;
                newWorry /= 3;
                if (newWorry % 11 == 0) {
                    monkey6.add(newWorry);
                } else {
                    monkey7.add(newWorry);
                }
            }

            monkey3.clear();

            //Monkey 4 code
            inspections[4] += monkey4.size();
            for (Integer item : monkey4) {
                int newWorry = item * item;
                newWorry /= 3;
                if (newWorry % 19 == 0) {
                    monkey2.add(newWorry);
                } else {
                    monkey5.add(newWorry);
                }
            }
            monkey4.clear();

            //Monkey 5 code
            inspections[5] += monkey5.size();
            for (Integer item : monkey5) {
                int newWorry = item + 8;
                newWorry /= 3;
                if (newWorry % 17 == 0) {
                    monkey2.add(newWorry);
                } else {
                    monkey1.add(newWorry);
                }
            }

            monkey5.clear();

            //Monkey 6 Code
            inspections[6] += monkey6.size();
            for (Integer item : monkey6) {
                int newWorry = item * 2;
                newWorry /= 3;
                if (newWorry % 5 == 0) {
                    monkey4.add(newWorry);
                } else {
                    monkey7.add(newWorry);
                }
            }
            monkey6.clear();

            //Monkey 7 code
            inspections[7] += monkey7.size();
            for (Integer item : monkey7) {
                int newWorry = item + 6;
                newWorry /= 3;
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

        System.out.println(inspections[6] * inspections[7]);
    }
}
