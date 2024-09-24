package printer_9_a;
public class NumberPrinter {
    private static final int MAX_NUMBER = 15;

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        Thread t1 = new Thread(printer::printTwo);
        Thread t2 = new Thread(printer::printThree);
        Thread t3 = new Thread(printer::printFour);
        Thread t4 = new Thread(printer::printFive);
        Thread t5 = new Thread(printer::printNumber);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public void printTwo() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 2 == 0 && i % 3 != 0 && i % 4 != 0 && i % 5 != 0) {
                System.out.println("Number " + i + " is divisible by 2");
            }
        }
    }

    public void printThree() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 3 == 0 && i % 2 != 0 && i % 4 != 0 && i % 5 != 0) {
                System.out.println("Number " + i + " is divisible by 3");
            }
        }
    }

    public void printFour() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 4 == 0 && i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                System.out.println("Number " + i + " is divisible by 4");
            }
        }
    }

    public void printFive() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 5 == 0 && i % 2 != 0 && i % 3 != 0 && i % 4 != 0) {
                System.out.println("Number " + i + " is divisible by 5");
            }
        }
    }

    public void printNumber() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            if (i % 2 != 0 && i % 3 != 0 && i % 4 != 0 && i % 5 != 0) {
                System.out.println("Number " + i);
            }
        }
    }
}
