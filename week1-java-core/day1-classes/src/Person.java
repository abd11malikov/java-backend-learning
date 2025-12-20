public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }

    public static void main(String[] args) {
        Person p = new Person("Otabek", 20);
        p.introduce();
    }
}
