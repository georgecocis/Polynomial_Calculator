package Controller;
import Model.Monomial;
import Model.Polynomial;
import View.GUI;
import java.awt.event.*;
import java.util.ArrayList;

public class Control {
    private GUI m_view;
    private Polynomial pol1, pol2;
    public Control(GUI view)
    {
        m_view  = view;
        m_view.addMulListener(new operationListener());
        m_view.addSubListener(new operationListener());
        m_view.addClrListener(new operationListener());
        m_view.addAddListener(new operationListener());
        m_view.addDivListener(new operationListener());
        m_view.addDerListener(new operationListener());
        m_view.addIntListener(new operationListener());
    }

    public ArrayList<Monomial> conversion(String ex)
    {
        String[] list1 = ex.split(" ");
        String saved = "+";
        String fin;
        ArrayList<Monomial> polynomial1 = new ArrayList<Monomial>();

        for (String elem: list1)
        {
            if (elem.equals("+") || elem.equals("-"))
                saved = elem;
            else
            {
                fin = saved + elem;
                int count = fin.split("x",-1).length-1;
                if (count <= 1){
                    Monomial m = new Monomial(saved + elem);
                    polynomial1.add(m);
                }
                else
                {
                    m_view.calcOutput.setText("Input error");
                    break;
                }
            }
        }
        return polynomial1;
    }

    public void method(){
        this.pol1 = new Polynomial(conversion(m_view.userInput.getText()));
        this.pol2 = new Polynomial(conversion(m_view.userInput2.getText()));
    }

    public int testFields(String s1, String s2)
    {
        if (s1.equals("") && s2.equals(""))
            return 1;
        else if (s1.equals(""))
            return 2;
        else if (s2.equals(""))
            return 3;
        else return 4;
    }

    class operationListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                method();
            }
            catch (NumberFormatException ex)
            {
                m_view.calcOutput.setText("Input error");
                return;
            }
            try {
                if (actionEvent.getSource() == m_view.multiplicationButton) {
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 3:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 4:
                            m_view.calcOutput.setText(pol1.mul(pol2).toString());
                            break;
                    }
                } else if (actionEvent.getSource() == m_view.subtractionButton)
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 3:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 4:
                            m_view.calcOutput.setText(pol1.sub(pol2).toString());
                            break;
                    }
                else if (actionEvent.getSource() == m_view.divisionButton)
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 3:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 4:
                            m_view.calcOutput.setText(pol1.div(pol2).toString());
                            break;
                    }
                else if (actionEvent.getSource() == m_view.additionButton)
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 3:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 4:
                            m_view.calcOutput.setText(pol1.add(pol2).toString());
                            break;
                    }
                else if (actionEvent.getSource() == m_view.integrationButton)
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: input error");
                            break;
                        case 3:
                            m_view.calcOutput.setText(pol1.integ().toString());
                            break;
                        case 4:
                            m_view.calcOutput.setText("Error: too many arguments");
                            break;
                    }
                else if (actionEvent.getSource() == m_view.derivativeButton)
                    switch (testFields(m_view.userInput.getText().toString(), m_view.userInput2.getText().toString())) {
                        case 1:
                            m_view.calcOutput.setText("Error: not enough arguments");
                            break;
                        case 2:
                            m_view.calcOutput.setText("Error: input error");
                            break;
                        case 3:
                            m_view.calcOutput.setText(pol1.der().toString());
                            break;
                        case 4:
                            m_view.calcOutput.setText("Error: too many arguments");
                            break;
                    }
                else if (actionEvent.getSource() == m_view.clearButton) {
                    System.out.println("Cleared!");
                    m_view.calcOutput.setText("");
                    m_view.userInput.setText("");
                    m_view.userInput2.setText("");
                }
            }
            catch (NullPointerException ex)
            {
                m_view.calcOutput.setText("Input error");
            }
        }
    }


}
