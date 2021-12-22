package day4_missingItemInArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// find missing number for given 2 list
// [1,5,7] & [1,7]  => 5
public class Solve1 {

    public static void main(String[] args) {

        List<Integer> arr1;
        List<Integer> arr2;

        int missing = 0;

        arr1 = new ArrayList<>(List.of(-5, -2, -1, -4));
        arr2 = new ArrayList<>(List.of(-5, -2, -1, 7, -4));

        // arr1 = getListFromInput();
        // arr2 = getListFromInput();


        //sort lists
        heapSort(arr1);
        heapSort(arr2);

        int min = arr1.size();
        boolean isArr1Min = true;

        if (arr1.size() > arr2.size()) {
            min = arr2.size();
            isArr1Min = false;
        }

        for (int i = 0; i < min; i++) {
            //compare last item of min list and n-1'th item of greater list then
            // if they are different choise item which is from greater list
            // if they are same then choise item in last index of greater list.
            if (i == min - 1) {
                if (isArr1Min && !arr1.get(i).equals(arr2.get(i))) {
                    missing = arr2.get(i);
                } else if (!isArr1Min && !arr1.get(i).equals(arr2.get(i))) {
                    missing = arr1.get(i);
                } else if (isArr1Min) {
                    missing = arr2.get(i + 1);
                } else {
                    missing = arr1.get(i + 1);
                }
            } else {
                //if any items are different get which is from greater list
                if (isArr1Min && !arr1.get(i).equals(arr2.get(i))) {
                    missing = arr2.get(i);
                    break;
                } else if (!isArr1Min && !arr1.get(i).equals(arr2.get(i))) {
                    missing = arr1.get(i);
                    break;
                }
            }
        }

        System.out.printf("Missing element is : %d", missing);

    }

    public static void heapSort(List<Integer> arr) {

        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            heapify(arr, i, 0);

        }


    }

    public static void heapify(List<Integer> arr, int n, int i) {

        int largest = i;

        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr.get(l) > arr.get(largest)) {
            largest = l;
        }

        if (r < n && arr.get(r) > arr.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            heapify(arr, n, largest);

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
