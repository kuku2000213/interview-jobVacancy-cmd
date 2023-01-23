package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.JobVacancyId;

public interface DeleteJobVacancyPort {

    void deleteJobVacancyById(JobVacancyId jobVacancyId);
}
