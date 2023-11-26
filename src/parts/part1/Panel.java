package parts.part1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame {
    JRadioButton button1, button2, button3, button4;
    JTextField text1, text2;
    JTextArea text3;
    ButtonGroup bg;

    Panel() {
        super("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setBackground(Color.darkGray);

        button1 = new JRadioButton("Сложение");
        button2 = new JRadioButton("Вычетание");
        button3 = new JRadioButton("Умножение");
        button4 = new JRadioButton("Деление");

        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextArea();

        bg = new ButtonGroup();
        bg.add(button1);
        bg.add(button2);
        bg.add(button3);
        bg.add(button4);

        setLayout(null);
        button1.setSize(100, 50);
        button1.setLocation(280, 50);

        button2.setSize(100, 50);
        button2.setLocation(280, 100);

        button3.setSize(100, 50);
        button3.setLocation(280, 150);

        button4.setSize(100, 50);
        button4.setLocation(280, 200);

        text1.setSize(200, 50);
        text1.setLocation(50, 80);

        text2.setSize(200, 50);
        text2.setLocation(50, 140);

        text3.setSize(300, 50);
        text3.setLocation(50, 250);

        add(text1);
        add(text2);
        add(text3);

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        button1.addActionListener(new ButtonActionLisener());
        button2.addActionListener(new ButtonActionLisener());
        button3.addActionListener(new ButtonActionLisener());
        button4.addActionListener(new ButtonActionLisener());
    }

    public class ButtonActionLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            {
                text3.setText(null);
                if (e.getSource() == button1)
                    text3.append(finalMathFunc('+'));
                if (e.getSource() == button2)
                    text3.append(finalMathFunc('-'));
                if (e.getSource() == button3)
                    text3.append(finalMathFunc('*'));
                if (e.getSource() == button4)
                    text3.append(finalMathFunc('/'));
            }
        }
    }

    public String finalMathFunc(char n){
    try {
        float x = Float.parseFloat(text1.getText());
        float y = Float.parseFloat(text2.getText());
            switch(n){
                case '+':
                    return String.valueOf(x + y);
                case '-':
                    return String.valueOf(x - y);
                case '*':
                    return String.valueOf(x * y);
                case '/':
                    if(y == 0){
                        return "Воробушек, это 0...";
                    }
                    return String.valueOf(x / y);
            }
        } catch(NumberFormatException e){
            return "Ошибка математического сигмента";
        }
        return null;
    }
}