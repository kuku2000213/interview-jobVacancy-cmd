package kr.gyuna.interview.hexagonal.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.DeleteJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.PublishJobVacancyEventPort;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class DeleteJobVacancyService implements DeleteJobVacancyUseCase {

    private final FindJobVacancyPort findJobVacancyPort;
    private final DeleteJobVacancyPort deleteJobVacancyPort;
    private final PublishJobVacancyEventPort publishJobVacancyEventPort;

    @Override
    public DefaultResponse deleteJobVacancyById(DeleteJobVacancyCommand command) throws JsonProcessingException {

        JobVacancyId jobVacancyId = command.toJobVacancyId();

        JobVacancy jobVacancy = findJobVacancyPort.findJobVacancyById(jobVacancyId);
        publishJobVacancyEventPort.jobVacancyDeleted(jobVacancy);

        deleteJobVacancyPort.deleteJobVacancyById(jobVacancyId);

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "채용공고가 정상적으로 삭제되었습니다.",
                command.toJobVacancyId().toString()
        );
    }
}
