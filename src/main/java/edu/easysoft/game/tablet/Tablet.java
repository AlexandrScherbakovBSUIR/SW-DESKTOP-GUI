package edu.easysoft.game.tablet;

import edu.easysoft.game.tablet.Card;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Tablet  extends JPanel {
    List<Card> cardList = new ArrayList<Card>();
    public Tablet(){

        for (int i=0; i<6; i++){
            this.cardList.add(new Card());

        }
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
