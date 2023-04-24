package br.com.saga.orchestration.controller.exception.handler;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    private final WebRequest webRequest;

    public GlobalExceptionHandler(MessageSource messageSource, WebRequest webRequest) {
        this.messageSource = messageSource;
        this.webRequest = webRequest;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        Map<String, Object> httpResponseStatus = new JSONObject(e.contentUTF8()).toMap();
        response.setStatus(response.getStatus());
        return httpResponseStatus;
    }
}