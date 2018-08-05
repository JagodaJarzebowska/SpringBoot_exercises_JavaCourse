package com.sda.springbootEx01toEx08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

@RestController
@EnableAutoConfiguration
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);

    }

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/currentTime")
    public String time() {
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.toString();
    }

    @RequestMapping("/currentDay")
    public String date() {
        LocalDate ld = LocalDate.now();
        return ld.toString();
    }

    //http://localhost:12345/sum?one=2&two=5
    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public String sum(@RequestParam("one") Integer one, @RequestParam("two") Integer two) throws SumError {
        if (one == null || two == null) {
            throw new SumError("!!!!!Error!!!!!");
        } else {
            Integer result = one + two;
            return result.toString();
        }
    }

    //http://localhost:12345/randomnumber/2/50
    @RequestMapping(path = "/randomnumber/{one}/{two}", method = RequestMethod.GET)
    public String randomNumber(@PathVariable("one") Integer one, @PathVariable("two") Integer two) {
        Random random = new Random();
        Integer reslt = random.nextInt(two - one) + one;
        return reslt.toString();
    }


    //http://localhost:12345/time/London
    @RequestMapping(path = "/time/{city}", method = RequestMethod.GET)
    public String dateandTime(@PathVariable("city") String city){
        String time = LocalDateTime.now(ZoneId.of("Europe/"+city)).toString();
        return time;
    }


}

