package com.github.colinwake.binarytodecimal;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.math.BigInteger;

public class Window {
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JLabel author;
    private JPanel panel;

    Window() {


        textField1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    BigInteger decimal = new BigInteger(textField1.getText(), 2);

                    System.out.println(decimal);

                    textField2.setText(decimal.toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Non-binary character typed, assuming they will remove...");
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (textField1.getText().length() > 0) {
                    try {

                        BigInteger decimal = new BigInteger(textField1.getText(), 2);

                        System.out.println(decimal);

                        textField2.setText(decimal.toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Some invalid character for " + textField1.getText());
                    }
                } else {
                    textField2.setText("Enter binary...");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // unneeded
            }
        });

    }

    JPanel getPanel() {
        return panel;
    }

}
