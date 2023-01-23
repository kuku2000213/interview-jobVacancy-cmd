package kr.gyuna.interview.hexagonal.adapter.out.persistence;


import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.CreateJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.DeleteJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindJobVacancyPort;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import kr.gyuna.interview.hexagonal.repository.JobVacancyDSL;
import kr.gyuna.interview.hexagonal.repository.JobVacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Transactional
public class JobVacancyPersistenceAdapter implements
        CreateJobVacancyPort,
        FindJobVacancyPort,
        DeleteJobVacancyPort
{

    private final JobVacancyRepository jobVacancyRepository;
    private final JobVacancyDSL jobVacancyDSL;

    @Override
    public JobVacancyId createJobVacancy(JobVacancy jobVacancy) {

        JobVacancy createdJobVacancy =
                jobVacancyRepository.save(jobVacancy);

        return createdJobVacancy.getJobVacancyId();
    }

    @Override
    public JobVacancy findJobVacancyById(JobVacancyId jobVacancyId) {

        Optional<JobVacancy> jobVacancyOpt =
                jobVacancyRepository.findById(jobVacancyId);

        return jobVacancyOpt.orElseThrow(() ->
                new NullPointerException("해당 채용공고가 존재하지 않습니다.")
        );
    }

    @Override
    public void deleteJobVacancyById(JobVacancyId jobVacancyId) {
        jobVacancyRepository.deleteById(jobVacancyId);
    }
}
