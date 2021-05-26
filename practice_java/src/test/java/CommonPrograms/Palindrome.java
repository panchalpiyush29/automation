package CommonPrograms;

public class Palindrome {

    public static void main(String[] args) {

        String i = "Madam";
        String j = "";

        for (int a = i.length() - 1; a >= 0; a--) {
            j = j + i.charAt(a);
        }
        System.out.println(j);

        if(i.equals(j)){
            System.out.println("Yup it's a CommonPrograms.Palindrome");
        }else {
            System.out.println("Naah!!");
        }

    }

}
