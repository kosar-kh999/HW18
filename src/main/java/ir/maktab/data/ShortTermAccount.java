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
public class ShortTermAccount extends Account {
    private double profit;
    private int shortTermPeriod;

    public ShortTermAccount(String cardNumber, String accountNumber, Date openingDate, Date expiryDate, double amount,
                            int cvv2, double profit, int shortTermPeriod) {
        super(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2);
        this.profit = profit;
        this.shortTermPeriod = shortTermPeriod;
    }
}
