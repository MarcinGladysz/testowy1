package testowy1.cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.model.Transaction;
import testowy1.model.TransactionCategoryTags;
import testowy1.model.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestowyHandler extends CommandHandler<TestowaCommand> {

    @Autowired
    TransactionRepository repository;

    @Override
    public void handle(TestowaCommand command) {
        System.out.println("JEJEJE" + command.getName());

        Transaction testTraansaaction = new Transaction();
        testTraansaaction.setMainCategoryTag(TransactionCategoryTags.EDUKACJA);
        List<TransactionCategoryTags> otherCategory = new ArrayList<>();
        otherCategory.add(TransactionCategoryTags.PRACA);
        otherCategory.add(TransactionCategoryTags.ROZRYWKA);
        testTraansaaction.setOtherCategories(otherCategory);
        repository.save(testTraansaaction);
    }
}
