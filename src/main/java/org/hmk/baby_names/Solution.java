package org.hmk.baby_names;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
        Map<String, NameSet> groups = constructGroups(names);
        mergeClasses(groups, synonyms);
        return convertToMap(groups);
    }

    private Map<String, Integer> convertToMap(Map<String, NameSet> groups) {
        Map<String, Integer> list = new HashMap<>();
        for (NameSet group : groups.values()) {
            list.put(group.getRootName(), group.getFrequency());
        }
        return list;
    }

    private void mergeClasses(Map<String, NameSet> groups, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            NameSet set1 = groups.get(name1);
            NameSet set2 = groups.get(name2);

            if (set1 != set2) {
                NameSet smaller = set2.size() < set1.size() ? set2 : set1;
                NameSet bigger = set2.size() < set1.size() ? set1 : set2;

                Set<String> otherNames = smaller.getNames();
                int frequency = smaller.getFrequency();
                bigger.copyNamesWithFrequency(otherNames, frequency);

                for (String name : otherNames) {
                    groups.put(name, bigger);
                }
            }
        }
    }

    private Map<String, NameSet> constructGroups(Map<String, Integer> names) {
        Map<String, NameSet> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            NameSet group = new NameSet(name, frequency);
            groups.put(name, group);
        }
        return groups;
    }
}

class NameSet {
    private Set<String> names = new HashSet<>();
    private int frequency = 0;
    private String rootName;

    public NameSet(String rootName, int frequency) {
        names.add(rootName);
        this.frequency = frequency;
        this.rootName = rootName;
    }

    public void copyNamesWithFrequency(Set<String> more, int freq) {
        names.addAll(more);
        frequency += freq;
    }

    public Set<String> getNames() {
        return names;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getRootName() {
        return rootName;
    }

    public int size() {
        return names.size();
    }
}