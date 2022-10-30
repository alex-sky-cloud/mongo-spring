package com.spring.mongo.web.rest.auth;

import com.spring.mongo.service.create.capthca.ReCaptchaApiClientService;
import com.spring.mongo.service.dto.recaptcha.ReCaptchaResponseDto;
import com.spring.mongo.service.dto.recaptcha.RegisterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthJRestController {

    private static final Logger LOGGER  = LoggerFactory.getLogger( AuthJRestController.class );

    private ReCaptchaApiClientService reCaptchaApiClient;

    @Autowired
    public AuthJRestController(ReCaptchaApiClientService reCaptchaApiClient) {
        this.reCaptchaApiClient = reCaptchaApiClient;
    }

    /** @ResponseStatus(HttpStatus.CREATED)
     * Она позволяет устанавливать код ответа.
     * Обычно Spring сам устанавливает нужный код ответа,
     * но бывают моменты, когда это нужно переопределить.
     * @param registerDto
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("api/register")
    public void register(RegisterDto registerDto) {

        LOGGER.info("{}", registerDto);

        ReCaptchaResponseDto responseDto = reCaptchaApiClient.verify(registerDto.getRecaptchaResponse());

        LOGGER.info("{}", responseDto);

        if (!responseDto.isSuccess()) {
            throw new RuntimeException();
        }
    }


    /**
     * @ExceptionHandler(RuntimeException.class) - данная аннотация, указывает для Spring,
     * что нужно зарегистрировать метод, как метод-перехватчик, для исключений типа RuntimeException
     * и данный метод, в случае перехвата данного исключения, формирует специальный ответ клиенту,
     * и автоматически отправляет его на клиентскую сторону.
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
