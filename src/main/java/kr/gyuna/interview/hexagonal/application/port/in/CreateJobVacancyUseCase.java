package kr.gyuna.interview.hexagonal.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;

public interface CreateJobVacancyUseCase {

    DefaultResponse createJobVacancy(CreateJobVacancyCommand command) throws JsonProcessingException;
}
