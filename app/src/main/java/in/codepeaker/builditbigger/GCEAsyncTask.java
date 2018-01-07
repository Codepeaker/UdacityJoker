package in.codepeaker.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jokes.backend.myApi.MyApi;

import java.io.IOException;

import static com.google.api.client.extensions.android.http.AndroidHttp.newCompatibleTransport;

/**
 * Created by github.com/codepeaker on 4/1/18.
 */

public class GCEAsyncTask extends AsyncTask<GCEInterface, Void, String> {
    private static MyApi myApiService = null;
    public String TAG = "GCTASK";
    GCEInterface gceInterface;

    @Override
    protected String doInBackground(GCEInterface... params) {

        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokerapp-191310.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        gceInterface = params[0];

        try {

            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "doInBackground: " + e.toString());
            return e.toString();

        }
    }

    @Override
    protected void onPostExecute(String s) {
        gceInterface.receiveJoke(s);
        super.onPostExecute(s);
    }
}
