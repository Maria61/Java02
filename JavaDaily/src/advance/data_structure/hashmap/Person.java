package advance.data_structure.hashmap;

import java.util.Objects;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/21 21:29
 */
public class Person {
    private String name;
    private int age;
    private int gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "p1";
        p1.age = 18;
        p1.gender = 0;
        Person p2 = new Person();
        p2.name = "p1";
        p2.age = 18;
        p2.gender = 0;
        HashMap<Person,Integer> map = new HashMap<>();
        map.put(p1,108);
        System.out.println(map.get(p2));
    }
}
