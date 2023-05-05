package com.insigma.datasearch.config;


import com.insigma.datasearch.request.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 校验提示的全局处理类
 */
@ControllerAdvice
public class ValidatedControllerAdvice {

    /**
     * 捕获校验不通过的异常，并返回友好提示信息
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String defaultMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();

        return R.fail(400,defaultMessage,null);
    }
}

