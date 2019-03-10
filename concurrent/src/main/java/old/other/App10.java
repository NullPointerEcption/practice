package old.other;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试一下泛型
 */
public class App10 {
    /**
     * 测试一下
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<String> list=new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        for (String s : list) {
            System.out.println(s);
        }

        MyGenericClass<String> myGenericClass=new MyGenericClass<>(new ArrayList<>());
        myGenericClass.doAdd("str");

        Method doAdd = myGenericClass.getClass().getDeclaredMethod("doAdd", Object.class);//类型擦除 只有一个泛型 没有限制 直接就是Obejct类型
        doAdd.invoke(myGenericClass,123);

        myGenericClass.show();

        myGenericClass.test();

    }
}

class MyGenericClass<T>{

    private List<T> list;

    public MyGenericClass(List<T> list) {
        this.list = list;
    }

    public void doAdd(T t)  {
        list.add(t);
    }

    public void show() {
        list.forEach(System.out::println);
    }

    public void test(String...args) {
        System.out.println("11111");
    }


}

