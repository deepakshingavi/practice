import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String test = "+1(123)456-7890";

        System.out.println(test.replaceAll("[0-9]+", "*"));


        Set<Person.Privilege> privi1 = new HashSet<>();
        privi1.add(Person.Privilege.PRIV1);
        privi1.add(Person.Privilege.PRIV2);
        privi1.add(Person.Privilege.PRIV3);
        privi1.add(Person.Privilege.PRIV4);

        Person pers1 = new Person("D", privi1);

        Person pers2 = new Person("B", privi1);

        List<Person> personList = new ArrayList();
        personList.add(pers1);
        personList.add(pers2);

        System.out.println(personsByPrivilege(personList));

    }

    public static Map<Person.Privilege, List<String>> personsByPrivilege(List<Person> personList) {
        return personList.stream().flatMap(p -> {
            String name = p.getName();
            return p.getPrivileges().stream()
                    .flatMap(priv -> Stream.of(new NamePriviledge(priv, name)));
        }).collect(Collectors.groupingBy(NamePriviledge::getPrivilege, Collectors.mapping(NamePriviledge::getName, Collectors.toList())));
    }


}

class Person {

    public Person(String name, Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    public enum Privilege {
        PRIV1, PRIV2, PRIV3, PRIV4, PRIV5;
    }

    private String name;
    public Set<Privilege> privileges;

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public String getName() {
        return name;
    }
}

class NamePriviledge {
    private final Person.Privilege privilege;
    private final String name;

    public NamePriviledge(Person.Privilege privilege, String name) {
        this.privilege = privilege;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person.Privilege getPrivilege() {
        return privilege;
    }

    @Override
    public String toString() {
        return "NamePriviledge{" +
                "privilege=" + privilege +
                ", name='" + name + '\'' +
                '}';
    }
}

