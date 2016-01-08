package johnkagga.me.celestini.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

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

    public void setHistoryHypertension(String historyHypertension) {
        put("HypertensionHistory", historyHypertension);
    }

    public boolean getHypertensionHistory() {
        return getBoolean("HypertensionHistory");
    }

    public void setCesarean(String cesarean) {
        put("Cesarean", cesarean);
    }

    public String getCesarean() {
        return getString("Cesarean");
    }

    public void setHypertensive(String hypertensive) {
        put("HypertensiveBeforePregnancy", hypertensive);
    }

    public String getHypertensive() {
        return getString("HypertensiveBeforePregnancy");
    }

    public void setDiabetic(String diabetic) {
        put("Diabetic", diabetic);
    }

    public String getDiabetic() {
        return getString("Diabetic");
    }

    public void setChronicRenal(String chronic) {
        put("ChronicRenal", chronic);
    }

    public String getChronicRenal() {
        return getString("ChronicRenal");
    }

    public void setThyroid(String thyroid) {
        put("Thyroid", thyroid);
    }

    public String getThyroid() {
        return getString("Thyroid");
    }

    public void setSickleCell(String sickleCell) {
        put("SickleCell", sickleCell);
    }

    public String getSickleCell() {
        return getString("SickleCell");
    }

    public void setMultipleGestation(String multipleGestation) {
        put("MultipleGestation", multipleGestation);
    }

    public static ParseQuery<HealthYesNoQuestions> getQuery() {
        return ParseQuery.getQuery(HealthYesNoQuestions.class);
    }
}
