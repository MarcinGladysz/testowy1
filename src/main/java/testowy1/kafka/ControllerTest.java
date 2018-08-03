package testowy1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import testowy1.cqrs.Command;
import testowy1.cqrs.CommandProcessor;
import testowy1.cqrs.TestowaCommand;
import testowy1.cqrs.UpdateCommand;
import testowy1.cqrs.query.QueryProcessor;
import testowy1.cqrs.query.views.TransactionView;

import java.util.List;

@RestController
public class ControllerTest {
    @Autowired
    CommandProcessor processor;

    @Autowired
    QueryProcessor queryProcessor;

    @GetMapping("/test")
    public ResponseEntity getTest(){
        System.out.println("jest tu w rest");
        TestowaCommand command = new TestowaCommand(" testowa command");
        processor.process(command);
        Command commandUpdate = new UpdateCommand(" update command");
        processor.process(commandUpdate);

        processor.process("{\"type\":\"TestowaCommand\",\"name\":\"TestowaCommand\"}");
        return ResponseEntity.ok(" poszlo");
    }

    @RequestMapping(value = "/alltransactions" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionView>> getTransactions() {
        List<TransactionView> toReturn;
        toReturn = queryProcessor.testTransactionProcess();
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }


}
