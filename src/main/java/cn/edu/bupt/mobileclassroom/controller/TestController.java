package cn.edu.bupt.mobileclassroom.controller;

import cn.edu.bupt.mobileclassroom.util.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public HttpResponse testApi() {
        return new HttpResponse("Hello!");
    }
}
