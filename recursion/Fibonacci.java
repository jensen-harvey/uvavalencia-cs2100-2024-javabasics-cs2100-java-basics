package recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base cases: F(0) = 0, F(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n));
    }
}
