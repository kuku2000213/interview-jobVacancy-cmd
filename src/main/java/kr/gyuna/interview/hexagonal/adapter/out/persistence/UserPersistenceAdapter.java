package kr.gyuna.interview.hexagonal.adapter.out.persistence;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.application.port.out.CreateUserPort;
import kr.gyuna.interview.hexagonal.application.port.out.FindUserPort;
import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import kr.gyuna.interview.hexagonal.repository.UserDSL;
import kr.gyuna.interview.hexagonal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements FindUserPort, CreateUserPort {

    private final UserRepository userRepository;
    private final UserDSL userDSL;

    @Override
    public User findUserById(UserId userId) {

        Optional<User> userOpt =
                userRepository.findById(userId);

        return userOpt.orElseThrow(() ->
                new NullPointerException("해당 회원이 존재하지 않습니다.")
        );
    }

    @Override
    public User findValidatedUserById(UserId userId) {
        Optional<User> userOpt =
                userDSL.findValidateUserById(userId);
        return userOpt.orElseThrow(() ->
                new NullPointerException("해당 회원이 존재하지 않거나, 탈퇴 혹은 기업회원이 아닙니다.")
        );
    }

    @Override
    public UserId createUser(User user) {

        User createdUser = userRepository.save(user);

        return createdUser.getUserId();
    }
}
