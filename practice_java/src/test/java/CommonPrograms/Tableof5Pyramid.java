package CommonPrograms;

public class Tableof5Pyramid {


    public static void main(String[] args) {

        int k = 1;
        for (int i = 1; i <= 5; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print(k * 5);
                System.out.print("\t");
                k++;
            }

        }
    }
}

