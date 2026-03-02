import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize the string:
        // 1. Remove spaces
        // 2. Convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome (ignoring spaces & case)");
        } else {
            System.out.println(input + " is not a Palindrome");
        }

        sc.close();
    }
}