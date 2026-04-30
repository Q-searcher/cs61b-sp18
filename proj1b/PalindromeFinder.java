/** This class outputs all palindromes in the words file in the current directory. */

public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        CharacterComparator cc = new OffByOne();
        cc = new OffByN(4);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }

        // question 1 For what N are there the most palindromes in English?
        /*
        int mostN = 0;
        int mosti = 0;
        Palindrome palindrome = new Palindrome();
        for (int i = 0; i < 25; i++) {
            CharacterComparator cc = new OffByN(i);
            int wordNumbers = 0;
            In in = new In("../library-sp18/data/words.txt");

            while (!in.isEmpty()) {
                String word = in.readString();
                if (palindrome.isPalindrome(word, cc)) {
                    wordNumbers++;
                }
            }
            System.out.println(i + " " + wordNumbers);

            if (mostN < wordNumbers) {
                mostN = wordNumbers;
                mosti = i;
            }

        }
        System.out.println(mosti);

         */
    }
}
