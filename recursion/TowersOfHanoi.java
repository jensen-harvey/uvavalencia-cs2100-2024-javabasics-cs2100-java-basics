package recursion;

public class TowersOfHanoi {
    public static void solveTowersOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        solveTowersOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        solveTowersOfHanoi(n - 1, auxRod, toRod, fromRod);
    }
    
    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveTowersOfHanoi(n, 'A', 'C', 'B');
    }
}
