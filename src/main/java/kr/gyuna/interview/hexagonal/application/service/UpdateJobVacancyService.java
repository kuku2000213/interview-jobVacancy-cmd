package kr.gyuna.interview.hexagonal.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.FindJobVacancyPort;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UpdateJobVacancyService implements UpdateJobVacancyUseCase {

    private final FindJobVacancyPort findJobVacancyPort;

    @Override
    public DefaultResponse updateJobVacancy(UpdateJobVacancyCommand command) {

        JobVacancy jobVacancy =
                findJobVacancyPort.findJobVacancyById(command.getJobVacancyId());

        jobVacancy.updateJobVacancyDetail(command.toJobVacancyDetail());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "채용공고가 정상적으로 변경되었습니다.",
                command.getJobVacancyId().toString()
        );
    }
}
