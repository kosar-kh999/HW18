package ir.maktab.data;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@EqualsAndHashCode
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 16)
    private String cardNumber;
    @Column(unique = true)
    private String accountNumber;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date openingDate;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expiryDate;
    private double amount;
    @Column(length = 4)
    private int cvv2;

    public Account(String cardNumber, String accountNumber, Date openingDate, Date expiryDate, double amount, int cvv2) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.expiryDate = expiryDate;
        this.amount = amount;
        Random random = new Random();
        this.cvv2 = random.nextInt(100, 9999);
    }
}
