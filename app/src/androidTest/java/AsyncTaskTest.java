import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    private String mResultString;
    private CountDownLatch signal = null;
    private Context mContext;
    private EndpointsAsyncTask asyncTask;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void useAppContext() throws Exception {
        mContext = InstrumentationRegistry.getTargetContext();
    }

    @Before
    public void setCountDown() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Test
    public void testAsyncTask() throws InterruptedException {
        onView(withId(R.id.button_joke)).perform(click());
//        EndpointsAsyncTask task = new EndpointsAsyncTask();
//        task.setListener(new EndpointsAsyncTask.AsyncTaskListener() {
//            @Override
//            public void onComplete(String result, Exception e) {
//                mResultString = result;
//                mError = e;
//                signal.countDown();
//            }
//        }).execute(mContext);
//        signal.await();
//

        asyncTask =
                (EndpointsAsyncTask) new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncTaskListener() {

            @Override
            public void onComplete(String result, Exception e) {
                mResultString = result;
                signal.countDown();
            }
        }).execute(mContext);
        signal.await();

        assertFalse(TextUtils.isEmpty(mResultString));
    }

    @After
    public void finishCountDown() throws Exception {
        signal.countDown();
    }

}


