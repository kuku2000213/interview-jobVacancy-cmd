package kr.gyuna.interview.hexagonal.adapter.in.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.DeleteJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteJobVacancyController {

    private final DeleteJobVacancyUseCase deleteJobVacancyUseCase;

    @DeleteMapping("/v1/job-vacancies/{jobVacancyId}")
    public ResponseEntity<DefaultResponse> deleteJobVacancy(
            @PathVariable("jobVacancyId") String jobVacancyId
    ) throws JsonProcessingException {
        DeleteJobVacancyCommand command = DeleteJobVacancyCommand.builder()
                .jobVacancyId(JobVacancyId.of(jobVacancyId))
                .build();

        DefaultResponse response =
                deleteJobVacancyUseCase.deleteJobVacancyById(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
