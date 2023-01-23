package kr.gyuna.interview.hexagonal.adapter.out.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.gyuna.interview.hexagonal.adapter.out.event.data.JobVacancyStatusEvent;
import kr.gyuna.interview.hexagonal.application.port.out.PublishJobVacancyEventPort;
import kr.gyuna.interview.hexagonal.domain.JobVacancy;
import kr.gyuna.interview.hexagonal.adapter.out.event.data.JobVacancyStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobVacancyEventProducer implements PublishJobVacancyEventPort {

    @Value("${kafka.topics.jobVacancy-status}")
    private String topic;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void newJobVacancyCreated(JobVacancy jobVacancy) throws JsonProcessingException {
        JobVacancyStatusEvent event = JobVacancyStatusEvent.builder()
                .jobVacancyId(jobVacancy.getJobVacancyId().toString())
//                .userId(jobVacancy.getUserId().toString())
                .jobVacancyState(JobVacancyStatus.CREATED)
                .build();

        String message = objectMapper.writeValueAsString(event);

        kafkaTemplate.send(this.topic, message);
    }

    @Override
    public void jobVacancyDeleted(JobVacancy jobVacancy) throws JsonProcessingException {
        JobVacancyStatusEvent event = JobVacancyStatusEvent.builder()
                .jobVacancyId(jobVacancy.getJobVacancyId().toString())
//                .userId(jobVacancy.getUserId().toString())
                .jobVacancyState(JobVacancyStatus.DELETED)
                .build();

        String message = objectMapper.writeValueAsString(event);

        kafkaTemplate.send(this.topic, message);
    }
}
