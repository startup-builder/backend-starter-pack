package info.startupbuilder.backendstarterpack;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Entity
@Table(name = "entry", schema = "accounting")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Account account;

    @Enumerated(EnumType.STRING)
    Type type;

    @NotNull
    BigDecimal amount;

    public enum Type {
        DEBIT,
        CREDIT
    }
}
