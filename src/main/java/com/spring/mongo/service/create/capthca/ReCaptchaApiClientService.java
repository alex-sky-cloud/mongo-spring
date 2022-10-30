package com.spring.mongo.service.create.capthca;

import com.spring.mongo.service.dto.recaptcha.ReCaptchaResponseDto;
import org.springframework.lang.NonNull;

public interface ReCaptchaApiClientService {

    /**
     * проверка вводимых символов. Для этого происходит отправка запроса, ъ
     * на сервис Google ReCaptcha
     * @param recaptchaResponse проверяемые символы
     * @return
     */
    ReCaptchaResponseDto verify(@NonNull String recaptchaResponse);
}
