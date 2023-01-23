package kr.gyuna.interview.hexagonal.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserState;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.gyuna.interview.hexagonal.domain.reference.user.QUser.user;

@Transactional
@Repository
public class UserDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public UserDSL(
        EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public Optional<User> findValidateUserById(UserId userId) {
        return Optional.ofNullable(jpaQueryFactory
                .selectFrom(user)
                .where(user.userId.eq(userId)
                        .and(user.userState.eq(UserState.ACTIVATED))
                        .and(user.userType.eq(UserType.ENTERPRISE))
                )
                .fetchOne()
        );
    }
}
