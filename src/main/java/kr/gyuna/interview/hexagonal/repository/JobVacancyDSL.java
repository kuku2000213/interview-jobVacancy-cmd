package kr.gyuna.interview.hexagonal.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class JobVacancyDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public JobVacancyDSL(
            EntityManager entityManager
    ){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
