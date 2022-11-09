package ecse428.peaceOfMinde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {



    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mav=new ModelAndView("index");
        return mav;
    }

}