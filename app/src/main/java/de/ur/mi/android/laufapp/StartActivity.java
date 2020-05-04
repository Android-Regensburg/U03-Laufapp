package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Diese Anwendung erlaubt LäuferInnen, die Geschwindigkeit und den geschätzten Kalorienverbrauch
 * von einzelnen Läufen zu berechnen. Dazu werden zurückgelegte Strecke, benötigte Zeit und etwaige
 * Pausenzeiten eingegeben. Auf Basis dieser Eingaben ermittelt die App die durchschnittliche
 * Geschwindikgeit (Pace) in Minuten pro Kilometer und gibt eine Schätzung für die dabei verbrannten
 * Kalorien aus.
 */

/**
 * Diese Activity dient der Eingabe der benötigten Werte für die Berechnung von Geschwindigkeit und
 * Kalorienverbrauch.
 */

public class StartActivity extends AppCompatActivity {

    /**
     * Öffentliche Konstanten zum Identifizieren (Key) der Eingabewerte (Value) im Intent zum Aufruf
     * der Ergebnis-Activity.
     */
    public static final String DISTANCE_KEY = "DISTANCE";
    public static final String TIME_KEY = "TIME";
    public static final String BREAK_KEY = "BREAK";

    /**
     * Instanzvariablen für Referenzen auf Eingabefelder
     */
    private EditText distanceInput;
    private EditText timeInput;
    private EditText breakInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        distanceInput = findViewById(R.id.distanceInput);
        timeInput = findViewById(R.id.timeInput);
        breakInput = findViewById(R.id.breakInput);
        Button button = findViewById(R.id.statsButton);
        // Der Listener für den Klick/Touch auf den Button wird als innere,
        // annonyme Klasse erzeugt. In der zu implementierende Callback-Methode
        // wird auf eine Methode (onResultButtonClicked) der umschließenden Activity
        // verwiesen.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResultButtonClicked();
            }
        });
    }

    private void onResultButtonClicked() {
        // Erstellen des Intents zum Aufruf der zweiten Activity
        Intent intent = new Intent(this, ResultActivity.class);
        // Speichern der aktuellen Werte aus den Eingabefeldern in den Extras des Intents
        // Alle Werte werden als Fließkommazahlen übergeben, da der eingesetzte StatsHelper
        // Double-Werte verlangt. Für diesen Anwendungsfall würde aber auch die Genauigkeit
        // von Float-Werten ausreichen.
        intent.putExtra(DISTANCE_KEY, Double.parseDouble(distanceInput.getText().toString()));
        intent.putExtra(TIME_KEY, Double.parseDouble(timeInput.getText().toString()));
        intent.putExtra(BREAK_KEY, Double.parseDouble(breakInput.getText().toString()));
        startActivity(intent);
    }

}
