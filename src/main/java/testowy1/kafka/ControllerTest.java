package testowy1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testowy1.cqrs.commands.Command;
import testowy1.cqrs.commands.CommandProcessor;
import testowy1.cqrs.commands.TestowaCommand;
import testowy1.cqrs.commands.UpdateCommand;
import testowy1.cqrs.query.QueryProcessor;
import testowy1.cqrs.query.views.TransactionView;
import testowy1.exceptions.ResourceNotFoundException;
import testowy1.model.TransactionCategoryTags;

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
        TestowaCommand command = new TestowaCommand();
        command.setName("testowa command");
        processor.process(command);
        Command commandUpdate = new UpdateCommand();
        commandUpdate.setName(" update command");
        ((UpdateCommand) commandUpdate).setMainCategoryTag(TransactionCategoryTags.JEDZENIE);
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

    @RequestMapping(value ="/transaction/{id}", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionView> getTransaction(@RequestParam Long id) throws ResourceNotFoundException{

        TransactionView toReturn = queryProcessor.getTransactionById(id);
        if(toReturn == null){
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<>(toReturn, HttpStatus.OK);

    }


}
