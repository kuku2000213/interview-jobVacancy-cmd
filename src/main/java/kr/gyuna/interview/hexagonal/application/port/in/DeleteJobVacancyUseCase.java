package kr.gyuna.interview.hexagonal.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.common.response.DefaultResponse;

public interface DeleteJobVacancyUseCase {

    DefaultResponse deleteJobVacancyById(DeleteJobVacancyCommand command) throws JsonProcessingException;
}
