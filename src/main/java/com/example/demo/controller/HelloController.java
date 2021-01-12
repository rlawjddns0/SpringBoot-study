package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @GetMapping("hello") //http의 그 get 방식
    public String hello(Model model){
        model.addAttribute("data", "spring");
        return "hello";//템플릿에 hello.html를 찾아가라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//http에서 바디부분에 데이터를 직접 넣어주겠다의 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;//
    }


    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();//객체생성
        hello.setName(name);
        return hello;
    }
    static class Hello {//겟터 셋터
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }






}
