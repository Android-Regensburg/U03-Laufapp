package de.ur.mi.android.laufapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        distanceResult = findViewById(R.id.distanceResultView);
        paceResult = findViewById(R.id.paceResultView);
        caloriesResult = findViewById(R.id.caloriesResultView);
    }

    private void showResults() {
        StatsHelper helper = new StatsHelper();
        // Auslesen aller  übergebenen Werte aus dem Intent
        Bundle extra = getIntent().getExtras();
        // Zugriff und Verwendung einzelner Werte über die Getter-Funktionen und die öffentlichen
        // Key-Konstanten aus StartActivity
        helper.setDistance(extra.getDouble(StartActivity.DISTANCE_KEY));
        helper.setTime(extra.getDouble(StartActivity.TIME_KEY));
        helper.setBreakTime(extra.getDouble(StartActivity.BREAK_KEY));
        distanceResult.setText(String.valueOf(extra.getDouble(StartActivity.DISTANCE_KEY)));
        // Für die Darstellung im User Interface wird der Kalorienverbrauch gerundet
        caloriesResult.setText(String.valueOf(Math.round(helper.getBurnedKilocalories())));
        // Formatierung der Geschwindigkeit in mehreren Schritte:
        // StatsHelper gibt die Geschwindigkeit (Minunten pro Kilometer) als Fließkommazahl zurück.
        // Der Minuten-Wert wird durch einen Cast auf einen Integer-Wert erzeugt (Reduktion der
        // Genauigkeit, bzw. Streichen der Nachkommastellen)
        int minutes = (int) helper.getPace();
        // Der Sekunden-Wert wird durch Umrechung des verbleibenden Dezimalwerts hinter dem Komma
        // ermittelt (0.5 * 60 => 30 Sekunden)
        int seconds = (int) ((helper.getPace() - minutes) * 60);
        // Für eine "schönere" Darstellung werden führende Nullen ergänzt, wenn die ermittelten
        // Werte für Minuten und Sekunden einstellig sind
        String minutesString = minutes > 10 ? "" + minutes : "0" + minutes;
        String secondsString = seconds > 10 ? "" + seconds : "0" + seconds;
        paceResult.setText(minutesString + ":" + secondsString);
    }
}
