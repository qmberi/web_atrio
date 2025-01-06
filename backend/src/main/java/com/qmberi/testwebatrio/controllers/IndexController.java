package com.qmberi.testwebatrio.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("index")
@CrossOrigin(origins = "*")
public class IndexController {

    public IndexController() {
    }

    @GetMapping("index/{id}")
    public String index(@PathVariable("id") Integer index){
        return "THIS IS AN INDEX " + index;
    }
}
