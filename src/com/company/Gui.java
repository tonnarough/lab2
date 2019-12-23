package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JRadioButton radio1 = new JRadioButton("Formula 1",true);
    private JRadioButton radio2 = new JRadioButton("Formula 2",false);
    private JRadioButton radioX = new JRadioButton("X",true);
    private JRadioButton radioY = new JRadioButton("Y",false);
    private JRadioButton radioZ = new JRadioButton("Z",false);
    private JLabel label = new JLabel("Choose function: ");
    private JLabel image = new JLabel();
    private JLabel result = new JLabel("Result = ... ");
    private JLabel value = new JLabel("Enter ur values: ");
    private JTextField valueX = new JTextField("",3);
    private JTextField valueY = new JTextField("",3);
    private JTextField valueZ = new JTextField("",3);
    private JButton buttonmc = new JButton("MC");
    private JButton buttonm = new JButton("M+");
    private JButton buttoncalc = new JButton("Calculate");
    private Box mainbox = Box.createVerticalBox();
    private JPanel panel1 = new JPanel();
    private Box box = Box.createHorizontalBox();
    private ButtonGroup RB = new ButtonGroup();
    private JPanel panel2 = new JPanel();
    private Box box2 = Box.createHorizontalBox();
    private JPanel panel3 = new JPanel();
    private Box box3 = Box.createHorizontalBox();
    private ButtonGroup XYZ = new ButtonGroup();
    private JPanel panel4 = new JPanel();
    private Box box4 = Box.createHorizontalBox();

    public Gui () {
        super("Calculate functions");
        this.setBounds(300,150,600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // тут надпись и 2 радиокнопки для выбора формулы
        RB.add(radio1);
        RB.add(radio2);
        box.add(label);
        box.add(Box.createHorizontalStrut(10));
        box.add(radio1);
        box.add(Box.createHorizontalStrut(10));
        box.add(radio2);
        panel1.add(box);
        mainbox.add(panel1);

        // добавили формулу, чтобы она по дефолту была включена(при смене кнопок меняется)
        mainbox.add(image);
        image.setIcon(new ImageIcon("C:\\Users\\Anton\\IdeaProjects\\lababaaa2\\Formula1.png"));
        image.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mainbox.add(Box.createVerticalStrut(20));

        //добавили кнопки МС и М+
        box2.add(buttonmc);
        box2.add(Box.createHorizontalStrut(200));
        box2.add(buttonm);
        panel2.add(box2);
        mainbox.add(panel2);

        //тут кнопка для ввода значения
        XYZ.add(radioX);
        XYZ.add(radioY);
        XYZ.add(radioZ);
        box3.add(value);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(valueX);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(radioX);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(valueY);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(radioY);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(valueZ);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(radioZ);
        panel3.add(box3);
        mainbox.add(panel3);

        // а тут уже калькулируем и результат получаем
        box4.add(buttoncalc);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(result);
        panel4.add(box4);
        mainbox.add(panel4);


        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image.setIcon(new ImageIcon("C:\\Users\\Anton\\IdeaProjects\\lababaaa2\\Formula1.png"));
            }
        });

        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image.setIcon(new ImageIcon("C:\\Users\\Anton\\IdeaProjects\\lababaaa2\\Formula2.png"));
            }
        });

        buttoncalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double x = Double.parseDouble(valueX.getText());
                    Double y = Double.parseDouble(valueY.getText());
                    Double z = Double.parseDouble(valueZ.getText());
                    Double res;
                    if(radio1.isSelected()) {
                        CalculateMath calc = new CalculateMath();
                        res = calc.Calculate1(x, y, z);
                    }
                    else{
                        CalculateMath calc = new CalculateMath();
                        res = calc.Calculate2(x, y, z);
                    }
                    result.setText(res.toString());
                }
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Gui.this,"Error in the record format of a floating-point number", "Incorrect number format", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buttonmc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueX.setText("0");
                valueY.setText("0");
                valueZ.setText("0");
            }
        });

        buttonm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double x = Double.parseDouble(valueX.getText());
                Double y = Double.parseDouble(valueY.getText());
                Double z = Double.parseDouble(valueZ.getText());
                Double res = Double.parseDouble(result.getText());
                if(radioX.isSelected()) {
                    x += res;
                    valueX.setText(x.toString());
                }
                if(radioY.isSelected()) {
                    y += res;
                    valueY.setText(y.toString());
                }
                if(radioZ.isSelected()) {
                    z += res;
                    valueZ.setText(z.toString());
                }
            }
        });

        this.add(mainbox);
    }
}

