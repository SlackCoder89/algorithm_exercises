package org.hmk.nested_iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator  implements Iterator<Integer> {
    private final Stack<NestedIntegerWrapper> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(new NestedIntegerWrapper(nestedList, 0));
    }

    @Override
    public Integer next() {
        while (!stack.isEmpty()) {
            NestedIntegerWrapper wrapper = stack.peek();
            if (wrapper.next >= wrapper.nestedList.size()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().next += 1;
                }
                continue;
            }

            NestedInteger nestedInteger = wrapper.nestedList.get(wrapper.next);
            if (nestedInteger.isInteger()) {
                wrapper.next += 1;
                return nestedInteger.getInteger();
            } else {
                stack.push(new NestedIntegerWrapper(nestedInteger.getList(), 0));
            }

        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedIntegerWrapper wrapper = stack.peek();
            if (wrapper.next >= wrapper.nestedList.size()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().next += 1;
                }
                continue;
            }
            NestedInteger nestedInteger = wrapper.nestedList.get(wrapper.next);
            if (nestedInteger.isInteger()) {
                return true;
            } else {
                stack.push(new NestedIntegerWrapper(nestedInteger.getList(), 0));
            }
        }
        return false;
    }
}

class NestedIntegerWrapper {
    List<NestedInteger> nestedList;
    int next;

    public NestedIntegerWrapper(List<NestedInteger> nestedList, int next) {
        this.nestedList = nestedList;
        this.next = next;
    }
}