package com.darclabs.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        //Brings over all the extras from the intent in main activity and puts them into the Bundle "Extras".
        Bundle extra = getIntent().getExtras();

        showGuessTextView = findViewById(R.id.received_textview);
        //If statement used to make sure the StringExtra method is actually passing something.
        if (extra != null){
            //Pulls in the intent with the added string extra from the main activity and puts it in the string "value".
            //Sets the text view on this activity to the value passed in the getIntent and get string extra method.
            showGuessTextView.setText(extra.getString("guess"));
        }
        //onClick for text view
        showGuessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back","From Second Activity");
                //Pass that the data is okay to be sent back and then pass the data (intent).
                setResult(RESULT_OK,intent);
                //Pop out of the stack and finish this activity.
                finish();
            }
        });

    }
}
