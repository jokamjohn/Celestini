package johnkagga.me.celestini.provider.newvisit;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import johnkagga.me.celestini.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code newvisit} table.
 */
public class NewvisitContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return NewvisitColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable NewvisitSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable NewvisitSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Hospital Address
     */
    public NewvisitContentValues putHospitalAddress(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitContentValues putHospitalAddressNull() {
        mContentValues.putNull(NewvisitColumns.HOSPITAL_ADDRESS);
        return this;
    }

    /**
     * Hospital Name
     */
    public NewvisitContentValues putHospitalName(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitContentValues putHospitalNameNull() {
        mContentValues.putNull(NewvisitColumns.HOSPITAL_NAME);
        return this;
    }

    public NewvisitContentValues putVisitNo(@Nullable Integer value) {
        mContentValues.put(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitContentValues putVisitNoNull() {
        mContentValues.putNull(NewvisitColumns.VISIT_NO);
        return this;
    }

    public NewvisitContentValues putPatientName(@Nullable String value) {
        mContentValues.put(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitContentValues putPatientNameNull() {
        mContentValues.putNull(NewvisitColumns.PATIENT_NAME);
        return this;
    }

    /**
     * Home District
     */
    public NewvisitContentValues putHomeDistrict(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitContentValues putHomeDistrictNull() {
        mContentValues.putNull(NewvisitColumns.HOME_DISTRICT);
        return this;
    }

    /**
     * Date of birth
     */
    public NewvisitContentValues putDob(@Nullable Date value) {
        mContentValues.put(NewvisitColumns.DOB, value == null ? null : value.getTime());
        return this;
    }

    public NewvisitContentValues putDobNull() {
        mContentValues.putNull(NewvisitColumns.DOB);
        return this;
    }

    public NewvisitContentValues putDob(@Nullable Long value) {
        mContentValues.put(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitContentValues putEducationLevel(@Nullable String value) {
        mContentValues.put(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitContentValues putEducationLevelNull() {
        mContentValues.putNull(NewvisitColumns.EDUCATION_LEVEL);
        return this;
    }

    /**
     * Tribe
     */
    public NewvisitContentValues putTribe(@Nullable String value) {
        mContentValues.put(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitContentValues putTribeNull() {
        mContentValues.putNull(NewvisitColumns.TRIBE);
        return this;
    }

    /**
     * Religion
     */
    public NewvisitContentValues putReligion(@Nullable String value) {
        mContentValues.put(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitContentValues putReligionNull() {
        mContentValues.putNull(NewvisitColumns.RELIGION);
        return this;
    }

    public NewvisitContentValues putOccupation(@Nullable String value) {
        mContentValues.put(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitContentValues putOccupationNull() {
        mContentValues.putNull(NewvisitColumns.OCCUPATION);
        return this;
    }

    /**
     * Town
     */
    public NewvisitContentValues putTown(@Nullable String value) {
        mContentValues.put(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitContentValues putTownNull() {
        mContentValues.putNull(NewvisitColumns.TOWN);
        return this;
    }

    /**
     * Blood Pressure
     */
    public NewvisitContentValues putBloodpressure(@Nullable String value) {
        mContentValues.put(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitContentValues putBloodpressureNull() {
        mContentValues.putNull(NewvisitColumns.BLOODPRESSURE);
        return this;
    }

    public NewvisitContentValues putParityNoOfPregnancies(@Nullable Integer value) {
        mContentValues.put(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitContentValues putParityNoOfPregnanciesNull() {
        mContentValues.putNull(NewvisitColumns.PARITY_NO_OF_PREGNANCIES);
        return this;
    }

    /**
     * Pregnancy_Outcome
     */
    public NewvisitContentValues putPregnancyOutcome(@Nullable String value) {
        mContentValues.put(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitContentValues putPregnancyOutcomeNull() {
        mContentValues.putNull(NewvisitColumns.PREGNANCY_OUTCOME);
        return this;
    }

    /**
     * History of hypertension in past pregnancies
     */
    public NewvisitContentValues putPastPregnancyHypertensionHistory(@Nullable String value) {
        mContentValues.put(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitContentValues putPastPregnancyHypertensionHistoryNull() {
        mContentValues.putNull(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY);
        return this;
    }

    public NewvisitContentValues putLastNormalMpDate(@Nullable String value) {
        mContentValues.put(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitContentValues putLastNormalMpDateNull() {
        mContentValues.putNull(NewvisitColumns.LAST_NORMAL_MP_DATE);
        return this;
    }

    /**
     * Previous C-section
     */
    public NewvisitContentValues putPreviousCaesarean(@Nullable String value) {
        mContentValues.put(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitContentValues putPreviousCaesareanNull() {
        mContentValues.putNull(NewvisitColumns.PREVIOUS_CAESAREAN);
        return this;
    }

    /**
     * Hypertension before pregnancy
     */
    public NewvisitContentValues putHypertensionBeforePregnancy(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitContentValues putHypertensionBeforePregnancyNull() {
        mContentValues.putNull(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY);
        return this;
    }

    public NewvisitContentValues putDiabeticBeforePregnancy(@Nullable String value) {
        mContentValues.put(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitContentValues putDiabeticBeforePregnancyNull() {
        mContentValues.putNull(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY);
        return this;
    }

    /**
     * Chronic renal disease
     */
    public NewvisitContentValues putChronicRenalDisease(@Nullable String value) {
        mContentValues.put(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitContentValues putChronicRenalDiseaseNull() {
        mContentValues.putNull(NewvisitColumns.CHRONIC_RENAL_DISEASE);
        return this;
    }

    /**
     * Thyroid disease
     */
    public NewvisitContentValues putThyroidDisease(@Nullable String value) {
        mContentValues.put(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitContentValues putThyroidDiseaseNull() {
        mContentValues.putNull(NewvisitColumns.THYROID_DISEASE);
        return this;
    }

    public NewvisitContentValues putSickleCells(@Nullable String value) {
        mContentValues.put(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitContentValues putSickleCellsNull() {
        mContentValues.putNull(NewvisitColumns.SICKLE_CELLS);
        return this;
    }

    /**
     * Any other chronic problem
     */
    public NewvisitContentValues putOtherChronicProblem(@Nullable String value) {
        mContentValues.put(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitContentValues putOtherChronicProblemNull() {
        mContentValues.putNull(NewvisitColumns.OTHER_CHRONIC_PROBLEM);
        return this;
    }

    /**
     * Do you have headache
     */
    public NewvisitContentValues putHeadacheSymptome(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitContentValues putHeadacheSymptomeNull() {
        mContentValues.putNull(NewvisitColumns.HEADACHE_SYMPTOME);
        return this;
    }

    public NewvisitContentValues putEpigastricPain(@Nullable String value) {
        mContentValues.put(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitContentValues putEpigastricPainNull() {
        mContentValues.putNull(NewvisitColumns.EPIGASTRIC_PAIN);
        return this;
    }

    /**
     * Fever
     */
    public NewvisitContentValues putFever(@Nullable String value) {
        mContentValues.put(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitContentValues putFeverNull() {
        mContentValues.putNull(NewvisitColumns.FEVER);
        return this;
    }

    /**
     * Nausea and vomiting
     */
    public NewvisitContentValues putNauseaAndVomiting(@Nullable String value) {
        mContentValues.put(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitContentValues putNauseaAndVomitingNull() {
        mContentValues.putNull(NewvisitColumns.NAUSEA_AND_VOMITING);
        return this;
    }

    public NewvisitContentValues putVisualDisturbance(@Nullable String value) {
        mContentValues.put(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitContentValues putVisualDisturbanceNull() {
        mContentValues.putNull(NewvisitColumns.VISUAL_DISTURBANCE);
        return this;
    }

    /**
     * Chest pain
     */
    public NewvisitContentValues putChestPain(@Nullable String value) {
        mContentValues.put(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitContentValues putChestPainNull() {
        mContentValues.putNull(NewvisitColumns.CHEST_PAIN);
        return this;
    }

    /**
     * Difficulty in breathing
     */
    public NewvisitContentValues putDifficultyInBreathing(@Nullable String value) {
        mContentValues.put(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitContentValues putDifficultyInBreathingNull() {
        mContentValues.putNull(NewvisitColumns.DIFFICULTY_IN_BREATHING);
        return this;
    }

    /**
     * Vaginal bleeding
     */
    public NewvisitContentValues putVaginalBleeding(@Nullable String value) {
        mContentValues.put(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitContentValues putVaginalBleedingNull() {
        mContentValues.putNull(NewvisitColumns.VAGINAL_BLEEDING);
        return this;
    }

    /**
     * Hypertension drugs
     */
    public NewvisitContentValues putHypertensionDrugs(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitContentValues putHypertensionDrugsNull() {
        mContentValues.putNull(NewvisitColumns.HYPERTENSION_DRUGS);
        return this;
    }

    /**
     * Diabetes drugs
     */
    public NewvisitContentValues putDiabetesDrugs(@Nullable String value) {
        mContentValues.put(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitContentValues putDiabetesDrugsNull() {
        mContentValues.putNull(NewvisitColumns.DIABETES_DRUGS);
        return this;
    }

    /**
     * Iron tablets
     */
    public NewvisitContentValues putIronTablets(@Nullable String value) {
        mContentValues.put(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitContentValues putIronTabletsNull() {
        mContentValues.putNull(NewvisitColumns.IRON_TABLETS);
        return this;
    }

    /**
     * Folic acid tablets
     */
    public NewvisitContentValues putFolicAcidTablets(@Nullable String value) {
        mContentValues.put(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitContentValues putFolicAcidTabletsNull() {
        mContentValues.putNull(NewvisitColumns.FOLIC_ACID_TABLETS);
        return this;
    }

    /**
     * Any other drugs
     */
    public NewvisitContentValues putOtherDrugs(@Nullable String value) {
        mContentValues.put(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitContentValues putOtherDrugsNull() {
        mContentValues.putNull(NewvisitColumns.OTHER_DRUGS);
        return this;
    }

    /**
     * Hypertension while on contraceptives
     */
    public NewvisitContentValues putHypertensionHistoryCocs(@Nullable String value) {
        mContentValues.put(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitContentValues putHypertensionHistoryCocsNull() {
        mContentValues.putNull(NewvisitColumns.HYPERTENSION_HISTORY_COCS);
        return this;
    }

    /**
     * History of preeclampsia in the family
     */
    public NewvisitContentValues putPreeclampsiaFamilyHistory(@Nullable String value) {
        mContentValues.put(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitContentValues putPreeclampsiaFamilyHistoryNull() {
        mContentValues.putNull(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY);
        return this;
    }

    /**
     * Any treatment for infertility in the past
     */
    public NewvisitContentValues putInfertilityTreatmentHistory(@Nullable String value) {
        mContentValues.put(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitContentValues putInfertilityTreatmentHistoryNull() {
        mContentValues.putNull(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY);
        return this;
    }

    /**
     * Multiple gestation
     */
    public NewvisitContentValues putMultipleGestation(@Nullable String value) {
        mContentValues.put(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitContentValues putMultipleGestationNull() {
        mContentValues.putNull(NewvisitColumns.MULTIPLE_GESTATION);
        return this;
    }
}
