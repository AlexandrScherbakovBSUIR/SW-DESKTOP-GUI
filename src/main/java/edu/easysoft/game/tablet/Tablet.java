package edu.easysoft.game.tablet;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//todo rework it with dialog window
public class Tablet  extends JPanel {
    List<Card> cardList = new ArrayList<Card>();
    public Tablet(){
        fillCardList(6);
        System.out.println("constructor tablet: "+this.getComponentCount());
    }

    private void fillCardList(int count) {
        Card card = null;

        for (int i=0; i<count; i++){
            card = new Card();
            this.add(card);
            this.cardList.add(card);
        }
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
