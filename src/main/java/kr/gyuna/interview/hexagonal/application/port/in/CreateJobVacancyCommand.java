package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyDate;
import kr.gyuna.interview.hexagonal.domain.JobVacancyDetail;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobVacancyCommand {

    private UserId userId;
    private String jobVacancyTitle;
    private String jobVacancyContent;

    public JobVacancy toEntity(){
        JobVacancyDetail jobVacancyDetail = JobVacancyDetail.builder()
                .jobVacancyTitle(this.jobVacancyTitle)
                .jobVacancyContent(this.jobVacancyContent)
                .build();

        Date today = new Date();

        JobVacancyDate jobVacancyDate = JobVacancyDate.builder()
                .jobVacancyCreatedDate(today)
                .jobVacancyModifiedDate(today)
                .build();

        return JobVacancy.builder()
                .jobVacancyId(JobVacancyId.uuid())
                .userId(this.userId)
                .jobVacancyDetail(jobVacancyDetail)
                .jobVacancyDate(jobVacancyDate)
                .build();
    }

    public UserId getUserId(){
        return this.userId;
    }
}
