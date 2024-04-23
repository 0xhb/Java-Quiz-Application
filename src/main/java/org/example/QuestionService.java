package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    static int score = 0;

    public QuestionService() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Question(i, "size of int", new String[]{"1", "3", "4", "8"}, "4");
        }
    }

    public void playQuiz() {
        Scanner sc = new Scanner(System.in);
        for (Question q : questions) {
            System.out.println(q.getId() + 1 + ". " + q.getQuestion());
            System.out.println("Options: " + Arrays.toString(q.getOptions()));
            System.out.print("choose your answer: ");
            String selection = sc.nextLine();
            if (selection.equals(q.getAnswer())) {
                System.out.println("Correct:)");
                score += 1;
            }
            else {
                System.out.println("Wrong Answer!");
            }
        }
        System.out.println("Final Score: " + score);
    }
}
