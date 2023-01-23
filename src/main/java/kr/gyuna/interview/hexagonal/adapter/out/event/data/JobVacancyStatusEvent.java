package kr.gyuna.interview.hexagonal.adapter.out.event.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JobVacancyStatusEvent {

    private String jobVacancyId;
//    private String userId;
    private JobVacancyStatus jobVacancyState;
}
