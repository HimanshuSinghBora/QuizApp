package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesKt;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    // setting up things
    private Button OptionA,OptionB,OptionC,OptionD;
    private ImageButton nextButton;
    int correct=0;
    int currentQuestionIndex=0;
    private ImageButton prevButton;
    private ImageView Image;
    private TextView questionTextView;
    TextView textView;
    // to keep current question track

    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a, 'a'),
            new Question(R.string.b, 'c'),
            new Question(R.string.c, 'd'),
            new Question(R.string.d, 'c'),
            new Question(R.string.e, 'b'),
            new Question(R.string.f, 'a'),
            new Question(R.string.g, 'c'),
            new Question(R.string.h, 'a'),
            new Question(R.string.i, 'b'),
            new Question(R.string.j, 'a'),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up the buttons
        // associated with id
        OptionA = findViewById(R.id.optionA);
        OptionB = findViewById(R.id.optionB);
        OptionC = findViewById(R.id.optionC);
        OptionD = findViewById(R.id.optionD);
        textView = findViewById(R.id.textView);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        // register our buttons to listen to
        // click events
        questionTextView
                = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        OptionA.setOnClickListener(this);
        OptionB.setOnClickListener(this);
        OptionC.setOnClickListener(this);
        OptionD.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
//        SharedPreferences sd=getSharedPreferences("Preference",MODE_PRIVATE);
//        correct=sd.getInt("store_ans",0);
//        currentQuestionIndex=sd.getInt("store_ques",0);
        new CountDownTimer(600000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("00:00:00");
                questionTextView.setText(getString(
                        R.string.correct, correct));
//                SharedPreferences sd=getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.clear();
                nextButton.setVisibility(
                        View.INVISIBLE);
                prevButton.setVisibility(
                        View.INVISIBLE);
                OptionA.setVisibility(
                        View.INVISIBLE);
                OptionB.setVisibility(
                        View.INVISIBLE);
                OptionC.setVisibility(
                        View.INVISIBLE);
                OptionD.setVisibility(
                        View.INVISIBLE);
                if (correct > 6) {

                    questionTextView.setText(
                            "CORRECTNESS IS " + correct + " " + "OUT OF 10");

                    // showing correctness
                }
                else
                    Image.setImageResource(
                            R.drawable.sad);
                // if correctness<3 showing sad emoji
            }
        }.start();
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if(id==R.id.optionA){
            checkAnswer('a');
            if (currentQuestionIndex < 11) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
//                SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.putInt("store_ans",correct);
//                ed.putInt("store_ques",currentQuestionIndex);
//                ed.apply();
                // we are safe now!
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                    //ed.clear();
                    textView.setText("00:00:00");
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    OptionA.setVisibility(
                            View.INVISIBLE);
                    OptionB.setVisibility(
                            View.INVISIBLE);
                    OptionC.setVisibility(
                            View.INVISIBLE);
                    OptionD.setVisibility(
                            View.INVISIBLE);
                    if (correct > 6)

                        questionTextView.setText(
                                "CORRECTNESS IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
                    else
                        Image.setImageResource(
                                R.drawable.sad);
                    // if correctness<3 showing sad emoji
                } else {
                    updateQuestion();
                }
            }
        }
        else if (id==R.id.optionB){
            checkAnswer('b');
            if (currentQuestionIndex < 11) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
//                SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.putInt("store_ans",correct);
//                ed.putInt("store_ques",currentQuestionIndex);
//                ed.apply();
                // we are safe now!
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                    //ed.clear();
                    textView.setText("00:00:00");
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    OptionA.setVisibility(
                            View.INVISIBLE);
                    OptionB.setVisibility(
                            View.INVISIBLE);
                    OptionC.setVisibility(
                            View.INVISIBLE);
                    OptionD.setVisibility(
                            View.INVISIBLE);
                    if (correct > 6)

                        questionTextView.setText(
                                "CORRECTNESS IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
                    else
                        Image.setImageResource(
                                R.drawable.sad);
                    // if correctness<3 showing sad emoji
                } else {
                    updateQuestion();
                }
            }
        }
        else if (id==R.id.optionC){
            checkAnswer('c');
            if (currentQuestionIndex < 11) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
//                SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.putInt("store_ans",correct);
//                ed.putInt("store_ques",currentQuestionIndex);
//                ed.apply();
                // we are safe now!
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                    //ed.clear();
                    textView.setText("00:00:00");
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    OptionA.setVisibility(
                            View.INVISIBLE);
                    OptionB.setVisibility(
                            View.INVISIBLE);
                    OptionC.setVisibility(
                            View.INVISIBLE);
                    OptionD.setVisibility(
                            View.INVISIBLE);
                    if (correct > 6)

                        questionTextView.setText(
                                "CORRECTNESS IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
                    else
                        Image.setImageResource(
                                R.drawable.sad);
                    // if correctness<3 showing sad emoji
                } else {
                    updateQuestion();
                }
            }
        }
        else if (id==R.id.optionD){
            checkAnswer('d');
            if (currentQuestionIndex < 11) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
//                SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.putInt("store_ans",correct);
//                ed.putInt("store_ques",currentQuestionIndex);
//                ed.apply();
                // we are safe now!
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                    //ed.clear();
                    textView.setText("00:00:00");
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    OptionA.setVisibility(
                            View.INVISIBLE);
                    OptionB.setVisibility(
                            View.INVISIBLE);
                    OptionC.setVisibility(
                            View.INVISIBLE);
                    OptionD.setVisibility(
                            View.INVISIBLE);
                    if (correct > 6)

                        questionTextView.setText(
                                "CORRECTNESS IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
                    else
                        Image.setImageResource(
                                R.drawable.sad);
                    // if correctness<3 showing sad emoji
                } else {
                    updateQuestion();
                }
            }
        }
        else if (id==R.id.next_button) {
            // go to next question
            // limiting question bank range
            if (currentQuestionIndex < 11) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
//                SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                SharedPreferences.Editor ed= sd.edit();
//                ed.putInt("store_ans",correct);
//                ed.putInt("store_ques",currentQuestionIndex);
//                ed.apply();
                // we are safe now!
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                  //  ed.clear();
                    textView.setText("00:00:00");
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    OptionA.setVisibility(
                            View.INVISIBLE);
                    OptionB.setVisibility(
                            View.INVISIBLE);
                    OptionC.setVisibility(
                            View.INVISIBLE);
                    OptionD.setVisibility(
                            View.INVISIBLE);
                    if (correct > 6)

                        questionTextView.setText(
                                "CORRECTNESS IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
                    else
                        Image.setImageResource(
                                R.drawable.sad);
                    // if correctness<3 showing sad emoji
                } else {
                    updateQuestion();
                }
            }
        }
        else if (id==R.id.prev_button){
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questionBank.length;
                    updateQuestion();
//                    SharedPreferences sd= getSharedPreferences("Preference",MODE_PRIVATE);
//                    SharedPreferences.Editor ed= sd.edit();
//                    ed.putInt("store_ans",correct);
//                    ed.putInt("store_ques",currentQuestionIndex);
//                    ed.apply();
                }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 1:
                // setting up image for each
                // question
                Image.setImageResource(R.drawable.f1);
                break;
            case 2:
                Image.setImageResource(R.drawable.f1);
                break;
            case 3:
                Image.setImageResource(R.drawable.f1);
                break;
            case 4:
                Image.setImageResource(R.drawable.f1);
                break;
            case 5:
                Image.setImageResource(R.drawable.f1);
                break;
            case 6:
                Image.setImageResource(R.drawable.f1);
                break;
            case 7:
                Image.setImageResource(R.drawable.f1);
                break;
            case 8:
                Image.setImageResource(R.drawable.f1);
                break;
            case 9:
                Image.setImageResource(R.drawable.f1);
                break;
            case 10:
                Image.setImageResource(R.drawable.f1);
                break;
            case 11:
                Image.setImageResource(R.drawable.f1);
                break;
        }
    }
    private void checkAnswer(char userChooseCorrect)
    {
        char answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the
        // button clicked

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
