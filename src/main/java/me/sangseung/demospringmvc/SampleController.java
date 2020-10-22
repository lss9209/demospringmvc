package me.sangseung.demospringmvc;

import me.sangseung.demospringmvc.exception.AppError;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/hello2")
    public String hello(Model model) {
        model.addAttribute("name","sangseung");
        return "hello2";
    }

    @GetMapping("/error")
    public String error() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("I don know");
        return appError;
    }

}
