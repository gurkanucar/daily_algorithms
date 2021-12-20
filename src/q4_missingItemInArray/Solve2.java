package q4_missingItemInArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* THIS SOLUTION WILL WORK ONLY FOR POSITIVE ELEMENTS*/

// find missing number for given 2 list
// [1,5,7] & [1,7]  => 5
public class Solve2 {
    public static void main(String[] args) {

        List<Integer> arr1;
        List<Integer> arr2;

        arr1 = getListFromInput();
        arr2 = getListFromInput();


        System.out.println(Math.abs(sum(arr1) - sum(arr2)));


    }

    public static int sum(List<Integer> data) {
        if (data.isEmpty()) {
            return 0;
        } else if (data.size() == 1) {
            return data.get(0);
        } else {
            int half = data.size() / 2;
            return sum(data.subList(0, half)) + sum(data.subList(half, data.size()));
        }

    }

    public static List<Integer> getListFromInput() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("!")) {
                break;
            } else {
                result.add(Integer.parseInt(input));
            }

        }
        return result;
    }


}
