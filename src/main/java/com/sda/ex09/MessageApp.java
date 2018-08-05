package com.sda.ex09;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@EnableAutoConfiguration
public class MessageApp {

    private static List<Message> msg = new ArrayList<>();

    public static void main(String[] args) {
        msg.add(new Message(1, "message1"));
        msg.add(new Message(2, "message2"));
        SpringApplication.run(MessageApp.class, args);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public List<Message> getAll() {
        return msg;
    }

    @RequestMapping(value = "message/{id}", method = RequestMethod.GET)
    public Message get(@PathVariable("id") Integer id){
        return msg.get(id);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public void save(@RequestBody Message message){
        msg.add(message);
    }

    @RequestMapping(value = "/message", method = RequestMethod.DELETE)
    public void deleteAll(){
        msg.clear();
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
        msg.remove(msg.get(id));
    }
}

