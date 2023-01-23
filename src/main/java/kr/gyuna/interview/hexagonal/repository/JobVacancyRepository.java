package kr.gyuna.interview.hexagonal.repository;

import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import org.springframework.data.repository.CrudRepository;

public interface JobVacancyRepository extends CrudRepository<JobVacancy, JobVacancyId> {
}
