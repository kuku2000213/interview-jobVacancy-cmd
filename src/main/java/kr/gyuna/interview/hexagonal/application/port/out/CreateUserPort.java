package kr.gyuna.interview.hexagonal.application.port.out;

import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;

public interface CreateUserPort {
    UserId createUser(User user);
}
