package de.ur.mi.android.laufapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Diese Anwendung erlaubt LäuferInnen, die Geschwindigkeit und den geschätzten Kalorienverbrauch
 * von einzelnen Läufen zu berechnen. Dazu werden zurückgelegte Strecke, benötigte Zeit und etwaige
 * Pausenzeiten eingegeben. Auf Basis dieser Eingaben ermittelt die App die durchschnittliche
 * Geschwindigkeit (Pace) in Minuten pro Kilometer und gibt eine Schätzung für die dabei verbrannten
 * Kalorien aus.
 */

/**
 * Diese Activity dient der Eingabe der benötigten Werte für die Berechnung von Geschwindigkeit und
 * Kalorienverbrauch.
 */

public class StartActivity extends AppCompatActivity {

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
        distanceInput = findViewById(R.id.input_distance);
        timeInput = findViewById(R.id.input_time);
        breakInput = findViewById(R.id.input_break);
        Button button = findViewById(R.id.button_show_stats);
        // Der Listener für den Klick/Touch auf den Button wird als innere,
        // anonyme Klasse erzeugt (Abgekürzt über eine Lambda-Ausdruck). In der zu implementierende
        // Callback-Methode wird eine Methode (onResultButtonClicked) der umschließenden Activity
        // aufgerufen.
        button.setOnClickListener(view -> onResultButtonClicked());
    }

    private void onResultButtonClicked() {
        // Erstellen des Intents zum Aufruf der zweiten Activity
        Intent intent = new Intent(this, ResultActivity.class);
        // Speichern der aktuellen Werte aus den Eingabefeldern in den Extras des Intents
        // Alle Werte werden als Fließkommazahlen übergeben, um eine möglichst hohe
        // Genauigkeit für die spätere Umrechnung zu erhalten.
        intent.putExtra(AppConfig.SHOW_RESULT_INTENT_DISTANCE_KEY, getValueFromEditText(distanceInput));
        intent.putExtra(AppConfig.SHOW_RESULT_INTENT_TIME_KEY, getValueFromEditText(timeInput));
        intent.putExtra(AppConfig.SHOW_RESULT_INTENT_BREAK_KEY, getValueFromEditText(breakInput));
        startActivity(intent);
    }

    private double getValueFromEditText(EditText editText) {
        try {
            /*
             * Wir machen uns zu nutze, das es bei der Eingabe der Werte keine Möglichkeit gibt,
             * ein Komma als Dezimaltrennzeichen einzugeben. Es kann nur der Punkt verwendet werden.
             */
            NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
            Number value = format.parse(editText.getText().toString());
            if (value != null) {
                return value.doubleValue();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0d;
    }

}
