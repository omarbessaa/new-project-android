package com.example.trainingapp1.model;

import java.util.Collections;
import java.util.List;

public class QuestionsBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionsBank(List<Question> questionList) {
        // Shuffle the question list before storing it
        Collections.shuffle(questionList);
        this.mNextQuestionIndex = -1;
        this.mQuestionList = questionList;
    }

    public Question getQuestion() {
        // Loop over the questions and return a new one at each call
        if (this.mNextQuestionIndex == this.mQuestionList.size()) this.mNextQuestionIndex = -1;
        this.mNextQuestionIndex += 1;
        return this.mQuestionList.get(this.mNextQuestionIndex);
    }

}
