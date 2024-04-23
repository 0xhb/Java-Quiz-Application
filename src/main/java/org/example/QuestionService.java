package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    static int score = 0;

    enum Menu {
        PLAY,
        UPDATE,
        QUIT
    }

    ;

    public QuestionService() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Question(i, "size of int", new String[]{"1", "3", "4", "8"}, "4");
        }
    }

    public boolean playQuiz() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Quiz App\nHere is our Menu:");
        System.out.println(Arrays.toString(QuestionService.Menu.values()));
        System.out.print("What you would like to do? ");
        String choice = sc.nextLine();
        switch (choice.toUpperCase()) {
            case "PLAY":
                for (Question q : questions) {
                    System.out.println(q.getId() + 1 + ". " + q.getQuestion());
                    System.out.println("Options: " + Arrays.toString(q.getOptions()));
                    System.out.print("choose your answer: ");
                    String selection = sc.nextLine();
                    if (selection.equals(q.getAnswer())) {
                        System.out.println("Correct:)");
                        score += 1;
                    } else {
                        System.out.println("Wrong Answer!");
                    }
                }
                System.out.println("Final Score: " + score);
                break;
            case "UPDATE":
                System.out.print("Question Id: ");
                String id = sc.nextLine();
                System.out.print("Question : ");
                String question = sc.nextLine();
                System.out.print("Options: ");

                String[] options = sc.nextLine().split(" ");
                System.out.print("Answer: ");
                String answer = sc.nextLine();
                updateQuestion(Integer.parseInt(id), question, options, answer);
                break;

            case "QUIT":
                System.out.println("Goodbye!");
                return false;

            default:
                System.out.println("No int our menu!");
        }
        return true;
    }
    public void updateQuestion ( int id, String question, String[]options, String answer){
        for (Question q : questions) {
            if (q.getId() == id) {
                q.setQuestion(question);
                q.setOptions(options);
                q.setAnswer(answer);
                System.out.println("Question updated!");
                return;
            }
        }
        System.out.println("No question matches this Id!");
    }
}