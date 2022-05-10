package de.ur.mi.android.laufapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.ur.mi.android.laufapp.data.Run;

/**
 * Diese Activity dient der Berechnung von Geschwindigkeit von Kalorienverbrauch. Die Werte werden
 * über den aufrufenden Intent übergeben. Die Berechnung erfolgt durch den StatsHelper.
 */

public class ResultActivity extends AppCompatActivity {

    private TextView distanceResult;
    private TextView paceResult;
    private TextView caloriesResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        showResults();
    }

    private void initUI() {
        setContentView(R.layout.activity_result);
        distanceResult = findViewById(R.id.distance_value);
        paceResult = findViewById(R.id.pace_value);
        caloriesResult = findViewById(R.id.calories_value);
    }

    private void showResults() {
        Run run = createRunFromBundle(getIntent().getExtras());
        showDistanceFromRun(run);
        showCaloriesFromRun(run);
        showPaceFromRun(run);
    }

    private Run createRunFromBundle(Bundle bundle) {
        double distanceInKilometers = bundle.getDouble(AppConfig.SHOW_RESULT_INTENT_DISTANCE_KEY);
        double timeInMinutes = bundle.getDouble(AppConfig.SHOW_RESULT_INTENT_TIME_KEY);
        double breakInMinutes = bundle.getDouble(AppConfig.SHOW_RESULT_INTENT_BREAK_KEY);
        return new Run((int) (distanceInKilometers * 1000), (int) timeInMinutes * 60, (int) breakInMinutes * 60);
    }

    private void showDistanceFromRun(Run run) {
        distanceResult.setText(String.valueOf(run.distance / 1000f));
    }

    private void showCaloriesFromRun(Run run) {
        // Für die Darstellung im User Interface wird der Kalorienverbrauch gerundet
        caloriesResult.setText(String.valueOf(Math.round(run.getCalories())));
    }

    private void showPaceFromRun(Run run) {
        // Formatierung der Geschwindigkeit in mehreren Schritten:
        // StatsHelper gibt die Geschwindigkeit (Minuten pro Kilometer) als Fließkommazahl zurück.
        // Der Minuten-Wert wird durch einen Cast auf einen Integer-Wert erzeugt (Reduktion der
        // Genauigkeit, bzw. Streichen der Nachkommastellen)
        int minutes = (int) run.getPace();
        // Der Sekunden-Wert wird durch Umrechnung des verbleibenden Dezimalwerts hinter dem Komma
        // ermittelt (0.5 * 60 => 30 Sekunden)
        int seconds = (int) ((run.getPace() - minutes) * 60);
        // Für eine "schönere" Darstellung werden führende Nullen ergänzt, wenn die ermittelten
        // Werte für Minuten und Sekunden einstellig sind
        String minutesString = minutes > 10 ? "" + minutes : "0" + minutes;
        String secondsString = seconds > 10 ? "" + seconds : "0" + seconds;
        paceResult.setText(minutesString + ":" + secondsString);
    }
}
