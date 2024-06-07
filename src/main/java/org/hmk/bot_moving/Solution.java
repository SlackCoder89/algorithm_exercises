package org.hmk.bot_moving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        List<Bot> bots = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            Bot bot = new Bot(nums[i], String.valueOf(s.charAt(i)));
            moveBot(bot, d);
            bots.add(bot);
        }
        bots.sort(Comparator.comparingLong(o -> o.position));

        long sum = 0;
        long mod = 1000000000 + 7;
        for (int i = 1; i < bots.size(); ++i) {
            long distance = bots.get(i).position - bots.get(i - 1).position;
            distance %= mod;
            distance *= i;
            distance %= mod;
            distance *= bots.size() - i;
            distance %= mod;
            sum += distance;
            sum %= mod;
        }
        return (int) (sum);
    }

    private void moveBot(Bot bot, int count) {
        if (bot.direction.equals("R")) {
            bot.position += count;
        } else {
            bot.position -= count;
        }
    }
}

class Bot {
    long position;
    String direction;

    public Bot(int position, String direction) {
        this.position = position;
        this.direction = direction;
    }
}
