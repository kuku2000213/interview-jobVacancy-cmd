package kr.gyuna.interview.hexagonal.adapter.in.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.request.CreateJobVacancyReq;
import kr.gyuna.interview.hexagonal.application.port.in.CreateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateJobVacancyController {

    private final CreateJobVacancyUseCase createJobVacancyUseCase;

    @PostMapping("/v1/job-vacancies")
    public ResponseEntity<DefaultResponse> createJobVacancy(
            @RequestBody CreateJobVacancyReq req
    ) throws JsonProcessingException {
        CreateJobVacancyCommand command = CreateJobVacancyCommand
                .builder()
                .userId(UserId.of(req.getUserId()))
                .jobVacancyTitle(req.getTitle())
                .jobVacancyContent(req.getContent())
                .build();

        DefaultResponse response = createJobVacancyUseCase
                .createJobVacancy(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
