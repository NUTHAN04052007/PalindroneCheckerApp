import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // 🔹 Two-pointer approach
    public static boolean twoPointer(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 🔹 Stack approach
    public static boolean stackMethod(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 🔹 Deque approach
    public static boolean dequeMethod(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // 🔸 Two-pointer timing
        long startTime = System.nanoTime();
        boolean result1 = twoPointer(input);
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // 🔸 Stack timing
        startTime = System.nanoTime();
        boolean result2 = stackMethod(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // 🔸 Deque timing
        startTime = System.nanoTime();
        boolean result3 = dequeMethod(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("\nPalindrome Result: " + result1);

        System.out.println("\nExecution Time (in nanoseconds):");
        System.out.println("Two Pointer Method : " + time1);
        System.out.println("Stack Method       : " + time2);
        System.out.println("Deque Method       : " + time3);

        sc.close();
    }
}