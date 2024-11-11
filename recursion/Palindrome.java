package recursion;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }
    
    private static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: all characters matched
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false; // Not a palindrome
        }
        return isPalindrome(str, left + 1, right - 1); // Check next pair of characters
    }
    
    public static void main(String[] args) {
        String str = "rotor";
        System.out.println("Is \"" + str + "\" a palindrome? " + isPalindrome(str));
    }
}
