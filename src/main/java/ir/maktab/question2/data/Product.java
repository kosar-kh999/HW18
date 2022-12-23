/*package ir.maktab.question2.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product implements Subject {

    private ArrayList observers = new ArrayList();
    private String productName;
    private String productType;
    private String availability;

    public void setObservers(ArrayList observers) {
        this.observers = observers;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
        notifyObservers();
    }

    @Override
    public void signUpObserver(Observer observer) {
        observers.add(observers);
    }

    @Override
    public void signOutObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("");
    }
}*/
