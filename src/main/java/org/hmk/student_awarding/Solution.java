package org.hmk.student_awarding;

import java.util.*;

public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Feedback feedback = new Feedback(positive_feedback, negative_feedback);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < student_id.length; ++i) {
            Student student = new Student(student_id[i], report[i]);
            student.score = feedback.rate(student.report);
            students.add(student);
        }

        students.sort((o1, o2) -> {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else {
                return o1.id - o2.id;
            }
        });

        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ids.add(students.get(i).id);
        }
        return ids;
    }
}

class Student {
    int id;
    String report;
    int score;

    public Student(int id, String report) {
        this.id = id;
        this.report = report;
    }
}

class Feedback {
    Set<String> positive;
    Set<String> negative;

    public Feedback(String[] positive, String[] negative) {
        this.positive = new HashSet<>(Arrays.asList(positive));
        this.negative = new HashSet<>(Arrays.asList(negative));
    }

    public int rate(String report) {
        String[] wordArray = report.split(" ");
        int score = 0;
        for (String word : wordArray) {
            if (positive.contains(word)) {
                score += 3;
            }
            if (negative.contains(word)) {
                score--;
            }
        }
        return score;
    }
}
