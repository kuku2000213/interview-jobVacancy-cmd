package kr.gyuna.interview.hexagonal.adapter.in.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.gyuna.interview.hexagonal.adapter.in.event.data.NewUserEvent;
import kr.gyuna.interview.hexagonal.application.port.in.CreateUserCommand;
import kr.gyuna.interview.hexagonal.application.port.in.CreateUserUseCase;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserId;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserState;
import kr.gyuna.interview.hexagonal.domain.reference.user.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import static kr.gyuna.interview.common.Statics.OBJECT_MAPPER;

@RequiredArgsConstructor
@Slf4j
@Component
public class UserEventConsumer {

    private final CreateUserUseCase createUserUseCase;


    @KafkaListener(topics = "${kafka.topics.user-status}", groupId = "${kafka.consumer.group-id}")
    void listen(String message) throws JsonProcessingException {

        log.info("Consumer.listen: " + message);

        NewUserEvent event = OBJECT_MAPPER.readValue(message, NewUserEvent.class);

        CreateUserCommand command = CreateUserCommand.builder()
                .userId(UserId.of(event.getUserId()))
                .userState(UserState.valueOf(event.getUserState()))
                .userType(UserType.valueOf(event.getUserType()))
                .build();

        createUserUseCase.createUser(command);
    }
}
