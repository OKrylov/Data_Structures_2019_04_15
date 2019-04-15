import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main1 {

    private static int fieldA = 10;
    private static String fieldStr;



    public static void main(String[] args) {
//        fieldA = 10;
//        System.out.println(fieldStr);
        String str1 = "str1";
        String str2 = new String("str1");

        System.out.println("str1 == str2:" + (str1 == str2));
        System.out.println("str1.equals(str2):" + (str1.equals(str2)));

        int a = 5;
        int b = 6;
        System.out.println("a == b:" + (a == b));



        Person p1 = new Person("Oleg", 27);
        Person p2 = new Person("Oleg", 27);

        System.out.println("p1 == p2:" + (p1 == p2));
        System.out.println("p1.equals(p2):" + (p1.equals(p2)));

        a = 5;
        Person person = new Person("Oleg", 27);//001

        System.out.println("a = " + a);
        System.out.println("person = " + person);

        test1(a, person);//001

        List<String> collection = new LinkedList<>();

        System.out.println("a = " + a);
        System.out.println("person = " + person);

        test2(collection);


    }

    private static void test2(List<String> collection) {
        test3(collection);
    }

    private static void test3(List<String> collection) {
    }

    private static void test1(int a, Person person) {
        a = 10;
        person.name = "Ivan";
        person = new Person("Petr", 33);//002
    }

    static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
