package meinKontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class meineController {



@GetMapping("/hello")
    public String hello(){
    return "hello babe";






}

}
