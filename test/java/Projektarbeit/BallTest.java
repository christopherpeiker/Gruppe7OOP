package Projektarbeit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void berechneGesamtpreis() {

        Ball ball1 = new Ball (3, "gruen", "tennisball", 3, 30);
        Ball ball2 = new Ball (4, "blau", "fussball", 3, 90);
        assertEquals(30, ball1.berechneGesamtpreis());
        assertEquals(90, ball2.berechneGesamtpreis());





    }
}