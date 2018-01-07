package in.codepeaker.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import in.codepeaker.showjoke.CheckThisJoke;


public class MainActivity extends AppCompatActivity implements GCEInterface {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(in.codepeaker.builditbigger.R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(in.codepeaker.builditbigger.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == in.codepeaker.builditbigger.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
            new GCEAsyncTask().execute(MainActivity.this);
        }
    }

    @Override
    public void receiveJoke(String joke) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Intent intent = new Intent(MainActivity.this, CheckThisJoke.class);
        intent.putExtra("jokeExtra", joke);
        startActivity(intent);
    }
}
