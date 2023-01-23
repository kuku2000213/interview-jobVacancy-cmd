package kr.gyuna.interview.hexagonal.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class JobVacancyDetail {

    private String jobVacancyTitle;
    private String jobVacancyContent;
}
