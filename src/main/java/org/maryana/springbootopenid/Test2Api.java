package org.maryana.springbootopenid;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@Controller
public class Test2Api {

    @GetMapping("/oauth")
    public String test2(Model model) {

        Object details = ((UsernamePasswordAuthenticationToken)((OAuth2Authentication)((SecurityContextImpl)SecurityContextHolder.getContext()).getAuthentication()).getUserAuthentication()).getDetails();
        String name = ((LinkedHashMap) details).get("name").toString();
        String picture = ((LinkedHashMap) details).get("picture").toString();
        String mail = ((LinkedHashMap) details).get("email").toString();

        model.addAttribute("name", name);
        model.addAttribute("picture", picture);
        model.addAttribute("email", mail);

        return "gui";
    }
}
