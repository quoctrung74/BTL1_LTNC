public interface Observable<T>{
    void addObserver(Observer<T>);
    void removeObserver(Observer<T>);
    void notifyObservers(T event);
}