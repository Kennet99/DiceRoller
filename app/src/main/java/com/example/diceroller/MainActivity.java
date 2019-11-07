package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.*;
import java.util.Arrays;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText number_Input;
    Button button_Submit;
    TextView userGuess;
    String str_number_Input;
    Button btnShowResult;
    TextView resultView;
    TextView RolledNumber;
    TextView scoreView;
    TextView questionView;
    TextView userRoll;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_Input = findViewById(R.id.number_Input);
        button_Submit = findViewById(R.id.button_Submit);
        userGuess = findViewById(R.id.userGuess);

        button_Submit.setOnClickListener(this);

        RolledNumber = findViewById(R.id.RolledNumber);
        scoreView = findViewById(R.id.scoreView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void roll_the_dice(View view) {
        TextView userRoll = this.findViewById(R.id.RolledNumber);
        Random r = new Random();
        int number = r.nextInt(6) + 1;
        userRoll.setText(Integer.toString(number));
    }

    @Override
    public void onClick(View view) {
        int viewGuess = view.getId();
        if (viewGuess == R.id.button_Submit) {
            str_number_Input = number_Input.getText().toString().trim();
            String guess = str_number_Input;
            userGuess.setText(guess);
        }
    }

    public void guessClicked(View view) {
        TextView userRoll = this.findViewById(R.id.RolledNumber);
        TextView userGuess = this.findViewById(R.id.userGuess);
        TextView resultView = this.findViewById(R.id.resultView);
        TextView scoreView = this.findViewById(R.id.scoreView);

        try {
            int numGuess = Integer.parseInt(userGuess.getText().toString());
            int DiceRoll = Integer.parseInt((userRoll.getText().toString()));
            if (numGuess == DiceRoll) {
                score++;
                resultView.setText("Congratulations!");
                scoreView.setText(Integer.toString(score));
            } else if (numGuess != DiceRoll) {
                resultView.setText("Not the right guess, try again!");
            }
        } catch (Exception ex) {
            Log.e("Number Error", ex.toString());
        }
    }

    public void on_button_clicked(View view) {
        TextView userRoll = this.findViewById(R.id.RolledNumber);
        TextView Question = this.findViewById(R.id.questionView);

        final String[] QuestionList = new String[6];
        QuestionList[0] = "If you could go anywhere in the world, where would you go?";
        QuestionList[1] = "If you were stranded on a desert island, what three things would you want to take with you?";
        QuestionList[2] = "If you could eat only one food for the rest of your life, what would that be?";
        QuestionList[3] = "If you won a million dollars, what is the first thing you would buy?";
        QuestionList[4] = "If you could spend the day with one fictional character, who would it be?";
        QuestionList[5] = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";

        try {
            int DiceRoll = Integer.parseInt(userRoll.getText().toString());

            if (DiceRoll == 1) {
                Question.setText(QuestionList[0]);
            }
            if (DiceRoll == 2){
                Question.setText(QuestionList[1]);
            }
            if (DiceRoll == 3){
                Question.setText(QuestionList[2]);
            }
            if (DiceRoll == 4){
                Question.setText(QuestionList[3]);
            }
            if(DiceRoll == 5){
                Question.setText(QuestionList[4]);
            }
            if(DiceRoll == 6){
                Question.setText(QuestionList[5]);
            }
            else if (DiceRoll == 0){
                Question.setText("");
            }
        }
        catch(Exception ex)
            {
                Log.e("Question Error", ex.toString());
            }
    }
}