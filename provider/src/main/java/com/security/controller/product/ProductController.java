package com.security.controller.product;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/info")
    @ResponseBody
    public String productInfo()
    {
        String currentUser;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof User){
            currentUser = ((User)principal).getUsername();
        }else{
            currentUser = principal.toString();
        }
        return String.format("%s product info",currentUser);
    }
}
