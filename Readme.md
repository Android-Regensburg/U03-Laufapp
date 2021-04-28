# 03 | Laufapp

## Aufgabenstellung

In dieser Aufgaben implementieren Sie eine App, die NutzerInnen die Berechnung des Kalorienverbrauchs beim Sport erlaubt. Durch die Eingabe der zurückgelegten Strecke, der dafür benötigten Zeit und eventuell eingelegten Pausen wird die Durchschnittsgeschwindigkeit (*Pace* in min/km) berechnet und der Kalorienverbrauch geschätzt.

Die notwendigen Daten zur Berechnung des Kalorienverbrauchs werden in der `StartActivity` von den NutzerInnen eingegeben. Die Ergebnisse der Berechnung werden in einer zweiten *Activity* angezeigt.

## Hinweise

- Verwenden Sie für die Berechnung des Kalorienverbrauchs und des *Pace* die Klasse `StatsHelper` aus dem Starterpaket. Die dort implementierte Funktionalität ist über kommentierte, öffentliche Methoden zugänglich.
- Verwenden Sie für die Eingabe der notwendigen Daten `EditText`-Elemente. Um mögliche "Fehleingaben" direkt auszuschließen, können Sie über den [Input Type](https://developer.android.com/training/keyboard-input/style) festlegen, welche Art von Text (Zahlen, Telefonnummer, Passwörter) über ein bestimmtes `EditText` eingegeben werden kann.
- Denken Sie an die qualitative hochwertige Gestaltung des Quellcodes. Verwenden Sie zusätzliche Methoden um Ihren Code zu strukturieren. Lagern Sie Beschriftungen konsequent in die Ressourcen-Dateien aus. Verwenden Sie *Activity*-übergreifend zugängliche Konstanten, um Werte in den *Intent*-Extras zu identifizieren. Nutzen Sie passende Bezeichner für Variablen und Methodennamen. Überarbeiten Sie Ihren Code regelmäßig und gewöhnen Sie sich an, [stets nach Verbesserungsmöglichkeiten zu suchen](https://martinfowler.com/bliki/OpportunisticRefactoring.html).

## Vorgehen

### Starterpaket

Laden Sie sich das Starterprojekt aus dem ILIAS-Kurs herunter, entpacken Sie den Projektordner auf Ihrem Rechner und öffnen Sie das Projekt in *Android Studio*. Beim ersten Start synchronisiert *Android Studio* die Projektinhalte und installiert ggf. noch fehlende Abhängigkeiten. Das merken Sie an einem Fortschrittsbalken unten rechts in der IDE. Testen Sie anschließend, ob Sie die Anwendung im vorgegebenen Zustand im Emulator ausführen können. **Im Starterpaket finden Sie auch die `StatsHelper`-Klasse für die Berechnung der Geschwindigkeit und der verbrannten Kalorien.

### StartActivity: Das User Interface

Erstellen Sie ein passendes Layout für die erste Activity. Sie benötigen Eingabefelder für die zurückgelegte Distanz, die benötigte Zeit und etwaige Pausen. Denken Sie daran, den NutzerInnen durch entsprechende Beschriftungen mitzuteilen, was in die Felder eingetragen werden soll. Zusätzlich wird im *User Interface* dieser *Activity* auch ein *Button* benötigt, der den Wechsel zum nächsten Bildschirm auslösen soll.

### StartActivity: Logik

Sorgen Sie dafür, das beim Klick auf den erstellten *Button* die aktuellen Inhalte der Eingabefelder ausgelesen werden und wechseln Sie anschließend zu einer zweiten Activity (`ResultActitvity`). Übergeben Sie dabei die ausgelesenen Werte für Distanz, Zeit und Pausen als *Extras* an diese neue Activity.

### ResultActivity: User Interface und Logik

Implementieren Sie eine zweite Activity (`ResultActivity`), die zur Darstellung der berechneten Ergebnisse dient und aus der `StartActivity` heraus aufgerufen wird (siehe oben). Erstellen Sie eine passende, neue Layout-Datei mit den notwendigen Inhalten, um diese Ergebnisse nutzerfreundlich zu präsentieren.

Lesen Sie beim Start der zweiten Activity die übergebenen Werte aus den *Extras* aus und verwenden Sie den `StatsHelper` um daraus Geschwindigkeit und Kalorienverbrauch zu berechnen. Zeigen Sie diese Ergebnisse im *User Interface* an und denken Sie dabei an eine passende Darstellung:

- Die Kalorien werden sinnvoll gerundet angezeigt.
- Die Geschwindigkeit wird im Format `MM:SS` angezeigt, z.b. als `05:40`.

## Screenshots der Anwendung

![Screenshot der Laufapp](./docs/screeshots-u03-Laufapp.png)
