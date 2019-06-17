package com.possiblefinance.iv.IV_Exercise_1;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Component
public class UserSessionLookup {
    UserSession createOrLookupSession(HttpSession session) {
        String id = (String)session.getAttribute("id");
        if ( id == null) {
            id = UUID.randomUUID().toString();
            session.setAttribute("id", id);
            return new UserSession();
        }

        //ToDo look up session
        return new UserSession();
    }
}
