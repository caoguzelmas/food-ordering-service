package com.caoguzelmas.foodorderingservice.orderservice.application.exception.handler;

import com.caoguzelmas.foodorderingservice.common.domain.ErrorDTO;
import com.caoguzelmas.foodorderingservice.common.domain.GlobalExceptionHandler;
import com.caoguzelmas.foodorderingservice.orderservice.domain.exception.OrderDomainException;
import com.caoguzelmas.foodorderingservice.orderservice.domain.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {OrderDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handlerException(OrderDomainException orderDomainException) {
        log.error(orderDomainException.getMessage(), orderDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(orderDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {OrderDomainException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handlerException(OrderNotFoundException orderNotFoundException) {
        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(orderNotFoundException.getMessage())
                .build();
    }
}
