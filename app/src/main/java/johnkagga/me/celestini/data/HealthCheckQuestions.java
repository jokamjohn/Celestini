package johnkagga.me.celestini.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by jokamjohn on 1/6/2016.
 */
@ParseClassName("HealthCheckQuestions")
public class HealthCheckQuestions extends ParseObject {

    public void setDiseases(List<String> diseases) {
        put("Diseases", diseases);
    }

    public List getDiseases() {
        return getList("Diseases");
    }

    public void setDrugs(List<String> drugs) {
        put("Drugs", drugs);
    }

    public List getDrugs() {
        return getList("Drugs");
    }

    public void setOtherDiseases(String otherDiseases) {
        put("OtherDiseases", otherDiseases);
    }

    public String getOtherDiseases() {
        return getString("OtherDiseases");
    }

    public void setPreeclampsia(List people) {
        put("Preeclampsia", people);
    }

    public List getPreeclampsia() {
        return getList("Preeclampsia");
    }

    public void setGestation(List gestation) {
        put("Gestation", gestation);
    }

    public List getGestation() {
        return getList("Gestation");
    }
}
