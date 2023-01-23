package kr.gyuna.interview.common.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultResponse {

    private int statusCode;
    private String responseMessage;
    private Object data;

    public DefaultResponse(
            final int statusCode,
            final String responseMessage,
            final Object data
    ){
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = data;
    }

    public static DefaultResponse res(
            final int statusCode,
            final String responseMessage,
            final Object data
    ){
        return DefaultResponse.builder()
                .data(data)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}

