import Controller.Control;
import Model.Monomial;
import Model.Polynomial;
import View.GUI;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
        GUI view = new GUI();
        Control controller = new Control(view);
        view.setVisible(true);
    }
}
