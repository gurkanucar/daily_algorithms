package q6_romanNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumbers {

    private static final Map<Character,
            Integer> numbers = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        int n = input.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i != n - 1 && numbers.get(input.charAt(i)) < numbers.get(input.charAt(i + 1))) {
                result += numbers.get(input.charAt(i + 1)) - numbers.get(input.charAt(i));
                i++;
            } else {
                result += numbers.get(input.charAt(i));
            }
        }

        System.out.println(result);

    }

}