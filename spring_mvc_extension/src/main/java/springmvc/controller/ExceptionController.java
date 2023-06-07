package springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//将当前类表示为异常处理组件
@ControllerAdvice
public class ExceptionController {

    //设置需要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex,Model model){
        //ex表示当前请求处理中出现的异常对象
        model.addAttribute("ex",ex);
        return "error";
    }
}
