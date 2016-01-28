package johnkagga.me.celestini.provider.subvisit;

import johnkagga.me.celestini.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Initial Visit
 */
public interface SubvisitModel extends BaseModel {

    /**
     * Patient Id
     * Can be {@code null}.
     */
    @Nullable
    String getPatientId();

    /**
     * Chronic problem
     * Can be {@code null}.
     */
    @Nullable
    String getAnyOtherChronicMedicalProblem();

    /**
     * Get the {@code head_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHeadPain();

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
    String getNauseaVomiting();

    /**
     * Get the {@code visual_disturbances} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVisualDisturbances();

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
     * Get the {@code vaginal_bleeding_with_abdominal_pain} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVaginalBleedingWithAbdominalPain();

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
     * Get the {@code iron_tablets} value.
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
    String getAnyOtherSpecify();

    /**
     * Get the {@code any_multiple_gestation} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAnyMultipleGestation();
}
