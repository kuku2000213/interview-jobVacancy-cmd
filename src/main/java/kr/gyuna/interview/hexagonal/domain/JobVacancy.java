package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class JobVacancy {

    @EmbeddedId
    private JobVacancyId jobVacancyId;

    @Embedded
    private UserId userId;

//    @Embedded
//    private IntroductionId introductionId;

    @Embedded
    private JobVacancyDetail jobVacancyDetail;

    @Embedded
    private JobVacancyDate jobVacancyDate;

    public void updateJobVacancyDetail(JobVacancyDetail jobVacancyDetail){
        this.jobVacancyDate.recordNowToModifiedDate();
        this.jobVacancyDetail = jobVacancyDetail;
    }
}
