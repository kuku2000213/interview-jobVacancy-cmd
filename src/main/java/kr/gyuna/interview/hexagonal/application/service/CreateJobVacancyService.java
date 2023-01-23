package kr.gyuna.interview.hexagonal.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.CreateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.CreateJobVacancyPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindUserPort;
import kr.gyuna.interview.hexagonal.application.port.out.PublishJobVacancyEventPort;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Transactional
@RequiredArgsConstructor
@Service
public class CreateJobVacancyService implements CreateJobVacancyUseCase {

    private final CreateJobVacancyPort createJobVacancyPort;
    private final FindUserPort findUserPort;
    private final PublishJobVacancyEventPort publishJobVacancyEventPort;

    @Override
    public DefaultResponse createJobVacancy(CreateJobVacancyCommand command) throws JsonProcessingException {

//        findUserPort.findUserById(command.getUserId());
        findUserPort.findValidatedUserById(command.getUserId());

        JobVacancy jobVacancy = command.toEntity();

        JobVacancyId jobVacancyId =
                createJobVacancyPort.createJobVacancy(jobVacancy);

        publishJobVacancyEventPort.newJobVacancyCreated(jobVacancy);

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "채용공고가 정상적으로 등록되었습니다.",
                jobVacancyId.toString()
        );
    }
}
