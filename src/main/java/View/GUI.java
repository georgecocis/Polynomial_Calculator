package View;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame {

    public JTextField userInput = new JTextField(10);
    public JTextField userInput2 = new JTextField(10);
    public JTextField calcOutput = new JTextField(20);
    public JButton multiplicationButton = new JButton("Multiply");
    public JButton additionButton = new JButton("Add");
    public JButton subtractionButton = new JButton("Subtract");
    public JButton divisionButton = new JButton("Divide");
    public JButton derivativeButton = new JButton("Derivative");
    public JButton integrationButton = new JButton("Integrate");
    public JButton clearButton = new JButton("Clear");

    public GUI() {
        calcOutput.setEditable(false);
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("First Polynomial"));
        content.add(userInput);
        content.add(new JLabel("Second Polynomial"));
        content.add(userInput2);
        content.add(multiplicationButton);
        content.add(additionButton);
        content.add(subtractionButton);
        content.add(divisionButton);
        content.add(derivativeButton);
        content.add(integrationButton);
        content.add(new JLabel("Total"));
        content.add(calcOutput);
        content.add(clearButton);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addMulListener(ActionListener mul_lis) {
        multiplicationButton.addActionListener(mul_lis);
    }
    public void addSubListener(ActionListener sub_lis){
        subtractionButton.addActionListener(sub_lis);
    }
    public void addAddListener(ActionListener add_lis){
        additionButton.addActionListener(add_lis);
    }
    public void addDivListener(ActionListener div_lis){
        divisionButton.addActionListener(div_lis);
    }
    public void addDerListener(ActionListener der_lis){
        derivativeButton.addActionListener(der_lis);
    }
    public void addIntListener(ActionListener int_lis){
        integrationButton.addActionListener(int_lis);
    }
    public void addClrListener(ActionListener clr_lis){
        clearButton.addActionListener(clr_lis);
    }

    public JButton getAddition() {return additionButton; }
    public JButton getSubtraction() {return subtractionButton; }
    public JButton getMultiplication() {return multiplicationButton; }
    public JButton getDivision() {return divisionButton; }
    public JButton getIntegration() {return integrationButton; }
    public JButton getDerivative() {return derivativeButton; }
    public JTextField getAnswer() {return calcOutput;}
}
