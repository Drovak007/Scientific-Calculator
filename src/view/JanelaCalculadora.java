package view;

import model.Calculos;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JanelaCalculadora extends JFrame {
    public JanelaCalculadora() {
        // Window Properties
        super("Calculator");
        setBounds(250, 250, 0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Content Pane
        JPanel cpCalculator = new JPanel();
        cpCalculator.setLayout(new BorderLayout(5, 5));
        setContentPane(cpCalculator);

        // Components
        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        JMenuItem miHideShowScientific = new JMenuItem("Hide/Show Scientific Panel");
        viewMenu.add(miHideShowScientific);

        JMenuItem miSobre = new JMenuItem("Calculator made by João Manoel Sobral da Costa");
        helpMenu.add(miSobre);

        JMenuItem miHideShowHistLog = new JMenuItem("History Log");
        viewMenu.add(miHideShowHistLog);

        JTextField tfInput = new JTextField();
        tfInput.setEditable(false);
        tfInput.setBackground(Color.WHITE);
        cpCalculator.add(tfInput, BorderLayout.NORTH);

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        cpCalculator.add(panel1, BorderLayout.CENTER);

        JPanel panelScientific = new JPanel();
        panelScientific.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(panelScientific, gbc);
        panelScientific.setBorder(BorderFactory.createTitledBorder("Scientific"));

        JButton btSqrt = new JButton();
        btSqrt.setText("Sqrt");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btSqrt, gbc);

        JButton btInverse = new JButton();
        btInverse.setText("1/x");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btInverse, gbc);

        JButton btPercentage = new JButton();
        btPercentage.setText("%");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btPercentage, gbc);

        JButton btPow3 = new JButton();
        btPow3.setText("x^3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btPow3, gbc);

        JButton btPow2 = new JButton();
        btPow2.setText("x^2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btPow2, gbc);

        JButton btSin = new JButton();
        btSin.setText("sin");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btSin, gbc);

        JButton btCos = new JButton();
        btCos.setText("Cos");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btCos, gbc);

        JButton btExp = new JButton();
        btExp.setText("Exp");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btExp, gbc);

        JButton btLogN = new JButton();
        btLogN.setText("ln");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btLogN, gbc);

        JButton btTan = new JButton();
        btTan.setText("Tan");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btTan, gbc);

        JButton btFactorial = new JButton();
        btFactorial.setText("n!");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btFactorial, gbc);

        JButton btSec = new JButton();
        btSec.setText("Sec");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelScientific.add(btSec, gbc);

        JPanel panelStandard = new JPanel();
        panelStandard.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel1.add(panelStandard, gbc);
        panelStandard.setBorder(BorderFactory.createTitledBorder("Standard"));

        JButton bt7 = new JButton();
        bt7.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt7, gbc);

        JButton bt4 = new JButton();
        bt4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt4, gbc);

        JButton bt8 = new JButton();
        bt8.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt8, gbc);

        JButton bt5 = new JButton();
        bt5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt5, gbc);

        JButton bt1 = new JButton();
        bt1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt1, gbc);

        JButton bt0 = new JButton();
        bt0.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt0, gbc);

        JButton bt2 = new JButton();
        bt2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt2, gbc);

        JButton btPeriod = new JButton();
        btPeriod.setText(".");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btPeriod, gbc);

        JButton bt9 = new JButton();
        bt9.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt9, gbc);

        JButton btDivision = new JButton();
        btDivision.setText("/");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btDivision, gbc);

        JButton btMultiplication = new JButton();
        btMultiplication.setText("*");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btMultiplication, gbc);

        JButton btSubtraction = new JButton();
        btSubtraction.setText("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btSubtraction, gbc);

        JButton btAddition = new JButton();
        btAddition.setText("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btAddition, gbc);

        JButton bt6 = new JButton();
        bt6.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt6, gbc);

        JButton bt3 = new JButton();
        bt3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(bt3, gbc);

        JButton btEqual = new JButton();
        btEqual.setText("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btEqual, gbc);

        JButton btBackspace = new JButton();
        btBackspace.setText("<-");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btBackspace, gbc);

        JButton btLeftParenthesis = new JButton();
        btLeftParenthesis.setText("(");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btLeftParenthesis, gbc);

        JButton btRightParenthesis = new JButton();
        btRightParenthesis.setText(")");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btRightParenthesis, gbc);

        JButton btPower = new JButton();
        btPower.setText("^");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btPower, gbc);

        JButton btClear = new JButton();
        btClear.setText("Clear");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelStandard.add(btClear, gbc);

        JTextArea taHistLog = new JTextArea("History Log",0, 0);
        taHistLog.setEditable(false);
        taHistLog.setLineWrap(true);
        taHistLog.setWrapStyleWord(true);
        taHistLog.setFocusable(false);
        taHistLog.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(taHistLog);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setVisible(false);
        cpCalculator.add(scrollPane, BorderLayout.EAST);


        // Listeners for menu bar
        miHideShowScientific.addActionListener(e -> panelScientific.setVisible(!panelScientific.isVisible()));
        miHideShowHistLog.addActionListener(e -> {
            taHistLog.setVisible(!taHistLog.isVisible());
            scrollPane.setVisible(!scrollPane.isVisible());
            this.pack();
        });

        // Initialize the calculator
        Calculos calc = new Calculos();

        // Listeners for standard panel
        bt0.addActionListener(e -> tfInput.setText(tfInput.getText() + "0"));
        bt1.addActionListener(e -> tfInput.setText(tfInput.getText() + "1"));
        bt2.addActionListener(e -> tfInput.setText(tfInput.getText() + "2"));
        bt3.addActionListener(e -> tfInput.setText(tfInput.getText() + "3"));
        bt4.addActionListener(e -> tfInput.setText(tfInput.getText() + "4"));
        bt5.addActionListener(e -> tfInput.setText(tfInput.getText() + "5"));
        bt6.addActionListener(e -> tfInput.setText(tfInput.getText() + "6"));
        bt7.addActionListener(e -> tfInput.setText(tfInput.getText() + "7"));
        bt8.addActionListener(e -> tfInput.setText(tfInput.getText() + "8"));
        bt9.addActionListener(e -> tfInput.setText(tfInput.getText() + "9"));
        btPower.addActionListener(e -> tfInput.setText(tfInput.getText() + "^"));
        btPeriod.addActionListener(e -> tfInput.setText(tfInput.getText() + "."));
        btAddition.addActionListener(e -> tfInput.setText(tfInput.getText() + "+"));
        btDivision.addActionListener(e -> tfInput.setText(tfInput.getText() + "/"));
        btSubtraction.addActionListener(e -> tfInput.setText(tfInput.getText() + "-"));
        btMultiplication.addActionListener(e -> tfInput.setText(tfInput.getText() + "*"));
        btLeftParenthesis.addActionListener(e -> tfInput.setText(tfInput.getText() + "("));
        btRightParenthesis.addActionListener(e -> tfInput.setText(tfInput.getText() + ")"));
        btBackspace.addActionListener(e -> {
            String text = tfInput.getText();
            if (text.length() > 0) {
                tfInput.setText(text.substring(0, text.length() - 1));
            }
        });
        btClear.addActionListener(e -> tfInput.setText(""));
        btEqual.addActionListener(e-> {
            String result = calc.dijkstraShuntingYard(tfInput.getText());
            if (result == null) {
                JOptionPane.showMessageDialog(null, "Mismatched Parenthesis!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                taHistLog.append("\n\n" + tfInput.getText() + " = " + result);
                tfInput.setText(result);
            }
        });

        // Listeners for scientific panel
        btSqrt.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.sqrt(new BigDecimal(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btSin.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.sin(tfInput.getText())));
            taHistLog.append(tfInput.getText());
        });
        btCos.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.cos(tfInput.getText())));
            taHistLog.append(tfInput.getText());
        });
        btTan.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.tan(tfInput.getText())));
            taHistLog.append(tfInput.getText());
        });
        btSec.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.sec(tfInput.getText())));
            taHistLog.append(tfInput.getText());
        });
        btLogN.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.logn(Double.parseDouble(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btExp.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.exp(Double.parseDouble(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btPow2.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.power2(new BigDecimal(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btPow3.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.power3(new BigDecimal(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btInverse.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.inverse(new BigDecimal(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
        btFactorial.addActionListener(e -> {
            String input = tfInput.getText();
            if (input.contains(".") || input.contains("-")) {
                JOptionPane.showMessageDialog(null, "Factorial can only be applied to non negative integers!", "Error", JOptionPane.ERROR_MESSAGE);
                taHistLog.append("\n\n" + tfInput.getText() + " = " + "Factorial can only be applied to non negative integers!");
            } else {
                taHistLog.append("\n\n" + tfInput.getText() + " = ");
                tfInput.setText(String.valueOf(calc.factorial(new BigInteger(tfInput.getText()))));
                taHistLog.append(tfInput.getText());
            }
        });
        btPercentage.addActionListener(e -> {
            taHistLog.append("\n\n" + tfInput.getText() + " = ");
            tfInput.setText(String.valueOf(calc.percentage(new BigDecimal(tfInput.getText()))));
            taHistLog.append(tfInput.getText());
        });
    }
}
