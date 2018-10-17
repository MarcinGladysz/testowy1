package testowy1.cqrs.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testowy1.cqrs.query.views.TransactionView;
import testowy1.model.Transaction;

import java.util.List;

@Service
public class QueryProcessor {

    @Autowired
    TransactionDataProvider transactionDataProvider;


    public List<TransactionView> testTransactionProcess() {
       return transactionDataProvider.getAllTransaction();
    }

    public TransactionView getTransactionById(Long id){
        return transactionDataProvider.getTransaction(id);
    }

}
