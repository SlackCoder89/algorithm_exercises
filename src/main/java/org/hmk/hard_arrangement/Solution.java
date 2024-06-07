package org.hmk.hard_arrangement;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<Integer> arrange(ArrayList<Integer> a, ArrayList<Integer> b, int n) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            personList.add(new Person(a.get(i), b.get(i)));
        }

        personList.sort((o1, o2) -> {
            if (o1.height != o2.height) {
                return o1.height - o2.height;
            } else {
                return o2.index - o1.index;
            }
        });
        ArrayList<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            res.add(-1);
        }
        for (Person p : personList) {
            doArrange(p, res);
        }
        return res;
    }

    private void doArrange(Person p, ArrayList<Integer> res) {
        int count = p.index;
        for (int i = 0; i < res.size(); ++i) {
            if (count == 0 && res.get(i) == -1) {
                res.set(i, p.height);
                return;
            } else if (res.get(i) != -1) {
                continue;
            } else {
                count--;
            }
        }
    }
}

class Person {
    int height;
    int index;

    public Person(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
