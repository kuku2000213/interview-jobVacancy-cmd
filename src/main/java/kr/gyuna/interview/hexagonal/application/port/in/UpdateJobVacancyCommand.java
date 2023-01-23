package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.JobVacancyDetail;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateJobVacancyCommand {
    private JobVacancyId jobVacancyId;
    private String jobVacancyTitle;
    private String jobVacancyContent;

    public JobVacancyId getJobVacancyId(){
        return this.jobVacancyId;
    }

    public JobVacancyDetail toJobVacancyDetail(){
        return JobVacancyDetail.builder()
                .jobVacancyTitle(this.jobVacancyTitle)
                .jobVacancyContent(this.jobVacancyContent)
                .build();
    }
}
