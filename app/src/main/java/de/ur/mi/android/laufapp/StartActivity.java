package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    /**
     * Initialisierung des User Interface in einer ausgelagerten Methode. Der Aufruf erfolgt in
     * der onCreate-Methode.
     */
    private void initUI() {
        Log.d("Lauf-App", "in: initUI (StartActivity");
        setContentView(R.layout.activity_main);
        // @TODO Starten Sie hier mit Ihrer Implementierung
    }

}
