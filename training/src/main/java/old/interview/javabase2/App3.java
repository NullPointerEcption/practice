package old.interview.javabase2;

/**
 * java中只有值传递
 */
public class App3 {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("wyf");
        method(p);//这里传递的也只是地址的拷贝 所以说java中只有值传递
        System.out.println(p.getName());
    }

    public static void method(Person p) {
        p = new Person();
        p.setName("123");
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}