package testowy1.cqrs.query.views;

import lombok.Builder;
import lombok.Data;
import testowy1.model.TransactionCategoryTags;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class TransactionView {
    private long id;
    private TransactionCategoryTags mainCategoryTag;
    private BigDecimal amount;
    private String SourceCategory;
    private List<TransactionCategoryTags> otherCategories;
    private String date;
}
