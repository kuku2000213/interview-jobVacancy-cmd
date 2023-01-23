package kr.gyuna.interview.hexagonal.adapter.in.rest.request;

import lombok.Getter;

@Getter
public class CreateJobVacancyReq {

    private String userId;
    private String title;
    private String content;
}
