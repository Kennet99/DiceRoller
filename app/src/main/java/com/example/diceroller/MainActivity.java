package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_Input = findViewById(R.id.number_Input);
        button_Submit = findViewById(R.id.button_Submit);
        userGuess = findViewById(R.id.userGuess);

        button_Submit.setOnClickListener(this);

        //textView3= findViewById(R.id.textView3);
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



    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.RolledNumber);

        Random r = new Random();
        int number = r.nextInt(7);

        tv.setText(Integer.toString(number));
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

    public void guessClicked(View view){
        TextView tv = this.findViewById(R.id.RolledNumber);
        TextView userGuess = this.findViewById(R.id.userGuess);
        TextView resultView = this.findViewById(R.id.resultView);
        TextView scoreView = this.findViewById(R.id.scoreView);

        try{
            int numGuess = Integer.parseInt(userGuess.getText().toString());
            int DiceRoll = Integer.parseInt((tv.getText().toString()));

            if (numGuess == DiceRoll){
                score++;
                resultView.setText("Congratulations!");
                scoreView.setText(Integer.toString(score));
            }
            else if (numGuess != DiceRoll){
                resultView.setText("Not the right guess, try again!");
            }
        }
        catch (Exception ex){
            Log.e("Number Error", ex.toString());
        }
    }
}