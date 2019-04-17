package src.Something_unfamiliar;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by dell on 2019/4/17.
 */
public class ComparableTest {
    public static void main(String[] args) {
        TreeSet<Person> tree = new TreeSet<>();

        tree.add(new Person(3400));
        tree.add(new Person(3500));
        tree.add(new Person(3600));
        tree.add(new Person(3300));
        tree.add(new Person(3300));
        tree.add(new Person(3200));
        Iterator it = tree.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

class Person implements Comparable<Person> {
    public int age;

    Person(int age){
        this.age = age;
    }

    //按照他们年龄比较，降序
    public int compareTo(Person o) {
        return this.age >= o.age ? -1 : 1;
    }
}
