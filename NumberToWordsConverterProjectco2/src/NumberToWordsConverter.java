
public class NumberToWordsConverter {
	private static final String[] LESS_THAN_TWENTY = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String[] THOUSANDS = {"", "thousand", "million", "billion"};

    // Main conversion function
    public static String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    // Helper function to convert numbers less than 1000
    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_TWENTY[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_TWENTY[num / 100] + " hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        int number = 1234567;
        System.out.println(numberToWords(number));  // Output: "one million two hundred thirty-four thousand five hundred sixty-seven"
    }
}
