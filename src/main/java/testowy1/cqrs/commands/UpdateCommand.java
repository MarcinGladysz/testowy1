package testowy1.cqrs.commands;


import lombok.Data;
import testowy1.model.TransactionCategoryTags;

import java.util.List;

@CommandHandlerAssigment(handlerClass = UpdateCommandHandler.class)
@Data
public class UpdateCommand extends Command {
    private long transactionID;
    private TransactionCategoryTags mainCategoryTag;
    private List<TransactionCategoryTags> otherCAtegories;
}
