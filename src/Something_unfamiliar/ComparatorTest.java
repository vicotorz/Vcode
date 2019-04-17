package src.Something_unfamiliar;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Created by dell on 2019/4/17.
 */
public class ComparatorTest {

    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet(new Mycomparator());
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        Iterator it = tree.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

class Mycomparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
