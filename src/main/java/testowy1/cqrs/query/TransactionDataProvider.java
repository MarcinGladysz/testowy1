package testowy1.cqrs.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.cqrs.query.views.TransactionView;
import testowy1.model.Transaction;
import testowy1.model.TransactionRepository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDataProvider {

    @Autowired
    private TransactionRepository repository;


    public List<TransactionView> getAllTransaction() {
        List<TransactionView> listViews = new ArrayList<>();
        repository.findAll().forEach(s ->
            listViews.add(mapModelToView(s))
        );
        return listViews;
    }

    private TransactionView mapModelToView(Transaction model) {
        return TransactionView.builder()
            .amount(model.getAmount())
            .id(model.getId())
            .mainCategoryTag(model.getMainCategoryTag())
            .SourceCategory(model.getSourceCategory())
            .otherCategories(model.getOtherCategories())
            .date(model.getDate().format(DateTimeFormatter.RFC_1123_DATE_TIME))
            .build();
    }

    public TransactionView getTransaction(Long id){
        return mapModelToView(repository.findOne(id));
    }

}
