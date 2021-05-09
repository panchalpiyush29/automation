public class StarPattern {
    public static void main(String[] args) {
        int x, y, row = 5;

        for (x = 0; x <= row; x++) {
            for (y = 0; y <= x; y++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
