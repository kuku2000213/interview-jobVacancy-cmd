package kr.gyuna.interview.hexagonal.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.adapter.in.rest.request.UpdateJobVacancyDetailReq;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateJobVacancyCommand;
import kr.gyuna.interview.hexagonal.application.port.in.UpdateJobVacancyUseCase;
import kr.gyuna.interview.hexagonal.domain.JobVacancyId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UpdateJobVacancyController {

    private final UpdateJobVacancyUseCase updateJobVacancyUseCase;

    @PutMapping("/v1/job-vacancies/{jobVacancyId}")
    public ResponseEntity<DefaultResponse> updateJobVacancyDetail(
            @PathVariable(name = "jobVacancyId") String jobVacancyId,
            @RequestBody UpdateJobVacancyDetailReq req
    ) {
        UpdateJobVacancyCommand command = UpdateJobVacancyCommand
                .builder()
                .jobVacancyId(JobVacancyId.of(jobVacancyId))
                .jobVacancyTitle(req.getTitle())
                .jobVacancyContent(req.getContent())
                .build();

        DefaultResponse response =
                updateJobVacancyUseCase.updateJobVacancy(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

}
