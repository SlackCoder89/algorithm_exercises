package org.hmk.multi_stack;

import java.util.EmptyStackException;

public class MultiStack {
    private class StackInfo {
        public int start, size, capacity;
        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index) {
            if (index < 0 || index >= values.length) {
                return false;
            }

            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex <= end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private StackInfo[] info;
    private int[] values;

    public MultiStack(int numberOfStacks, int defaultSize) {
        info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; ++i) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numberOfStacks * defaultSize];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (allStacksAreFull()) {
            throw new FullStackException();
        }

        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }
        stack.size++;
        values[stack.lastElementIndex()] = value;
    }

    public int pop(int stackNum) throws Exception {
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0;
        stack.size--;
        return value;
    }

    public int peek(int stackNum) {
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
    }

    private void shift(int stackNum) {
        System.out.println("/// Shifting " + stackNum);
        StackInfo stack = info[stackNum];

        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity++;
        }

        int index = stack.lastElementIndex();
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.capacity--;
    }

    private void expand(int stackNum) {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    public int numberOfElements() {
        int size = 0;
        for (StackInfo sd : info) {
            size += sd.size;
        }
        return size;
    }

    public boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }
}
