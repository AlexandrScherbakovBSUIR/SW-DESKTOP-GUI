package edu.easysoft.game.tablet;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel{
    private int number = 0;
    private String name = "card name 0";
    private int value = 0;
    private ImageIcon imageIcon = new ImageIcon("./src/main/resources/cards/images/card_0.png","description of card 0");
    public Card(){
        //todo: make factory for creating many card instance
        this.setBackground(Color.getHSBColor(40,170,200));

        this.add(new JLabel(getImageIcon()));
        System.out.println(toString());


    }


    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", imageIcon=" + imageIcon.getDescription() +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
