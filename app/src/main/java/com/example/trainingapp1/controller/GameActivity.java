package com.example.trainingapp1.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainingapp1.R;
import com.example.trainingapp1.model.Question;
import com.example.trainingapp1.model.QuestionsBank;

import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion;
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private QuestionsBank questionsBank;
    private Question question;

    private int numberOfQuestions;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.mQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        this.mAnswer1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        this.mAnswer2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        this.mAnswer3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        this.mAnswer4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        this.questionsBank = loadQuestons();
        this.numberOfQuestions = 3;
        this.score = 0;

        this.question = questionsBank.getQuestion();
        displayQuestion(question);

        this.mAnswer1.setTag(0);
        this.mAnswer2.setTag(1);
        this.mAnswer3.setTag(2);
        this.mAnswer4.setTag(3);

        this.mAnswer1.setOnClickListener(this);
        this.mAnswer2.setOnClickListener(this);
        this.mAnswer3.setOnClickListener(this);
        this.mAnswer4.setOnClickListener(this);

    }

    private void displayQuestion(Question question) {
        this.mQuestion.setText(question.getQuestion());
        List<String> ch = question.getChoiceList();
        this.mAnswer1.setText(ch.get(0));
        this.mAnswer2.setText(ch.get(1));
        this.mAnswer3.setText(ch.get(2));
        this.mAnswer4.setText(ch.get(3));
    }

    protected QuestionsBank loadQuestons() {
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionsBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

    @Override
    public void onClick(View v) {
        int index = (int) v.getTag();

        if (index == this.question.getAnswerIndex()) {
            Toast.makeText(this, "Correct answer !", Toast.LENGTH_SHORT).show();
            this.score ++;
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        this.numberOfQuestions--;
        if (this.numberOfQuestions == 0) {
            endGame();
        } else {
            this.question = questionsBank.getQuestion();
            displayQuestion(question);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game over")
                .setMessage("your score is : " + this.score)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
                })
                .create()
                .show();
    }
}