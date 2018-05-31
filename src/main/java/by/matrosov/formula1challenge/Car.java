package by.matrosov.formula1challenge;

public class Car implements Movement {
    private int index; //from 1 to n
    private float maxVelocity; //km/s
    private float currVelocity; //km/s
    private float distance; //km
    private int position;

    public Car(int index, float currVelocity, float distance, int position) {
        this.index = index;
        this.maxVelocity = 150000 + 2.8f * index;
        this.currVelocity = currVelocity;
        this.distance = distance;
        this.position = position;
    }

    @Override
    public void move(float distance, float currentVelocity, int index) {
        this.distance = distance + 2 * currentVelocity + 4 * index;
        System.out.println("Car i= " + index + " on distance " + this.distance);
    }

    @Override
    public void nitro(int position, float currentVelocity) {

    }

    @Override
    public void speedReduce(float distance, float currentVelocity) {

    }

    private void checkAround10meters(){

    }

    private void checkLastPosition(){

    }
}
