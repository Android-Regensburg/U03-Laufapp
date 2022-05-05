package de.ur.mi.android.laufapp.data;

public enum PaceLevel {

    SLOW(520),
    MODERATE(650),
    FAST(720);

    public final int caloriesPerHour;

    PaceLevel(int caloriesPerHour) {
        this.caloriesPerHour = caloriesPerHour;
    }

    public static PaceLevel fromPace(float minutesPerKilometer) {
        if (minutesPerKilometer > 6) {
            return SLOW;
        }
        if (minutesPerKilometer > 5) {
            return MODERATE;
        }
        return FAST;
    }

}
