package kr.gyuna.interview.hexagonal.repository;

import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UserId> {
}
