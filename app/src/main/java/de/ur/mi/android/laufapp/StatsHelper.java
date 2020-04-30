package de.ur.mi.android.laufapp;

public class StatsHelper {
    // Average values for calorie calculation
    private final static double FAST_JOGGING_KCAL_PER_HOUR = 840;
    private final static double SLOW_JOGGING_KCAL_PER_HOUR = 530;
    private final static double MIN_SPEED_FOR_FAST_JOGGING = 7;

    // Default values for distance, time and pauses
    private final static double DEFAULT_DISTANCE_IN_KM = 10;
    private final static double DEFAULT_TIME_IN_MIN = 60;
    private final static double DEFAULT_BREAK_TIME = 0;

    private double distance = DEFAULT_DISTANCE_IN_KM;
    private double time = DEFAULT_TIME_IN_MIN;
    private double breakTime = DEFAULT_BREAK_TIME;

    /**
     * Sets travelled distance
     * @param distance distance in kilometers
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Sets time used
     * @param time time in minutes
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Sets overall break time
     * @param breakTime break time in minutes
     */
    public void setBreakTime(double breakTime) {
        this.breakTime = breakTime;
    }

    /**
     * Returns average pace
     * @return average pace in minutes per kilometer
     */
    public double getPace() {
        return time/distance;
    }

    /**
     * Returns average speed
     * @return average speed in kilometers per hour
     */
    public double getSpeed() {
        return distance / ((time - breakTime)/60);
    }

    /**
     * Returns estimated calories burned during run
     * @return estimated kilocalories burned during run
     */
    public double getBurnedKilocalories() {
        double speed = getSpeed();
        double kcal = 0;
        if (speed >= MIN_SPEED_FOR_FAST_JOGGING) {
            kcal = FAST_JOGGING_KCAL_PER_HOUR * (time / 60);
        } else {
            kcal = SLOW_JOGGING_KCAL_PER_HOUR * (time / 60);
        }
        return kcal;
    }

}
