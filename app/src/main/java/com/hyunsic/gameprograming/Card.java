package com.hyunsic.gameprograming;


/**
 * Created by hyunsic on 3/9/16.
 */


public class Card {

    public static final int CARD_SHOW = 0;
    public static final int CARD_CLOSE = 1;
    public static final int CARD_PLAYEROPEN = 2;
    public static final int CARD_MATCHED = 3;

    public static final int IMG_RED = 1;
    public static final int IMG_GREEN = 2;
    public static final int IMG_BLUE = 3;

    public static final int IMG_REDS = 4;

    public int m_state;
    public int m_Color;

    public Card(int Color) {
        m_state = CARD_SHOW;
        m_Color = Color;
    }
}
