package ir.maktab.question2.data.design;


public interface Subject {
    void signUpObserver(Observer observer);

    void signOutObserver(Observer observer);

    void notifyObservers();

}
