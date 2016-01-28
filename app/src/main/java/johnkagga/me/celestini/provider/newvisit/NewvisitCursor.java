package johnkagga.me.celestini.provider.newvisit;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import johnkagga.me.celestini.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code newvisit} table.
 */
public class NewvisitCursor extends AbstractCursor implements NewvisitModel {
    public NewvisitCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(NewvisitColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Hospital Address
     * Can be {@code null}.
     */
    @Nullable
    public String getHospitalAddress() {
        String res = getStringOrNull(NewvisitColumns.HOSPITAL_ADDRESS);
        return res;
    }

    /**
     * Hospital Name
     * Can be {@code null}.
     */
    @Nullable
    public String getHospitalName() {
        String res = getStringOrNull(NewvisitColumns.HOSPITAL_NAME);
        return res;
    }

    /**
     * Get the {@code visit_no} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVisitNo() {
        Integer res = getIntegerOrNull(NewvisitColumns.VISIT_NO);
        return res;
    }

    /**
     * Get the {@code patient_name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPatientName() {
        String res = getStringOrNull(NewvisitColumns.PATIENT_NAME);
        return res;
    }

    /**
     * Home District
     * Can be {@code null}.
     */
    @Nullable
    public String getHomeDistrict() {
        String res = getStringOrNull(NewvisitColumns.HOME_DISTRICT);
        return res;
    }

    /**
     * Date of birth
     * Can be {@code null}.
     */
    @Nullable
    public Date getDob() {
        Date res = getDateOrNull(NewvisitColumns.DOB);
        return res;
    }

    /**
     * Get the {@code education_level} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEducationLevel() {
        String res = getStringOrNull(NewvisitColumns.EDUCATION_LEVEL);
        return res;
    }

    /**
     * Tribe
     * Can be {@code null}.
     */
    @Nullable
    public String getTribe() {
        String res = getStringOrNull(NewvisitColumns.TRIBE);
        return res;
    }

    /**
     * Religion
     * Can be {@code null}.
     */
    @Nullable
    public String getReligion() {
        String res = getStringOrNull(NewvisitColumns.RELIGION);
        return res;
    }

    /**
     * Get the {@code occupation} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOccupation() {
        String res = getStringOrNull(NewvisitColumns.OCCUPATION);
        return res;
    }

    /**
     * Town
     * Can be {@code null}.
     */
    @Nullable
    public String getTown() {
        String res = getStringOrNull(NewvisitColumns.TOWN);
        return res;
    }

    /**
     * Blood Pressure
     * Can be {@code null}.
     */
    @Nullable
    public String getBloodpressure() {
        String res = getStringOrNull(NewvisitColumns.BLOODPRESSURE);
        return res;
    }

    /**
     * Get the {@code parity_no_of_pregnancies} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getParityNoOfPregnancies() {
        Integer res = getIntegerOrNull(NewvisitColumns.PARITY_NO_OF_PREGNANCIES);
        return res;
    }

    /**
     * Pregnancy_Outcome
     * Can be {@code null}.
     */
    @Nullable
    public String getPregnancyOutcome() {
        String res = getStringOrNull(NewvisitColumns.PREGNANCY_OUTCOME);
        return res;
    }

    /**
     * History of hypertension in past pregnancies
     * Can be {@code null}.
     */
    @Nullable
    public String getPastPregnancyHypertensionHistory() {
        String res = getStringOrNull(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY);
        return res;
    }

    /**
     * Get the {@code last_normal_mp_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLastNormalMpDate() {
        String res = getStringOrNull(NewvisitColumns.LAST_NORMAL_MP_DATE);
        return res;
    }

    /**
     * Previous C-section
     * Can be {@code null}.
     */
    @Nullable
    public String getPreviousCaesarean() {
        String res = getStringOrNull(NewvisitColumns.PREVIOUS_CAESAREAN);
        return res;
    }

    /**
     * Hypertension before pregnancy
     * Can be {@code null}.
     */
    @Nullable
    public String getHypertensionBeforePregnancy() {
        String res = getStringOrNull(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY);
        return res;
    }

    /**
     * Get the {@code diabetic_before_pregnancy} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDiabeticBeforePregnancy() {
        String res = getStringOrNull(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY);
        return res;
    }

    /**
     * Chronic renal disease
     * Can be {@code null}.
     */
    @Nullable
    public String getChronicRenalDisease() {
        String res = getStringOrNull(NewvisitColumns.CHRONIC_RENAL_DISEASE);
        return res;
    }

    /**
     * Thyroid disease
     * Can be {@code null}.
     */
    @Nullable
    public String getThyroidDisease() {
        String res = getStringOrNull(NewvisitColumns.THYROID_DISEASE);
        return res;
    }

    /**
     * Get the {@code sickle_cells} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSickleCells() {
        String res = getStringOrNull(NewvisitColumns.SICKLE_CELLS);
        return res;
    }

    /**
     * Any other chronic problem
     * Can be {@code null}.
     */
    @Nullable
    public String getOtherChronicProblem() {
        String res = getStringOrNull(NewvisitColumns.OTHER_CHRONIC_PROBLEM);
        return res;
    }

    /**
     * Do you have headache
     * Can be {@code null}.
     */
    @Nullable
    public String getHeadacheSymptome() {
        String res = getStringOrNull(NewvisitColumns.HEADACHE_SYMPTOME);
        return res;
    }

    /**
     * Get the {@code epigastric_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEpigastricPain() {
        String res = getStringOrNull(NewvisitColumns.EPIGASTRIC_PAIN);
        return res;
    }

    /**
     * Fever
     * Can be {@code null}.
     */
    @Nullable
    public String getFever() {
        String res = getStringOrNull(NewvisitColumns.FEVER);
        return res;
    }

    /**
     * Nausea and vomiting
     * Can be {@code null}.
     */
    @Nullable
    public String getNauseaAndVomiting() {
        String res = getStringOrNull(NewvisitColumns.NAUSEA_AND_VOMITING);
        return res;
    }

    /**
     * Get the {@code visual_disturbance} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVisualDisturbance() {
        String res = getStringOrNull(NewvisitColumns.VISUAL_DISTURBANCE);
        return res;
    }

    /**
     * Chest pain
     * Can be {@code null}.
     */
    @Nullable
    public String getChestPain() {
        String res = getStringOrNull(NewvisitColumns.CHEST_PAIN);
        return res;
    }

    /**
     * Difficulty in breathing
     * Can be {@code null}.
     */
    @Nullable
    public String getDifficultyInBreathing() {
        String res = getStringOrNull(NewvisitColumns.DIFFICULTY_IN_BREATHING);
        return res;
    }

    /**
     * Vaginal bleeding
     * Can be {@code null}.
     */
    @Nullable
    public String getVaginalBleeding() {
        String res = getStringOrNull(NewvisitColumns.VAGINAL_BLEEDING);
        return res;
    }

    /**
     * Hypertension drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getHypertensionDrugs() {
        String res = getStringOrNull(NewvisitColumns.HYPERTENSION_DRUGS);
        return res;
    }

    /**
     * Diabetes drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getDiabetesDrugs() {
        String res = getStringOrNull(NewvisitColumns.DIABETES_DRUGS);
        return res;
    }

    /**
     * Iron tablets
     * Can be {@code null}.
     */
    @Nullable
    public String getIronTablets() {
        String res = getStringOrNull(NewvisitColumns.IRON_TABLETS);
        return res;
    }

    /**
     * Folic acid tablets
     * Can be {@code null}.
     */
    @Nullable
    public String getFolicAcidTablets() {
        String res = getStringOrNull(NewvisitColumns.FOLIC_ACID_TABLETS);
        return res;
    }

    /**
     * Any other drugs
     * Can be {@code null}.
     */
    @Nullable
    public String getOtherDrugs() {
        String res = getStringOrNull(NewvisitColumns.OTHER_DRUGS);
        return res;
    }

    /**
     * Hypertension while on contraceptives
     * Can be {@code null}.
     */
    @Nullable
    public String getHypertensionHistoryCocs() {
        String res = getStringOrNull(NewvisitColumns.HYPERTENSION_HISTORY_COCS);
        return res;
    }

    /**
     * History of preeclampsia in the family
     * Can be {@code null}.
     */
    @Nullable
    public String getPreeclampsiaFamilyHistory() {
        String res = getStringOrNull(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY);
        return res;
    }

    /**
     * Any treatment for infertility in the past
     * Can be {@code null}.
     */
    @Nullable
    public String getInfertilityTreatmentHistory() {
        String res = getStringOrNull(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY);
        return res;
    }

    /**
     * Multiple gestation
     * Can be {@code null}.
     */
    @Nullable
    public String getMultipleGestation() {
        String res = getStringOrNull(NewvisitColumns.MULTIPLE_GESTATION);
        return res;
    }
}
