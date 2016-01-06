package johnkagga.me.celestini;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.UUID;

/**
 * Created by jokamjohn on 1/6/2016.
 */
@ParseClassName("HealthYesNoQuestions")
public class HealthYesNoQuestions extends ParseObject {

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("Uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("Uuid");
    }

    public void setSync(boolean isSynced) {
        put("isSynced", isSynced);
    }

    public boolean isSynced() {
        return getBoolean("isSynced");
    }

}
