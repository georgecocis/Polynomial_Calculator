package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import View.GUI;
import Controller.Control;

public class Integration {
    @Test
    public void test()
    {
        GUI interfac = new GUI();
        Control control = new Control(interfac);
        interfac.userInput.setText("5x^2 + 2x + 1");
        interfac.getIntegration().doClick();
        assertEquals("x+x^2+1.7x^3", interfac.getAnswer().getText());
    }
}
