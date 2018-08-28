package testowy1.cqrs.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.model.Transaction;
import testowy1.model.TransactionRepository;

import java.time.LocalDateTime;

@Service
public class CreateTransactionCommandHandler extends CommandHandler<CreateTransactionCommand> {

    @Autowired
    TransactionRepository repository;

    @Override
    public void handle(CreateTransactionCommand command) {
        Transaction testTransaction = new Transaction();
        testTransaction.setMainCategoryTag(command.getMainCategoryTag());
        testTransaction.setOtherCategories(command.getOtherCategories());
        testTransaction.setAmount(command.getAmount());
        testTransaction.setDate(LocalDateTime.now());
        repository.save(testTransaction);

    }
}
