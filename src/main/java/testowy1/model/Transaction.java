package testowy1.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private TransactionCategoryTags mainCategoryTag;
    @Column
    private BigDecimal amount;
    @Column
    private String SourceCategory;

    @ElementCollection
    @CollectionTable(name="multiCategory", joinColumns = @JoinColumn(name="CategoryId"))
    @Column(name = "otherCategory")
    private List<TransactionCategoryTags> otherCategories;

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + id +
            ", mainCategoryTag=" + mainCategoryTag +
            ", amount=" + amount +
            ", SourceCategory='" + SourceCategory + '\'' +
            ", otherCategories=" + otherCategories +
            '}';
    }
}
