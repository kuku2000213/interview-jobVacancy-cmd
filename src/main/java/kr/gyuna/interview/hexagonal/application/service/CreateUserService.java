package kr.gyuna.interview.hexagonal.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.hexagonal.application.port.in.CreateUserCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateUserUseCase;
import kr.gyuna.interview.hexagonal.application.port.out.CreateUserPort;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;


    @Override
    public DefaultResponse createUser(CreateUserCommand command) {

        UserId userId = createUserPort.createUser(command.toEntity());

        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "회원이 정상적으로 등록되었습니다.",
                userId
        );
    }
}
