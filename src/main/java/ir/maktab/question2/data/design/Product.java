package ir.maktab.question2.data.design;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Product implements Subject {

    private List<Observer> observers;
    private String productName;
    private String availability;

    public Product(String productName) {
        observers = new ArrayList<>();
        this.productName = productName;
    }

    public void setObservers(ArrayList observers) {
        this.observers = observers;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setAvailability(String availability) {
        this.availability = availability;
        notifyObservers();
    }

    @Override
    public void signUpObserver(Observer observer) {
        if (observer == null) throw new NullPointerException("Observer is null . ");
        if (observers.contains(observer)) {
            throw new RuntimeException("Observer exist.");
        } else observers.add(observer);
    }

    @Override
    public void signOutObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.availability);
        }
    }
}
