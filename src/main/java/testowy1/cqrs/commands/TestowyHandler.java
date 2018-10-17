package testowy1.cqrs.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.model.Transaction;
import testowy1.model.TransactionCategoryTags;
import testowy1.model.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestowyHandler extends CommandHandler<TestowaCommand> {

    @Autowired
    TransactionRepository repository;

    @Override
    public void handle(TestowaCommand command) {
        System.out.println("JEJEJE" + command.getName());

        Transaction testTransaction = new Transaction();
        testTransaction.setMainCategoryTag(TransactionCategoryTags.EDUKACJA);
        List<TransactionCategoryTags> otherCategory = new ArrayList<>();
        otherCategory.add(TransactionCategoryTags.PRACA);
        otherCategory.add(TransactionCategoryTags.ROZRYWKA);
        testTransaction.setOtherCategories(otherCategory);
        testTransaction.setAmount(new BigDecimal("10"));
        testTransaction.setDate(LocalDateTime.now());
        repository.save(testTransaction);
    }
}
