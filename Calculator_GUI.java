package com.mycompany.calculator_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_GUI {

    private JFrame frame;
    private JTextField textField;
    private String currentInput = "";
    private double result = 0;
    private String operator = "";
    
    public Calculator_GUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        frame.add(panel, BorderLayout.CENTER);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 25));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Clear the input field
            if (command.equals("C")) {
                currentInput = "";
                result = 0;
                operator = "";
                textField.setText("");
            } 
            // Equals button
            else if (command.equals("=")) {
                try {
                    double number = Double.parseDouble(currentInput);
                    switch (operator) {
                        case "+":
                            result += number;
                            break;
                        case "-":
                            result -= number;
                            break;
                        case "*":
                            result *= number;
                            break;
                        case "/":
                            if (number != 0) {
                                result /= number;
                            } else {
                                textField.setText("Error");
                                return;
                            }
                            break;
                    }
                    currentInput = String.valueOf(result);
                    textField.setText(currentInput);
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
            } 
            // Arithmetic operations
            else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if (!currentInput.isEmpty()) {
                    result = Double.parseDouble(currentInput);
                    operator = command;
                    currentInput = "";
                }
            } 
            // Numbers
            else {
                currentInput += command;
                textField.setText(currentInput);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator_GUI();
            }
        });
    }
}

