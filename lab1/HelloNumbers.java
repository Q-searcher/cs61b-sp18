public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        while (x < 46) {
	    if (x % 2 == 0)
	    {
                System.out.print(x + " ");
	    }
            x = x + 1;
        }
    }
}
