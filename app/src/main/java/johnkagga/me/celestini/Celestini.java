package johnkagga.me.celestini;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by jokamjohn on 1/5/2016.
 */
public class Celestini extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Enable the Parse DataStore
        // Power your app with Local Datastore. For more info, go to
        // https://parse.com/docs/android/guide#local-datastore
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
    }
}
