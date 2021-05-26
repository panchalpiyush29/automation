package CommonPrograms;

public class NumberPyramid {


    public static void main(String[] args) {

        int k = 1;
        for (int i = 1; i < 4; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print(k);
                System.out.print("\t");
                k++;
            }

        }
    }
}

