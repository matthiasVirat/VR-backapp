package com.vehiculerental.backapp.boHome;

import com.vehiculerental.backapp.boClient.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class BOHomeController {

    @ApiOperation(value = "Shows the homepage")
    @GetMapping(value = "/")
    public String getHomePage( ) {
        return "home";
    }


}
