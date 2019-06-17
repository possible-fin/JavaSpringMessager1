package com.possiblefinance.iv.IV_Exercise_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class JsonController {

    @Autowired
    UserSessionLookup userSessionLookup;

    String name = "World";

    @GetMapping("/greeting_json")
    public Hello greetingJson(@RequestParam(name="name", required=false) String name, HttpSession session) {

        UserSession userSession = userSessionLookup.createOrLookupSession(session);

        if ( name != null ) {
            this.name = name;
        }
        return greetingResponse();
    }

    @PostMapping("/greeting_json")
    public Hello greetingJson(@RequestBody Hello hello, HttpSession session) {
        if ( hello != null && hello.name != null ) {
            this.name = name;
        }
        return greetingResponse();
    }

    Hello greetingResponse () {
        Hello response = new Hello();
        response.setName(this.name);
        return response;
    }
}
