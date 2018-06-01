package by.matrosov.formula1challenge;

public class Bolid implements Car {
    private int index;
    private double distance;
    private double speed;
    private double maxSpeed;
    private int acceleration;
    private boolean finished;

    public Bolid(int index, double distance, double speed, boolean finished) {
        this.index = index;
        this.distance = distance;
        this.speed = speed;
        this.finished = false;
        this.maxSpeed = (150 + 10 * index) / 3.6;
        this.acceleration = 2 * index;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void move(double currDist, double currSpeed) {
        changeDistance(currDist, currSpeed);
        changeSpeed(currSpeed);
    }

    @Override
    public void speedReduce(double currSpeed) {
        this.speed = currSpeed * 0.8;
    }

    @Override
    public void nitro(double currSpeed) {
        if (currSpeed * 2 < this.maxSpeed){
            this.speed = currSpeed * 2;
        }else {
            this.speed = this.maxSpeed;
        }
    }

    private void changeDistance(double currDist, double currSpeed){
        this.distance = currDist + currSpeed * 2 + acceleration * 4 / 2;
    }

    private void changeSpeed(double currSpeed){
        this.speed = currSpeed + acceleration * 2;
    }

    @Override
    public String toString() {
        return "Bolid{" +
                "index=" + index +
                ", distance=" + distance +
                ", speed=" + speed +
                ", finished=" + finished +
                '}';
    }
}
