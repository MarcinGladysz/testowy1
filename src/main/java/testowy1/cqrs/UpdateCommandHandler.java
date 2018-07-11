package testowy1.cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.model.TransactionRepository;

@Service
public class UpdateCommandHandler extends CommandHandler<UpdateCommand> {

    @Autowired
    TransactionRepository repository;

    @Override
    public void handle(UpdateCommand command) {

        System.out.println("teraz to" + command.getName());
    }
}
