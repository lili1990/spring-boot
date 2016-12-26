package com.lili.controller;

import com.lili.exception.MyException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lili19289 on 2016/12/23.
 */



@RestController
public class HelloController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("host","http://lili1990.github.io");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value="/testException",method = RequestMethod.POST)
    public String testException(String test) throws Exception{
        throw new Exception("异常统一处理");
    }

    @RequestMapping(value="/jsonException",method = RequestMethod.GET)
    public String json() throws MyException {
        throw new MyException("异常统一处理");
    }

}
