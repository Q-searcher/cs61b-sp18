public class OffByN implements CharacterComparator {
    // constructor
    private final int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int offNumber = x - y;
        return offNumber == -N || offNumber == N;
    }
}
