package edu.easysoft.game.tablet;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel{
    int number = 0;
    String name = "card name 0";
    int value = 0;
    ImageIcon imageIcon = new ImageIcon("./src/main/resources/image/card/card_0.png","description of card 0");
    public Card(){
        //this.add(new JLabel(getImageIcon()));
        this.setBackground(Color.red);
        this.setSize(imageIcon.getIconWidth()+10,imageIcon.getIconHeight()+10);


        this.setVisible(true);

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
