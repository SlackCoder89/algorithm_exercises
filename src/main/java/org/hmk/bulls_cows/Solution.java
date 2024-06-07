package org.hmk.bulls_cows;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        int countBulls = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> gMap = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countBulls++;
            }
            sMap.put(secret.charAt(i), sMap.getOrDefault(secret.charAt(i), 0) + 1);
            gMap.put(guess.charAt(i), gMap.getOrDefault(guess.charAt(i), 0) + 1);
        }
        int countCows = 0;
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (gMap.containsKey(entry.getKey())) {
                countCows += Math.min(entry.getValue(), gMap.get(entry.getKey()));
            }
        }
        countCows -= countBulls;

        return countBulls + "A" + countCows + "B";
    }
}
