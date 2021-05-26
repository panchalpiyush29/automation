package CommonPrograms;

public class encapsulationClassTwo {
    public static void main(String[] args) {

        encapsulationClassOne obj = new encapsulationClassOne();
        obj.setAge(35);
        obj.setName("Piyush");

        System.out.println("My name is " + obj.getName());
        System.out.println("My age is " + obj.getAge());
    }
}
