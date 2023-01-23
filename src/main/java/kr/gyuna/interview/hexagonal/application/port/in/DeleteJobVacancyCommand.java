package kr.gyuna.interview.hexagonal.application.port.in;

import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteJobVacancyCommand {

    private JobVacancyId jobVacancyId;

    public JobVacancyId toJobVacancyId(){
        return this.jobVacancyId;
    }
}
