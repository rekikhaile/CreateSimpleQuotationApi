package com.rekik.quotationapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    @RequestMapping("/")
    public @ResponseBody String showindex(){
        RestTemplate restTemplate = new RestTemplate();

        Quote quote =restTemplate.getForObject
                ("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        return quote.getValue().getQuote();
    }


    @RequestMapping("/horoscope")
    public @ResponseBody String showHoroscope(){
        RestTemplate restTemplate = new RestTemplate();

        Horoscope horoscope =restTemplate.getForObject
                ("http://horoscope-api.herokuapp.com/horoscope/today/Libra", Horoscope.class);

        return horoscope.getSunsign();
    }
}
