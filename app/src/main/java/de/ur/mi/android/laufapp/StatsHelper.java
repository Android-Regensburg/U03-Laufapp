package de.ur.mi.android.laufapp;

public class StatsHelper {
    // Durschnittswerte zur Berechnung von Kalorien
    private final static double FAST_JOGGING_KCAL_PER_HOUR = 840;
    private final static double SLOW_JOGGING_KCAL_PER_HOUR = 530;
    private final static double MIN_SPEED_FOR_FAST_JOGGING = 7;

    // Default-Werte für Distanz, Zeit und Pausen
    private final static double DEFAULT_DISTANCE_IN_KM = 10;
    private final static double DEFAULT_TIME_IN_MIN = 60;
    private final static double DEFAULT_BREAK_TIME = 0;

    private double distance = DEFAULT_DISTANCE_IN_KM;
    private double time = DEFAULT_TIME_IN_MIN;
    private double breakTime = DEFAULT_BREAK_TIME;

    /**
     * bestimmt die gelaufene Distanz
     * @param distance Distanz in Kilometern
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * bestimmt die gelaufene Zeit
     * @param time Zeit in Minuten
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * bestimmt die Gesamtpausenzeit
     * @param breakTime Pausen in Minuten
     */
    public void setBreakTime(double breakTime) {
        this.breakTime = breakTime;
    }

    /**
     * gibt die Pace (Laufsport) zurück
     * @return durchschnittliche Pace: min/km (Minuten pro Kilometer)
     */
    public double getPace() {
        return time/distance;
    }

    /**
     * gibt die Durchschnittsgeschwindigkeit zurück
     * @return Durchschnittsgeschwindigkeit in km/h (Kilometer pro Stunde)
     */
    public double getSpeed() {
        return distance / ((time - breakTime)/60);
    }

    /**
     * gibt die geschätzen verbrannten Kalorien zurück
     * @return geschätze Kilokalorien, die während des Laufes verbraucht wurden
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
