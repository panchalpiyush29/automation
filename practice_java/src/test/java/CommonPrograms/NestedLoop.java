package CommonPrograms;

public class NestedLoop {

    public static void main(String[] args) {

        int k = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print( k);
                System.out.print("\t");
                k++;
            }
        }
    }
}
