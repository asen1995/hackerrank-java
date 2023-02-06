import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            persons.add(new Person("Name" + i, i));
        }

        //is blank string
        String s = " ";
        System.out.println(s.isBlank());

        long currentTime = System.currentTimeMillis();

        List<PersonDTo> personDTos = persons.stream()
                .map(person -> new PersonDTo(person.getName(), person.getAge()))
                .collect(Collectors.toList());

        System.out.println("Stream took: " + (System.currentTimeMillis() - currentTime) + " ms");


        currentTime = System.currentTimeMillis();

        List<PersonDTo> personDTos2 = new ArrayList<>();

        for (Person person : persons) {
            personDTos2.add(new PersonDTo(person.getName(), person.getAge()));
        }

        System.out.println("For loop took: " + (System.currentTimeMillis() - currentTime) + " ms");
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    static class PersonDTo {
        private String name;
        private int age;

        public PersonDTo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
