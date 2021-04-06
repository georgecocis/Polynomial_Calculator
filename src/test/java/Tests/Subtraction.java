package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import View.GUI;
import Controller.Control;

public class Subtraction {
    @Test
    public void test()
    {
        GUI interfac = new GUI();
        Control control = new Control(interfac);
        interfac.userInput.setText("5x^2 + 2x + 1");
        interfac.userInput2.setText("x^2 + 4");
        interfac.getSubtraction().doClick();
        assertEquals("-3+2x+4x^2", interfac.getAnswer().getText());
    }
}