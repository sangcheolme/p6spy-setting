package study.community.common.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import study.community.common.ResponseApi;

@RestControllerAdvice
public class ExceptionAdvisor {

    @ExceptionHandler
    public ResponseApi<Void> argumentException(IllegalArgumentException e) {
        return new ResponseApi<>(false, e.getMessage(), null);
    }
}
