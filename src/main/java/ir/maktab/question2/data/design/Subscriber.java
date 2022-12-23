package ir.maktab.question2.data.design;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscriber implements Observer {
    private String name;

    @Override
    public void update(String availability) {
        System.out.println(this.name + "\t your favorite product is now \t" + availability);
    }

}
