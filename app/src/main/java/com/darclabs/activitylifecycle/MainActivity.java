package com.darclabs.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Initiate variables
    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Links button variable with the button in the layout
        showGuess = findViewById(R.id.button_guess);

        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gets the user input of guess, makes it a string and trims extra junk (spaces, etc.)
                String guess = enterGuess.getText().toString().trim();

                //If/else statement to make sure the user is actually entering a guess
                if(!guess.isEmpty()){
                    //Switches from Main Activity to ShowGuess activity on click of Guess Name button
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    intent.putExtra("guess", guess);
                    intent.putExtra("name","bond");
                    intent.putExtra("age","34");
                    startActivityForResult(intent,REQUEST_CODE);
                }else{
                    Toast.makeText(MainActivity.this,"Enter a guess",
                            Toast.LENGTH_SHORT)
                            .show();
                }




            }
        });



    }
    //Used to get things from the second activity back to this MainActivity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Makes sure the requestCode is correct and the result is okay, then it accesses "data".
        if (requestCode == REQUEST_CODE){
                //Says that there is actually something in "data".
                assert data != null;
                //Saves the data that was passed into a string called "message"
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }
}
