package genericInterface;

public class GenericStorageTest {
	public static void main(String[] args) {
        // Test LinkedStorage with Integer
        Storage<Integer> linkedListStorage = new LinkedStorage<>();
        linkedListStorage.add(10);
        linkedListStorage.add(20);
        linkedListStorage.add(30);
        System.out.println("LinkedStorage (Integer) - Top Element: " + linkedListStorage.viewTop());
        System.out.println("LinkedStorage (Integer) - Removed Element: " + linkedListStorage.remove());
        System.out.println("LinkedStorage (Integer) - Is Empty: " + linkedListStorage.isEmpty());

        // Test ArrayStorage with String
        Storage<String> arrayStorage = new ArrayStorage<>(5);
        arrayStorage.add("apple");
        arrayStorage.add("banana");
        arrayStorage.add("cherry");
        System.out.println("ArrayStorage (String) - Top Element: " + arrayStorage.viewTop());
        System.out.println("ArrayStorage (String) - Removed Element: " + arrayStorage.remove());
        System.out.println("ArrayStorage (String) - Is Empty: " + arrayStorage.isEmpty());

        // Test LinkedStorage with Character
        Storage<Character> linkedListCharStorage = new LinkedStorage<>();
        linkedListCharStorage.add('A');
        linkedListCharStorage.add('B');
        linkedListCharStorage.add('C');
        System.out.println("LinkedStorage (Character) - Top Element: " + linkedListCharStorage.viewTop());
        System.out.println("LinkedStorage (Character) - Removed Element: " + linkedListCharStorage.remove());
        System.out.println("LinkedStorage (Character) - Is Empty: " + linkedListCharStorage.isEmpty());

        // Test ArrayStorage with Float
        Storage<Float> arrayFloatStorage = new ArrayStorage<>(5);
        arrayFloatStorage.add(1.1f);
        arrayFloatStorage.add(2.2f);
        arrayFloatStorage.add(3.3f);
        System.out.println("ArrayStorage (Float) - Top Element: " + arrayFloatStorage.viewTop());
        System.out.println("ArrayStorage (Float) - Removed Element: " + arrayFloatStorage.remove());
        System.out.println("ArrayStorage (Float) - Is Empty: " + arrayFloatStorage.isEmpty());
    }
}
