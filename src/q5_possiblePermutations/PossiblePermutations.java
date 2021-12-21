package q5_possiblePermutations;

// get list from input then compute all possible permutations
// input: a,b,c => output: abc,acb,bac,bca,cab,cba

import java.util.*;

public class PossiblePermutations {

    static List<String> result;

    public static void main(String[] args) {

        result = new ArrayList<>();

        String[] arr = getInputsFromConsole();

        calcPermutation(arr, arr.length, arr.length);

        Collections.sort(result);


        for (String s : result) {
            System.out.printf("%s \n", s);
        }

    }

    public static String[] getInputsFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please put \",\" for seperate items");
        return scanner.nextLine().split(",");
    }


    public static void calcPermutation(String[] a, int size, int n) {

        if (size == 1) {
            addToResult(a);
        }

        for (int i = 0; i < size; i++) {
            calcPermutation(a, size - 1, n);
            if (size % 2 == 1) {
                String temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            } else {
                String temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }

    }

    public static void addToResult(String[] a) {
        StringBuilder temp = new StringBuilder();
        for (String s : a) {
            temp.append(s).append(" ");
        }
        result.add(temp.toString());
    }

}
