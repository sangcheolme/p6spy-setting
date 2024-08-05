package study.community.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseApi<T> {

    private boolean isSuccess;
    private String message;
    private T data;

    public ResponseApi(boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }
}
