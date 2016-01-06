package johnkagga.me.celestini.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.UUID;

/**
 * Created by jokamjohn on 1/6/2016.
 */
@ParseClassName("StructuredQuestions")
public class StructuredQuestions extends ParseObject {

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("Uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("Uuid");
    }

    public void setOutcome(String pregOutcome) {
        put("PregnancyOutcome", pregOutcome);
    }

    public String getOutcome() {
        return getString("PregnancyOutcome");
    }

    public void setChronicDiseases(String chronicDiseases) {
        put("ChronicDiseases", chronicDiseases);
    }

    public String getChronicDiseases() {
        return getString("ChronicDiseases");
    }

    public void setInfertility(String infertility) {
        put("Infertility", infertility);
    }

    public String getInfertility() {
        return getString("Infertility");
    }
}
