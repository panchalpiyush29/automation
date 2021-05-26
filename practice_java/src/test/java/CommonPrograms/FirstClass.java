package CommonPrograms;

public class FirstClass {

    public void method1() {
        System.out.println("This is my first method");
    }

    public static void main(String[] args) {
        FirstClass fc = new FirstClass();
        SecondClass sc = new SecondClass();
        fc.method1();
        System.out.println(sc.method2());
    }

}
