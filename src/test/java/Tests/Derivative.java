package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import View.GUI;
import Controller.Control;

public class Derivative {
    @Test
    public void test()
    {
        GUI interfac = new GUI();
        Control control = new Control(interfac);
        interfac.userInput.setText("5x^2 + 2x + 1");
        interfac.getDerivative().doClick();
        assertEquals("2+10x", interfac.getAnswer().getText());
    }
}
