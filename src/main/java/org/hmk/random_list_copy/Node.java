package org.hmk.random_list_copy;

import java.util.HashMap;
import java.util.Map;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        Map<Node, Integer> map = new HashMap<>();
        Node cur = this;
        int index = 0;
        while (cur != null) {
            map.put(cur, index);
            cur = cur.next;
            index++;
        }

        cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append("[").append(cur.val);
            sb.append(",");
            if (cur.random != null) {
                sb.append(map.get(cur.random));
            } else {
                sb.append("null");
            }
            sb.append("], ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static Node build(int[][] array) {
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < array.length; ++i) {
            nodes[i] = new Node(array[i][0]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        for (int i = 0; i < array.length; ++i) {
            if (array[i][1] >= 0) {
                nodes[i].random = nodes[array[i][1]];
            }
        }
        return nodes[0];
    }
}
