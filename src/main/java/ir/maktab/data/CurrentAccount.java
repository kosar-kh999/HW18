package ir.maktab.data;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class CurrentAccount extends Account {
    private boolean isCheckBook;

    public CurrentAccount(String cardNumber, String accountNumber, Date openingDate, Date expiryDate, double amount,
                          int cvv2, boolean isCheckBook) {
        super(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2);
        this.isCheckBook = isCheckBook;
    }
}
