package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import View.GUI;
import Controller.Control;

public class Multiplication {
    @Test
    public void test()
    {
        GUI interfac = new GUI();
        Control control = new Control(interfac);
        interfac.userInput.setText("5x^2 + 2x + 1");
        interfac.userInput2.setText("x^2 + 4");
        interfac.getMultiplication().doClick();
        assertEquals("4+8x+21x^2+2x^3+5x^4", interfac.getAnswer().getText());
    }
}
