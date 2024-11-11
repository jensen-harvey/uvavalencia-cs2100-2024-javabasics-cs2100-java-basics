package recursion;
public class BinarySearchArray {
    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }
        
        int mid = (left + right) / 2;
        
        if (array[mid] == target) {
            return mid; // Target found
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right); // Search in the right half
        } else {
            return binarySearch(array, target, left, mid - 1); // Search in the left half
        }
    }
    
    public static void main(String[] args) {
        int[] array = {2, 5, 6, 8, 9, 10};
        int target = 5;
        int result = binarySearch(array, target, 0, array.length - 1);
        System.out.println("Index of " + target + ": " + result);
    }
}
