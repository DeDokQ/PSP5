package parts.part2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;

public class Tur extends JFrame{
    JList list;
    JTextField text1, text2;
    JRadioButton button1, button2, button3;
    JComboBox box_1, box_2, box_3;
    JLabel l1, l2, l3, l4, l5;
    JTextArea text3, text4;
    ButtonGroup bg;
    Object boxA, boxB, boxC;
    JButton btn;

    String[] myList = {"Тур база отдыха немецкий генштаб", "Тур в один конец в Гарнизон", "Быково", "Тур к Путину", "Тур по ...", "Я не придумал"};
    String[] box1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] box2 = {"января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября0","декабря"};
    String[] box3 = {"2024","2025","2026","2027"};

    Tur(){
        super("Я заплачу");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);

        list = new JList(myList);
        text1 = new JTextField();

        button1 = new JRadioButton("Наличными");
        button2 = new JRadioButton("Картой");
        button3 = new JRadioButton("Подарочный билет");
        text2 = new JTextField();
        text3 = new JTextArea();
        text4 = new JTextArea();

        box_1 = new JComboBox(box1);
        box_2 = new JComboBox(box2);
        box_3 = new JComboBox<Object>(box3);

        l1 = new JLabel("Выберите тур");
        l2 = new JLabel("Способо оплаты (временно только на месте / в офицес)");
        l3 = new JLabel("Дата тура");
        l4 = new JLabel("Цена тура");
        l5 = new JLabel("Ваше ФИО");

        btn = new JButton("Забронировать");

        bg = new ButtonGroup();

        list.setSize(150, 110);
        list.setLocation(50,70);

        text1.setSize(300, 35);
        text1.setLocation(400,70);

        button1.setSize(200, 30);
        button1.setLocation(50,260);

        button2.setSize(200, 30);
        button2.setLocation(50,290);

        button3.setSize(200, 30);
        button3.setLocation(50,320);

        btn.setBounds(290, 610, 140, 25);

        text2.setSize(300, 35);
        text2.setLocation(400,260);

        text3.setSize(80, 40);
        text3.setLocation(320, 550);

        text4.setSize(300, 25);
        text4.setLocation(400, 400);

        box_1.setSize(70,25);
        box_1.setLocation(50,400);

        box_2.setSize(70, 25);
        box_2.setLocation(150, 400);

        box_3.setSize(70, 25);
        box_3.setLocation(250, 400);

        l1.setSize(200,25);
        l1.setLocation(50, 30);

        l2.setSize(400, 25);
        l2.setLocation(50, 230);

        l3.setSize(200, 25);
        l3.setLocation(50, 370);

        l4.setSize(200, 25);
        l4.setLocation(330, 520);

        l5.setSize(100, 25);
        l5.setLocation(400, 380);

        bg.add(button1);
        bg.add(button2);
        bg.add(button3);

        add(text1);
        add(text2);
        add(text3);
        add(text4);

        add(button1);
        add(button2);
        add(button3);
        add(btn);

        add(box_1);
        add(box_2);
        add(box_3);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);

        add(list);

        list.addMouseListener(new ButtonActionLisener());

        button1.addActionListener(new ButtonActionLisener());
        button2.addActionListener(new ButtonActionLisener());
        button3.addActionListener(new ButtonActionLisener());

        btn.addActionListener(al);

        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());

    }

    public class ButtonActionLisener implements MouseListener, ActionListener{
        //  Если пользователь нажал и отпустил одну из кнопок, вызывается метод mouseClicked.
        public void mouseClicked(MouseEvent e) {
            list =  (JList) e.getSource();
            Object text =  list.getSelectedValue();
            text1.setText((String)text);

            lastFunc(list.getSelectedIndex());

        }
        // mouseEntered - данный метод будет вызываться системой у слушателя каждый раз, когда курсор мыши будет оказываться над компонентом.
        public void mouseEntered(MouseEvent e) {
        }
        // mouseExited – данный метод срабатывает, когда убираем курсор мыши с компонента.
        public void mouseExited(MouseEvent e) {
        }
        // Навели на компонент, зажали кнопку — система вызвала mousePressed.
        public void mousePressed(MouseEvent e) {
        }
        // Отпускаем кнопку — система вызвала mouseReleased.
        public void mouseReleased(MouseEvent e) {
        }
        public void actionPerformed(ActionEvent e) {
            {
                if(e.getSource() == button1)
                    text2.setText("Оплата будет осуществлена наличными");
                if(e.getSource() == button2)
                    text2.setText("Оплата будет осуществлена картой");
                if(e.getSource() == button3)
                    text2.setText("Тур является подарочным, платить не нужно");
            }
        }
    }

    public class BoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == box_1){
                boxA = box_1.getSelectedItem();
                System.out.println(boxA);
            }
            if(e.getSource() == box_2){
                boxB = box_2.getSelectedItem();
                System.out.println(boxB);
            }
            if(e.getSource() == box_3){
                boxC = box_3.getSelectedItem();
                System.out.println(boxC);
            }
        }
    }

    ActionListener al = new ActionListener() { //событие на нажатие кнопки
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(boxA == null || boxA == null || boxA == null || text1.getText().equals("") || text4.getText().equals("")){
                System.out.println("Вам нужно выбрать тур и дату, а также указать Ваше ФИО!!!!");
            }else{
                String temp = "Путёвка: " + text1.getText() + "| Способ оплаты: " + text2.getText() + "| Дата: " + boxA + " " + boxB + " " + boxC + "| ФИО: " + text4.getText() + "| Цена: " + text3.getText();
                System.out.println(temp);

                try(FileWriter writer = new FileWriter("notes3.txt", true))
                {
                    writer.write(temp + "\n");
                    writer.flush();
                } catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
//              System.out.println(text1.getText() + " " + text2.getText() + " " + boxA + " " + boxB + " " + boxC + " " + text3.getText());
            }
        }
    };

    public void lastFunc(int x){
        text3.setText(null);
        switch(x){
            case 0:
                text3.append("200"); break;
            case 1:
                text3.append("300"); break;
            case 2:
                text3.append("170"); break;
            case 3:
                text3.append("320"); break;
            case 4:
                text3.append("90"); break;
            case 5:
                text3.append("800"); break;
        }
    }

//    public int lastFuncHelper(int x){
//        switch (boxC){
//
//        }
//    }

}
