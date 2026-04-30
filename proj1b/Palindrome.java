public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int wordLength = word.length();

        Deque<Character> newDeque = new LinkedListDeque<>();

        for (int i = 0; i < wordLength; i++) {
            newDeque.addLast(word.charAt(i));
        }

        return newDeque;
    }
    // The isPalindrome method should return true if the given
    // word is a palindrome, and false otherwise.
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        return isPalindromeHelper(wordDeque, null);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);

        return isPalindromeHelper(wordDeque, cc);
    }

    private boolean isPalindromeHelper(
            Deque<Character> wordDeque,
            CharacterComparator cc) {

        int size = wordDeque.size();

        if (size == 0 || size == 1) {
            return true;
        }
        char firstChar = wordDeque.removeFirst();
        char lastChar = wordDeque.removeLast();
        boolean equal;

        if (cc == null) {
            equal = (firstChar == lastChar);
        } else {
            equal = cc.equalChars(firstChar, lastChar);
        }

        if (equal) {
            return isPalindromeHelper(wordDeque, cc);
        } else {
            return false;
        }
    }
}
