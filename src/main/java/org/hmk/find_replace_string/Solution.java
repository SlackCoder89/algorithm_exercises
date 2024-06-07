package org.hmk.find_replace_string;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Replacement[] replacements = new Replacement[indices.length];
        for (int i = 0; i < indices.length; ++i) {
            replacements[i] = new Replacement(indices[i], sources[i], targets[i]);
        }
        boolean[] toReplace = new boolean[indices.length];
        Arrays.sort(replacements, new Comparator<Replacement>() {
            @Override
            public int compare(Replacement o1, Replacement o2) {
                return o1.index - o2.index;
            }
        });

        for (int i = 0; i < replacements.length; ++i) {
            if (s.indexOf(replacements[i].source, replacements[i].index) == replacements[i].index) {
                toReplace[i] = true;
            }
        }

        int addition = 0;
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        for (int i = 0; i < indices.length; ++i) {
            if (toReplace[i]) {
                sb.append(s, offset, replacements[i].index);
                sb.append(replacements[i].target);
                offset = replacements[i].index;
                offset += replacements[i].source.length();
            }
        }
        sb.append(s.substring(offset));
        return sb.toString();
    }
}

class Replacement {
    int index;
    String source;
    String target;

    public Replacement(int index, String source, String target) {
        this.index = index;
        this.source = source;
        this.target = target;
    }
}
