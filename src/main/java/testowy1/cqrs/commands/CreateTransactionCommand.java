package testowy1.cqrs.commands;

import lombok.Data;
import testowy1.model.TransactionCategoryTags;

import java.math.BigDecimal;
import java.util.List;

@CommandHandlerAssigment(handlerClass = CreateTransactionCommandHandler.class)
@Data
public class CreateTransactionCommand extends Command {
    private TransactionCategoryTags mainCategoryTag;
    private BigDecimal amount;
    private String SourceCategory;
    private List<TransactionCategoryTags> otherCategories;
    private String date;
}
