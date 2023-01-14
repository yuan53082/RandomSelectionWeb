package com.yuan.RandomSelection.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yuan.RandomSelection.service.RandomService;

@RestController
@RequestMapping("/")
public class RandomSelection {

    @Autowired
    private RandomService randomsService;

    @PostMapping("/random")
    public String Random(@RequestBody String input) throws UnsupportedEncodingException {// 前端傳回的資料為JSON格式，要用RequestBody接收
        /*
         * input的格式顯示是經過URL編碼的，因為在ajax中使用了
         * contentType:"application/x-www-form-urlencoded; charset=UTF-8"
         * 這個contentType會將資料以類似key-value的方式經過URL編碼後傳到後端。
         * 如果想要接收到原本的資料格式，可以在後端使用java.net.URLDecoder.decode()將資料解碼回原本的格式。
         */
        input = URLDecoder.decode(input, "UTF-8");
        String data = randomsService.random(input.split("\n"));
        return data;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView Error404(NoHandlerFoundException ex) {
        ModelAndView mav = new ModelAndView("404");
        mav.addObject("errorMessage", "The page you are looking for is not found");
        return mav;
    }

    /**
     * @GetMapping("/test")
     * public String test(Model model) {
     * // ModelAndView test = new ModelAndView("test");
     * // test.addObject("test", "測試");
     * // return test;
     * model.addAttribute("test", "test");
     * return "test";
     * }
     */
}
