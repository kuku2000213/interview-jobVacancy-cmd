package kr.gyuna.interview.hexagonal.application.port.in;


import kr.gyuna.interview.hexagonal.domain.reference.user.User;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserState;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {

    private UserId userId;
    private UserState userState;
    private UserType userType;

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .userState(this.userState)
                .userType(this.userType)
                .build();
    }
}
