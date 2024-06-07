package org.hmk.nested_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<NestedInteger> list = Arrays.asList(
                new NestedInteger(Arrays.asList(
                        new NestedInteger(1),
                        new NestedInteger(1)
                )),
                new NestedInteger(2),
                new NestedInteger(Arrays.asList(
                        new NestedInteger(1),
                        new NestedInteger(1)
                ))
        );
        NestedIterator iterator = new NestedIterator(list);
        List<Integer> res = new ArrayList<>();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        System.out.println(res);
    }
}
