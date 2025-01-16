package Projektarbeit;

//Importe der swing-Oberfläche, sowie des ActionListeners und der Arrayliste
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BaelleKonfigurator extends JFrame {
    // alle GUI-Komponenten
    private JTextField textFieldPreis;
    private JLabel labelPreis;
    private JLabel labelBallart;
    private JComboBox<String> comboBoxBallart;
    private JLabel labelSize;
    private JComboBox<String> comboBoxSize;
    private JButton buttonBerechne;
    private JLabel labelFarbe;
    private JComboBox<String> comboBoxFarbe;
    private JPanel myPanelBall;
    private JButton buttonSpeichern;
    private JButton buttonBerechneGesamtpreis;
    private JTextField textFieldAnzahl;
    private JLabel labelAnzahl;
    private JTextField textFieldWarenkorb;
    private JLabel labelWarenkorb;
    private JTextArea textAreaWarenkorb;
    private JTextField textFieldGesamtpreis;
    private JLabel labelGesamtpreis;
    private JRadioButton RadioButtonBlau;
    private JRadioButton RadioButtonRot;
    private JRadioButton RadioButtonGruen;
    private JRadioButton RadioButtonGelb;
    private JRadioButton RadioButtonLila;
    private JRadioButton RadioButtonMagenta;
    private JButton filterZurücksetzenButton;
    private ButtonGroup colorButtonGroup;

    /*anlegen von 2 ArrayListen - eine ArrayListe des Warenkorbs, sowie eine ArrayLise
    die nur die gefilterten Bälle anzeigen soll */
    private ArrayList<Ball> warenkorb = new ArrayList<>();
    private ArrayList<Ball> gefilterteBaelle = new ArrayList<>();


//Konfiguration der Benutzeroberfläche
    public BaelleKonfigurator() {
        setTitle("BaelleKonfigurator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setContentPane(myPanelBall);
        setVisible(true);

        //Aufruf der initObjekte-Methode, welche 3 Objekte erzeugt und diese dem Warenkorb hinzufügt
        initObjekte();


        // Berechnen-Button
        buttonBerechne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double preis = 0.0;

                    // Ballart auswählen und Basispreis setzen
                    String ballart = comboBoxBallart.getSelectedItem().toString();
                    switch (ballart) {
                        case "Fussball":
                            preis = 30.0;
                            break;
                        case "Basketball":
                            preis = 25.0;
                            break;
                        case "Tennisball":
                            preis = 10.0;
                            break;
                        case "Volleyball":
                            preis = 20.0;
                            break;
                        case "Federball":
                            preis = 10.0;
                            break;
                        case "Handball":
                            preis = 10.0;
                            break;
                        case "Rugbyball":
                            preis = 25.0;
                            break;
                    }

                    // Anzahl auslesen und Fehler abfangen
                    int anzahl = Integer.parseInt(textFieldAnzahl.getText());

                    // Gesamtpreis berechnen
                    preis *= anzahl;
                    textFieldPreis.setText("Ihre Auswahl: " + ballart + " kostet " + /*String.format("%.2f", preis)*/ preis + " EUR");

/* die String.format("%.2f") Methode:
- .format gibt das Ergebnis als String zurück, anstatt es direkt (als double) auszugeben
- % markiert den Beginn einer Formatierugsanweisung
- f steht für eine Fließkommazahl (float)
- .2 gibt an, dass genau 2 Nachkommastellen angezeigt werden sollen
-> Der Preis wird also als String, z.B "30.00" mit genau 2 Nachkommastellen angegeben
-> Eine Darstellung des textFieldPreis wäre auch mit ... + preis + "EUR" möglich gewesen,
allerdings werden Preise immer mit 2 Nachkommastellen angegeben, die String.format("%.2f", preis)-Methode
würde komplexere Preise immer genau runden und es wird mit dieser Methode einzig ein String,
und keine Mischung aus String & double ausgegeben, weshalb wir uns für diese Methode entschieden haben.
*/

                 //catch-Block mit pop-up-message(sog. showMessageDialog), sollte keine Zahl eingegeben werden.

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte eine gültige Zahl eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Speichern-Button
        buttonSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Eingaben aus den Comboboxen und Textfeldern auslesen
                    int size = Integer.parseInt(comboBoxSize.getSelectedItem().toString());
                    String ballart = comboBoxBallart.getSelectedItem().toString();
                    String farbe = comboBoxFarbe.getSelectedItem().toString();
                    int anzahl = Integer.parseInt(textFieldAnzahl.getText());

                    // Basispreis der Ballart bestimmen
                    double basisPreis = 0.0;
                    switch (ballart) {
                        case "Fussball":
                            basisPreis = 30.0;
                            break;
                        case "Basketball":
                            basisPreis = 25.0;
                            break;
                        case "Tennisball":
                            basisPreis = 10.0;
                            break;
                        case "Volleyball":
                            basisPreis = 20.0;
                            break;
                        case "Federball":
                            basisPreis = 10.0;
                            break;
                        case "Handball":
                            basisPreis = 10.0;
                            break;
                        case "Rugbyball":
                            basisPreis = 25.0;
                            break;
                    }

                    // Gesamtpreis berechnen
                    double gesamtPreis = basisPreis * anzahl;

                    // Neuen Ball erstellen und in ArrayListe Warenkorb speichern
                    Ball neuerBall = new Ball(size, farbe, ballart, anzahl, gesamtPreis);
                    warenkorb.add(neuerBall);

                    // Ball im Textbereich (textAreaWarenkorb) anzeigen
                    /*
                    .append(neuerBall) lässt den neu erstellten Ball im Warenkorb mit all seinen
                    Eigenschaften(size,farbe,etc) in einer Zeile anzeigen, sodass das neu erstellte
                    Objekt mit all seinen Attributen übersichtlich  dargestellt wird,
                    + "\n" bewirkt, dass ein weiteres Objekt in einer Zeile darunter angezeigt wird.
                    es bewirkt also einen Zeilenumbruch.
                     */

                    textAreaWarenkorb.append(neuerBall + "\n");

                    // Erfolgsnachricht anzeigen
                    JOptionPane.showMessageDialog(null, "Ball erfolgreich gespeichert!", "Speichern", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler beim Speichern! Bitte Eingaben überprüfen.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Gesamtpreis-Button
        buttonBerechneGesamtpreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double gesamtPreis = 0.0;

                // Prüfen, ob eine gefilterte Liste existiert
                if (!gefilterteBaelle.isEmpty()) {
                    // Gesamtpreis der gefilterten Bälle berechnen
                    for (Ball ball : gefilterteBaelle) {
                        gesamtPreis += ball.berechneGesamtpreis();
                    }
                } else {
                    // Gesamtpreis des gesamten Warenkorbs berechnen
                    for (Ball ball : warenkorb) {
                        gesamtPreis += ball.berechneGesamtpreis();
                    }
                }

                // Gesamtpreis anzeigen
                textFieldGesamtpreis.setText("Gesamtpreis: " + String.format("%.2f", gesamtPreis) + " EUR");
            }
        });

        // ActionListener für die RadioButtons
        ActionListener radioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prüfe, welcher RadioButton ausgewählt wurde
                String ausgewählteFarbe = ""; /* ausgewählte Farbe = "leerer" String
                vergleichbar mit preis = 0; */
                if (RadioButtonBlau.isSelected()) {
                    ausgewählteFarbe = "blau";
                } else if (RadioButtonRot.isSelected()) {
                    ausgewählteFarbe = "rot";
                } else if (RadioButtonGruen.isSelected()) {
                    ausgewählteFarbe = "grün";
                } else if (RadioButtonGelb.isSelected()) {
                    ausgewählteFarbe = "gelb";
                } else if (RadioButtonLila.isSelected()) {
                    ausgewählteFarbe = "lila";
                } else if (RadioButtonMagenta.isSelected()) {
                    ausgewählteFarbe = "magenta";
                }

                // Filtere den Warenkorb nach der ausgewählten Farbe
                // Aufruf der Methode filtereNachFarbe
                filtereNachFarbe(ausgewählteFarbe);
            }
        };

        //Listener zu den RadioButtons hinzufügen
        RadioButtonBlau.addActionListener(radioButtonListener);
        RadioButtonRot.addActionListener(radioButtonListener);
        RadioButtonGruen.addActionListener(radioButtonListener);
        RadioButtonGelb.addActionListener(radioButtonListener);
        RadioButtonLila.addActionListener(radioButtonListener);
        RadioButtonMagenta.addActionListener(radioButtonListener);

        filterZurücksetzenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Leere die Textarea
                textAreaWarenkorb.setText("");

                // Zeige alle Bälle aus dem ursprünglichen Warenkorb
                for (Ball ball : warenkorb) {
                    textAreaWarenkorb.append(ball.toString() + "\n");
                }

                // Leere die gefilterte Liste, damit alle Bälle wieder angezeigt werden
                gefilterteBaelle.clear();

                // Setze die RadioButtons zurück
                colorButtonGroup.clearSelection();

            }
        });


    }

    private void filtereNachFarbe(String farbe) {
        // Leere die Textarea
        textAreaWarenkorb.setText("");

        // Leere die gefilterte Liste
        gefilterteBaelle.clear();

        // Filtere den Warenkorb
        for (Ball ball : warenkorb) {
            if (ball.getFarbe().equalsIgnoreCase(farbe)) {
                gefilterteBaelle.add(ball);
                textAreaWarenkorb.append(ball.toString() + "\n");
            }
        }

        // Nachricht anzeigen, falls keine Bälle der Filterfarbe entsprechen
        if (gefilterteBaelle.isEmpty()) {
            textAreaWarenkorb.setText("Keine Bälle in der Farbe '" + farbe + "' gefunden.");
        }
    }

    public void initObjekte() {
        // Initialisierung von drei Bällen
        Ball ball1 = new Ball(5, "blau", "Fussball", 2, 60.0);
        Ball ball2 = new Ball(3, "rot", "Basketball", 1, 25.0);
        Ball ball3 = new Ball(4, "magenta", "Tennisball", 3, 30.0);

        // Bälle zum Warenkorb hinzufügen
        warenkorb.add(ball1);
        warenkorb.add(ball2);
        warenkorb.add(ball3);

        // Bälle im Warenkorb anzeigen
        for (Ball ball : warenkorb) {
            textAreaWarenkorb.append(ball.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new BaelleKonfigurator();
    }
}































