package kr.gyuna.interview.hexagonal.domain.reference.user;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @EmbeddedId
    private UserId userId;

    @Enumerated(value = EnumType.STRING)
    private UserState userState;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    public UserId getUserId() {
        return this.userId;
    }
}
