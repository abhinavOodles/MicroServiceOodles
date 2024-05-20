package com.example.user.service.UserService.Controller;


import com.example.user.service.UserService.KafkaProducer.MessageProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducerConfig messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("my-topic", message);
        return "Message sent: " + message;
    }

    @PostMapping("/send1")
    public String send1Message (@RequestParam String message){
        messageProducer.sendMessage1("my-topic-1",message);
        return "Message sent: "+message ;
    }

}
