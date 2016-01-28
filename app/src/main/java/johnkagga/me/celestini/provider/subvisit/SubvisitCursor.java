package johnkagga.me.celestini.provider.subvisit;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import johnkagga.me.celestini.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code subvisit} table.
 */
public class SubvisitCursor extends AbstractCursor implements SubvisitModel {
    public SubvisitCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(SubvisitColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Patient Id
     * Can be {@code null}.
     */
    @Nullable
    public String getPatientId() {
        String res = getStringOrNull(SubvisitColumns.PATIENT_ID);
        return res;
    }

    /**
     * Chronic problem
     * Can be {@code null}.
     */
    @Nullable
    public String getAnyOtherChronicMedicalProblem() {
        String res = getStringOrNull(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM);
        return res;
    }

    /**
     * Get the {@code head_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHeadPain() {
        String res = getStringOrNull(SubvisitColumns.HEAD_PAIN);
        return res;
    }

    /**
     * Get the {@code epigastric_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEpigastricPain() {
        String res = getStringOrNull(SubvisitColumns.EPIGASTRIC_PAIN);
        return res;
    }

    /**
     * Fever
     * Can be {@code null}.
     */
    @Nullable
    public String getFever() {
        String res = getStringOrNull(SubvisitColumns.FEVER);
        return res;
    }

    /**
     * Nausea and vomiting
     * Can be {@code null}.
     */
    @Nullable
    public String getNauseaVomiting() {
        String res = getStringOrNull(SubvisitColumns.NAUSEA_VOMITING);
        return res;
    }

    /**
     * Get the {@code visual_disturbances} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVisualDisturbances() {
        String res = getStringOrNull(SubvisitColumns.VISUAL_DISTURBANCES);
        return res;
    }

    /**
     * Chest pain
     * Can be {@code null}.
     */
    @Nullable
    public String getChestPain() {
        String res = getStringOrNull(SubvisitColumns.CHEST_PAIN);
        return res;
    }

    /**
     * Difficulty in breathing
     * Can be {@code null}.
     */
    @Nullable
    public String getDifficultyInBreathing() {
        String res = getStringOrNull(SubvisitColumns.DIFFICULTY_IN_BREATHING);
        return res;
    }

    /**
     * Get the {@code vaginal_bleeding_with_abdominal_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVaginalBleedingWithAbdominalPain() {
        String res = getStringOrNull(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN);
        return res;
    }

    /**
     * Hypertension drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getHypertensionDrugs() {
        String res = getStringOrNull(SubvisitColumns.HYPERTENSION_DRUGS);
        return res;
    }

    /**
     * Diabetes drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getDiabetesDrugs() {
        String res = getStringOrNull(SubvisitColumns.DIABETES_DRUGS);
        return res;
    }

    /**
     * Get the {@code iron_tablets} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getIronTablets() {
        String res = getStringOrNull(SubvisitColumns.IRON_TABLETS);
        return res;
    }

    /**
     * Folic acid tablets
     * Can be {@code null}.
     */
    @Nullable
    public String getFolicAcidTablets() {
        String res = getStringOrNull(SubvisitColumns.FOLIC_ACID_TABLETS);
        return res;
    }

    /**
     * Any other drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getAnyOtherSpecify() {
        String res = getStringOrNull(SubvisitColumns.ANY_OTHER_SPECIFY);
        return res;
    }

    /**
     * Get the {@code any_multiple_gestation} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getAnyMultipleGestation() {
        String res = getStringOrNull(SubvisitColumns.ANY_MULTIPLE_GESTATION);
        return res;
    }
}
