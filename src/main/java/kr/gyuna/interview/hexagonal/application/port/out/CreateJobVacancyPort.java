package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;

public interface CreateJobVacancyPort {

    JobVacancyId createJobVacancy(JobVacancy jobVacancy);
}
