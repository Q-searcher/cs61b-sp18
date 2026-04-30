public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int offNumber = x - y;
        return offNumber == -1 || offNumber == 1;
    }
}
