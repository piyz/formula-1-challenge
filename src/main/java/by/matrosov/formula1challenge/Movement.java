package by.matrosov.formula1challenge;

public interface Movement {
    void move(float distance, float currentVelocity, int index);
    void nitro(int position, float currentVelocity);
    void speedReduce(float distance, float currentVelocity);
}
