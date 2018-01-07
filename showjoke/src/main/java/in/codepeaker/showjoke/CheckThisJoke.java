package in.codepeaker.showjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CheckThisJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_this_joke);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String joke = bundle.getString("jokeExtra");
            ((TextView) findViewById(R.id.joke_textview)).setText(joke);
        }

    }
}
