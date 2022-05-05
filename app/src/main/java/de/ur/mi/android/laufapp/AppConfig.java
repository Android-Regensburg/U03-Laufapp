package de.ur.mi.android.laufapp;

/*
 * Abstrakte Konfigurationsklasse für fixe Werte, die an verschiedenen Stellen der Anwendung
 * verwendet werden müssen. Hier werden in erster Linie die Schlüssel für den Intent zur Übergabe
 * der Nutzereingaben von der Start- in die Result-Activity definiert.
 */
public abstract class AppConfig {

    public static final String SHOW_RESULT_INTENT_DISTANCE_KEY = "DISTANCE";
    public static final String SHOW_RESULT_INTENT_TIME_KEY = "TIME";
    public static final String SHOW_RESULT_INTENT_BREAK_KEY = "BREAK";

}
