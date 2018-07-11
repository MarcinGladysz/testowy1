package testowy1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import testowy1.cqrs.CommandProcessor;
import testowy1.cqrs.TestowaCommand;

@RestController
public class ControllerTest {
    @Autowired
    CommandProcessor processor;

    @GetMapping("/test")
    public ResponseEntity getTest(){
        System.out.println("jest tu w rest");
        TestowaCommand command = new TestowaCommand(" testowa command");
        processor.process(command);

        return ResponseEntity.ok(" poszlo");
    }


}
