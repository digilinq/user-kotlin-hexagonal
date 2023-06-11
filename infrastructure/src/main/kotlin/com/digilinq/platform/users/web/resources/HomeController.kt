package com.digilinq.platform.users.web.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @ResponseBody
    @GetMapping("/index")
    fun index(): String? {
        return "It's working!"
    }

}