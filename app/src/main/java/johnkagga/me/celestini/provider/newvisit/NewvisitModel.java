package johnkagga.me.celestini.provider.newvisit;

import johnkagga.me.celestini.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Initial Visit
 */
public interface NewvisitModel extends BaseModel {

    /**
     * Hospital Address
     * Can be {@code null}.
     */
    @Nullable
    String getHospitalAddress();

    /**
     * Hospital Name
     * Can be {@code null}.
     */
    @Nullable
    String getHospitalName();

    /**
     * Get the {@code visit_no} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVisitNo();

    /**
     * Get the {@code patient_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPatientName();

    /**
     * Home District
     * Can be {@code null}.
     */
    @Nullable
    String getHomeDistrict();

    /**
     * Date of birth
     * Can be {@code null}.
     */
    @Nullable
    Date getDob();

    /**
     * Get the {@code education_level} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEducationLevel();

    /**
     * Tribe
     * Can be {@code null}.
     */
    @Nullable
    String getTribe();

    /**
     * Religion
     * Can be {@code null}.
     */
    @Nullable
    String getReligion();

    /**
     * Get the {@code occupation} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOccupation();

    /**
     * Town
     * Can be {@code null}.
     */
    @Nullable
    String getTown();

    /**
     * Blood Pressure
     * Can be {@code null}.
     */
    @Nullable
    String getBloodpressure();

    /**
     * Get the {@code parity_no_of_pregnancies} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getParityNoOfPregnancies();

    /**
     * Pregnancy_Outcome
     * Can be {@code null}.
     */
    @Nullable
    String getPregnancyOutcome();

    /**
     * History of hypertension in past pregnancies
     * Can be {@code null}.
     */
    @Nullable
    String getPastPregnancyHypertensionHistory();

    /**
     * Get the {@code last_normal_mp_date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLastNormalMpDate();

    /**
     * Previous C-section
     * Can be {@code null}.
     */
    @Nullable
    String getPreviousCaesarean();

    /**
     * Hypertension before pregnancy
     * Can be {@code null}.
     */
    @Nullable
    String getHypertensionBeforePregnancy();

    /**
     * Get the {@code diabetic_before_pregnancy} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDiabeticBeforePregnancy();

    /**
     * Chronic renal disease
     * Can be {@code null}.
     */
    @Nullable
    String getChronicRenalDisease();

    /**
     * Thyroid disease
     * Can be {@code null}.
     */
    @Nullable
    String getThyroidDisease();

    /**
     * Get the {@code sickle_cells} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSickleCells();

    /**
     * Any other chronic problem
     * Can be {@code null}.
     */
    @Nullable
    String getOtherChronicProblem();

    /**
     * Do you have headache
     * Can be {@code null}.
     */
    @Nullable
    String getHeadacheSymptome();

    /**
     * Get the {@code epigastric_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEpigastricPain();

    /**
     * Fever
     * Can be {@code null}.
     */
    @Nullable
    String getFever();

    /**
     * Nausea and vomiting
     * Can be {@code null}.
     */
    @Nullable
    String getNauseaAndVomiting();

    /**
     * Get the {@code visual_disturbance} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVisualDisturbance();

    /**
     * Chest pain
     * Can be {@code null}.
     */
    @Nullable
    String getChestPain();

    /**
     * Difficulty in breathing
     * Can be {@code null}.
     */
    @Nullable
    String getDifficultyInBreathing();

    /**
     * Vaginal bleeding
     * Can be {@code null}.
     */
    @Nullable
    String getVaginalBleeding();

    /**
     * Hypertension drugs
     * Can be {@code null}.
     */
    @Nullable
    String getHypertensionDrugs();

    /**
     * Diabetes drugs
     * Can be {@code null}.
     */
    @Nullable
    String getDiabetesDrugs();

    /**
     * Iron tablets
     * Can be {@code null}.
     */
    @Nullable
    String getIronTablets();

    /**
     * Folic acid tablets
     * Can be {@code null}.
     */
    @Nullable
    String getFolicAcidTablets();

    /**
     * Any other drugs
     * Can be {@code null}.
     */
    @Nullable
    String getOtherDrugs();

    /**
     * Hypertension while on contraceptives
     * Can be {@code null}.
     */
    @Nullable
    String getHypertensionHistoryCocs();

    /**
     * History of preeclampsia in the family
     * Can be {@code null}.
     */
    @Nullable
    String getPreeclampsiaFamilyHistory();

    /**
     * Any treatment for infertility in the past
     * Can be {@code null}.
     */
    @Nullable
    String getInfertilityTreatmentHistory();

    /**
     * Multiple gestation
     * Can be {@code null}.
     */
    @Nullable
    String getMultipleGestation();
}
