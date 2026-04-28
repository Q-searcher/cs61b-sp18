public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }
    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }


    // below are some test for ArrayDeque
    public static void arrayDequeAddRemoveTest() {
        System.out.println("Running ArrayDeque test for add and remove");

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        // should be empty
        boolean passed = checkEmpty(true, ad.isEmpty());

        ad.addFirst(10);
        passed = checkEmpty(false, ad.isEmpty()) && passed;

        ad.removeFirst();
        passed = checkEmpty(true, ad.isEmpty()) && passed;

        printTestStatus(passed);
    }


    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        ArrayDeque<String> ad = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, ad.isEmpty());

        ad.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad.size()) && passed;
        passed = checkEmpty(false, ad.isEmpty()) && passed;

        ad.addLast("middle");
        passed = checkSize(2, ad.size()) && passed;

        ad.addLast("back");
        passed = checkSize(3, ad.size()) && passed;

        System.out.println("Printing out deque: ");
        ad.printDeque();

        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        passed = checkSize(0, ad.size()) && passed;
        printTestStatus(passed);
    }

    public static void resizeTest() {
        System.out.println("Runnig resize test.");
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        for (int i = 0; i < 13; i++) {
            ad.addFirst(1);
        }

        boolean passed = checkSize(13, ad.size());
        System.out.println("Printing out deque: ");
        ad.printDeque();

        for (int i = 0; i < 15; i++) {
            ad.removeLast();
        }
        System.out.println("Printing out deque: ");
        ad.printDeque();

        passed = checkSize(0, ad.size()) && passed;


        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running test.\n");
        arrayDequeAddRemoveTest();
        addIsEmptySizeTest();
        resizeTest();
    }
}
