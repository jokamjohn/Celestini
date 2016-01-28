package johnkagga.me.celestini;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.HealthCheckQuestions;
import johnkagga.me.celestini.data.HealthYesNoQuestions;
import johnkagga.me.celestini.data.StructuredQuestions;

/**
 * Created by jokamjohn on 1/5/2016.
 */
public class CelestiniApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Register Parse classes here
        ParseObject.registerSubclass(ClientContactInformation.class);
        ParseObject.registerSubclass(HealthYesNoQuestions.class);
        ParseObject.registerSubclass(HealthCheckQuestions.class);
        ParseObject.registerSubclass(StructuredQuestions.class);

        //Initialize the Parse SDK
        Parse.initialize(this);
    }
}
