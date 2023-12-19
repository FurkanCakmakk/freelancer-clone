package com.kurtlar.konseyi.freelancerclone.library.exception;

import com.kurtlar.konseyi.freelancerclone.library.enums.MessageCodes;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public Response<MetaResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        return respond(MetaResponse.of(MessageCodes.ENTITY_NOT_FOUND.getCode(), ex.getMessage()));
    }

}
