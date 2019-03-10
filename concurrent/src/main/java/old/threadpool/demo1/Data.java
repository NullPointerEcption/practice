package old.threadpool.demo1;

public class Data {
    private int age;
    private String name;

    public Data(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
