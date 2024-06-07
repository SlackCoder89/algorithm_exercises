package org.hmk.nested_iterator;

import java.util.List;

public class NestedInteger {
    private Integer integer;
    private List<NestedInteger> nestedIntegers;

    public NestedInteger(int i) {
        integer = i;
    }

    public NestedInteger(List<NestedInteger> nestedIntegers) {
        this.nestedIntegers = nestedIntegers;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return nestedIntegers;
    }
}
