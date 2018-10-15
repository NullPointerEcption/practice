package chapter2.Item4;

// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    public UtilityClass(String msg) {

    }

    public static void hello(){
        System.out.println("hello...");
    }

    public static void main(String[] args) {
        UtilityClass utilityClass = new UtilityClass();
        System.out.println(utilityClass);
    }
}
//class UtilitySubClass extends UtilityClass{
//
//}