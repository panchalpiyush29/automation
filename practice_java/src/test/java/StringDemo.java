public class StringDemo {

    public static void main(String[] args){
        String a = "Hello"; //String Literal
        String b = new String("World"); //Object of class String
        String c = "javatraining";
        System.out.println(a + " " +b);
        String arr[] = c.split("t");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(c.replace("t","$"));
        System.out.println(a.substring(1,4));
    }

}
