package org.example;

public class QuestionService {
    Question[] questions = new Question[5];

    public QuestionService(){
    for (int i = 0; i < questions.length; i++) {
        questions[i] = new Question(i, "size of int", new String[]{"1", "3", "4", "8"}, "4");
    }
    }
    public void displayQuestions() {
        for (Question q: questions)
            System.out.println(q.getQuestion());
    }

    public void addQuestion(Question q) {
        questions[questions.length - 1] = q;
    }

}
