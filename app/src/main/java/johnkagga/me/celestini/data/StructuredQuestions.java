package johnkagga.me.celestini.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.UUID;

/**
 * Created by jokamjohn on 1/6/2016.
 */
@ParseClassName("StructuredQuestions")
public class StructuredQuestions extends ParseObject {


    public void setPegnanciesBefore(int numberOfPreg) {
        put("NoOfPregnanciesBefore", numberOfPreg);
    }

    public void setOutcome(String pregOutcome) {
        put("PregnancyOutcome", pregOutcome);
    }

    public String getOutcome() {
        return getString("PregnancyOutcome");
    }

    public void setInfertility(String infertility) {
        put("Infertility", infertility);
    }

    public String getInfertility() {
        return getString("Infertility");
    }

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("Uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("Uuid");
    }
}
