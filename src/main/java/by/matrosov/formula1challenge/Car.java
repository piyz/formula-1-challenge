package by.matrosov.formula1challenge;

public interface Car {
    void move(double currDist, double currSpeed);
    void speedReduce(double currSpeed);
    void nitro(double currSpeed);
}
