package other;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 反射练习 拿到定义的参数的名称
 */
public class App11 {

    public static void main(String[] args) {
        try {
            Method testMethod = Person.class.getDeclaredMethod("test", String.class, String.class);
            Parameter[] parameters = testMethod.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.println(parameters[i].getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}

class Person{

    public void test(String param1231,String param2) throws Exception {
    }
}