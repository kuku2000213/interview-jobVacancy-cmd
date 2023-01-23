package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Embeddable
public class JobVacancyId implements Serializable {

    private String jobVacancyUuid;

    public JobVacancyId(String jobVacancyUuid) {
        if (jobVacancyUuid == null) {
            throw new IllegalArgumentException("jobVacancyUuid is null");
        }

        this.jobVacancyUuid = jobVacancyUuid;
    }


    @Override
    public int hashCode() {
        return Objects.hash(jobVacancyUuid);
    }

    public static JobVacancyId of(String jobVacancyUuid) {
        return new JobVacancyId(jobVacancyUuid);
    }

    public static JobVacancyId uuid(){
        return new JobVacancyId(UUID.randomUUID().toString());
    }

    public String toString(){
        return this.jobVacancyUuid;
    }
}
