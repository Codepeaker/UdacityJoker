package in.udacity.gradle.builitbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import in.codepeaker.builditbigger.GCEAsyncTask;
import in.codepeaker.builditbigger.GCEInterface;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by github.com/codepeaker on 6/1/18.
 */

public class ApplicationTest extends ApplicationTestCase<Application> {

    private String joke;

    public ApplicationTest() {
        super(Application.class);
    }

    public void testJoke() {
        try {
            final CountDownLatch cdl = new CountDownLatch(1);
            new GCEAsyncTask().execute(new GCEInterface() {
                @Override
                public void receiveJoke(String joke) {
                    boolean success = false;
                    ApplicationTest.this.joke = joke;
                    if (!joke.isEmpty()) {
                        success = true;
                    }
                    assertEquals(success, true);
                    cdl.countDown();

                }

            });
            cdl.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ignored) {
            fail(ignored.getMessage());
        }
    }

}