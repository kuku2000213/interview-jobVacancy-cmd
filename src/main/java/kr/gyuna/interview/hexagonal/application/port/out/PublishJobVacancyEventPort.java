package kr.gyuna.interview.hexagonal.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;

public interface PublishJobVacancyEventPort {
    void newJobVacancyCreated(JobVacancy jobVacancy) throws JsonProcessingException;

    void jobVacancyDeleted(JobVacancy jobVacancy) throws JsonProcessingException;
}
