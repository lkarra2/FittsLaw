package circledata;

/*
    CaptureData.java is a class that stores all data for each click
 */

public class CaptureData {

    private long elapsedTime;
    private int circleRadius;
    private int targetRadius;

    public void setCircleRadius(int circleRadius) {
        this.circleRadius = circleRadius;
    }

    public void setTargetRadius(int targetRadius) {
        this.targetRadius = targetRadius;
    }

    public int getCircleRadius() {
        return circleRadius;
    }

    public int getTargetRadius() {
        return targetRadius;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

}
