package maxMinValue_6b;

public class GenericArrayMaxMin {
	public static void main(String[] args) {
        // Integer Array
        Integer[] intArray = {3, 5, 2, 8, 1};
        ArrayUtil<Integer> intUtil = new ArrayUtil<>();
        System.out.println("Integer Array - Max: " + intUtil.findMax(intArray));
        System.out.println("Integer Array - Min: " + intUtil.findMin(intArray));

        // String Array
        String[] strArray = {"apple", "orange", "banana", "pear"};
        ArrayUtil<String> strUtil = new ArrayUtil<>();
        System.out.println("String Array - Max: " + strUtil.findMax(strArray));
        System.out.println("String Array - Min: " + strUtil.findMin(strArray));

        // Character Array
        Character[] charArray = {'a', 'z', 'e', 'b', 'y'};
        ArrayUtil<Character> charUtil = new ArrayUtil<>();
        System.out.println("Character Array - Max: " + charUtil.findMax(charArray));
        System.out.println("Character Array - Min: " + charUtil.findMin(charArray));

        // Float Array
        Float[] floatArray = {1.5f, 3.2f, 0.8f, 4.9f, 2.1f};
        ArrayUtil<Float> floatUtil = new ArrayUtil<>();
        System.out.println("Float Array - Max: " + floatUtil.findMax(floatArray));
        System.out.println("Float Array - Min: " + floatUtil.findMin(floatArray));
    }
}
