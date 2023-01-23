package kr.gyuna.interview.hexagonal.adapter.in.event.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserEvent {

    private String userId;
    private String userType;
    private String userState;

}
