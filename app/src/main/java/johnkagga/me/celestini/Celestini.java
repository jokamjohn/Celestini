package johnkagga.me.celestini;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

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

        //Register Parse classes here
        ParseObject.registerSubclass(ClientContactInformation.class);
        ParseObject.registerSubclass(HealthYesNoQuestions.class);

        //Initialize the Parse SDK
        Parse.initialize(this);
    }
}
