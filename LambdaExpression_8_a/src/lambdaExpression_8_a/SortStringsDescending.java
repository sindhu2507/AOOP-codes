package lambdaExpression_8_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SortStringsDescending {

    public static void main(String[] args) {
        // Create a list of strings
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");
        strings.add("date");

        // Lambda expression to sort the list in descending order
        strings.sort((s1, s2) -> s2.compareTo(s1));

        // Alternatively, you can use Comparator.reverseOrder()
        // strings.sort(Comparator.reverseOrder());

        // Print the sorted list
        System.out.println("Sorted in descending order: " + strings);
    }
}
