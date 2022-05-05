package de.ur.mi.android.laufapp.data;

/**
 * Die Klasse Run repräsentiert einen Lauf der Nutzer*innen der App. Für jeden Lauf werden die
 * Distanz (in Metern), die absolute Zeit (in Sekunden) und die Pausenzeiten (in Sekunden) angegeben.
 * Die Werte können aus dem Immutable-Objekt ausgelesen werden. Über zwei öffentliche Methoden kann
 * der Pace, als durchschnittliche Geschwindigkeit in Minuten pro Kilometer und die insgesamt
 * umgesetzten Kalorien bestimmt werden. Zur Kalorienberechnung werden die verschiedenen PaceLevel
 * verwendet, die bei der Kalorienberechnung von einem durchschnittlichen Gewicht der Läufer*innen
 * von 65kg ausgehen.
 */
public class Run {

    public final int distance; // Gelaufene Distanz in Metern
    public final int totalTime; // Gesamtzeit in Sekunden
    public final int breakTime; // Pausenzeit in Sekunden

    /**
     * Erstellt ein neues Datenobjekt für einen Lauf der Nutzer*innen.
     * @param distance Gelaufende Distanz in Metern
     * @param totalTime Gesamtzeit in Sekunden
     * @param breakTime Pausenzeit in Sekunden
     */
    public Run(int distance, int totalTime, int breakTime) {
        this.distance = distance;
        this.totalTime = totalTime;
        this.breakTime = breakTime;
    }

    /**
     * Gibt den durchschnittlichen Pace für diesen Lauf in Minuten pro Kilometer zurück. Für die
     * Berechnung wird die angegebene Gesamtdistanz sowie die gelaufene Zeit abzuüglich der
     * angegebenen Pausenzeiten verwendet.
     *
     * @return Der durchschnittliche Pace für diesen Lauf in Minuten pro Kilometer.
     */
    public float getPace() {
        float distanceInKilometers = distance / 1000;
        float timeInMinutes = (totalTime - breakTime) / 60f;
        return timeInMinutes / distanceInKilometers;
    }

    /**
     * Gibt die geschätzte Anzahl der mit diesem Lauf umgesetzten Kalorien zurück. Grundlage für die
     * Berechnung sind die gelaufene Zeite abzuüglich der Pausenzeiten und der dabei erreichte,
     * durchschnittliche Pace. Die Berechnung geht von einem durchschnittlichen Körpergewicht der
     * Läufer*innen von 65kg aus.
     *
     * @return Geschätze Anzahl der mit diesem Lauf umgesetzten Kalorien.
     */
    public float getCalories() {
        PaceLevel paceLevel = PaceLevel.fromPace(getPace());
        float timeInHours = (totalTime - breakTime) / 3600f;
        return timeInHours * paceLevel.caloriesPerHour;
    }
}