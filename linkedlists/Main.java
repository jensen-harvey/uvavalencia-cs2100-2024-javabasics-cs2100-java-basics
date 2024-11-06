package linkedlists;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Initial list: " + list);

        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);

        System.out.println("Using for-each loop:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}
