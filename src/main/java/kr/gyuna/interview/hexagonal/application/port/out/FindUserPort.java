package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;

public interface FindUserPort {
    User findUserById(UserId userId);
    User findValidatedUserById(UserId userId);
}
