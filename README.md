Zu Beginn des Projektes haben wir uns viele Gedanken gemacht, wie wir die Aufgabenstellung des Projektes umsetzen wollen. Nach einiger Überlegungszeit, haben wir uns dazu entschlossen,
einen Ball-shop zu programmieren. Im Ball-shop selbst, soll man einen Ball anhand einer Ballart, einer Farbe und einer Größe(size) konfigurieren können. Die Anzahl, wie oft dieser Ball
dem Warenkorb hinzugefügt werden soll, kann der Benutzer zudem selbst frei wählen. Bei der Eingabe der Anzahl, sowie dem späteren Speichern des Balles in einem Warenkorb, soll auf
eine entsprechende Exception-handling geachtet werden, sodass nur korrekt konfigurierte Bälle berechnet und gespeichert werden können. 

Der Warenkorb entspricht hierbei einer Array-Liste, in welcher wir die neu erzuegten Objekte(Bälle) speichern und auf dem Bildschirm ausgeben lassen. Es soll zudem eine Möglichkeit
bestehen, die Bälle im Warenkorb nach den unterschiedlichen Farben, welche zur Auswahl stehen, filtern zu können. Das Filtern nach der entsprechenden Farbe wurde durch das Einfügen 
von RadioButtons ermöglicht. Zur Durchführung dieser Filtermethode, haben wir eine zusätzliche Array-Liste erstellt, welche ausschließlich Bälle enthält, die die entsprechende
Farbe enthalten, welche vom Benutzer gefiltert werden soll. 

Nachdem diese Überlegungen angestellt wurden, entwickelten wir die fertige GUI-Oberfläche und schrieben hierzu den entsprechenden Programmcode in JAVA. 
Wir codierten eine Ball-Klasse, welche die entsprechenden Attribute enthielt und mit einem Konstruktor versehen war, sodass die Erstellung von neuen Objekten der Klasse Ball
ermöglicht wurde. Anschließend entwickelten wir den BaelleKonfigurator, in welchem wir den Programmcode schrieben, der die Umsetzung der GUI-Oberfläche möglicht machte.
Jeder Button bekam einen entsprechenden Action-Listener, sodass Benutzereingaben auf der GUI-Oberfläche berücksichtigt und gespeichert werden. 

Nach einiger Zeit war unser Programmcode schließlich fertig und funktionierte ohne Probleme. 


Probleme, die während des Projektes auftraten:

- Die Anzeige eines konfigurierten Balles im Warenkorb konnte zunächst nicht korrekt visualisiert werden. Aufgrund der Tatsache, dass unser Ball Attribute von verschiedenen
  Datentypen beinhaltet, mussten wir diese einheitliich in einen String umwandeln, um einen Ball in der TextAreaWarenkorb ausgeben zu lassen. Die Lösung dieses Problems erfolgte
  durch die Erstellung einer toString()-Methode, die unseren Ball mit all seinen Attributen als String ausgibt. 
