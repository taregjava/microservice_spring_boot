package com.halfacode.apigetway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/departmentFallBack")
    public Mono<String> departMentServiceFallBack(){
        return Mono.just("departmentService is takingtoo long time to response . please try again latter");
    }
    @RequestMapping("/userFallBack")
    public Mono<String> userFallBackServiceFallBack(){
        return Mono.just("userFallBackService is takingtoo long time to response . please try again latter");
    }
}
