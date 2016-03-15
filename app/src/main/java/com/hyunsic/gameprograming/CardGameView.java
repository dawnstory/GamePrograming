package com.hyunsic.gameprograming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by hyunsic on 3/9/16.
 */
public class CardGameView extends View{

    Bitmap m_backGroundImage, m_backSideImage;
    Bitmap m_Card_Red,m_Card_Blue,m_Card_Green;
    Card m_Shuffle[][];

    public CardGameView(Context context) {

        super(context);
        m_backGroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        m_backSideImage = BitmapFactory.decodeResource(getResources(),R.drawable.backside);
        m_Card_Red = BitmapFactory.decodeResource(getResources(),R.drawable.front_red);
        m_Card_Green = BitmapFactory.decodeResource(getResources(), R.drawable.front_green);
        m_Card_Blue = BitmapFactory.decodeResource(getResources(),R.drawable.front_blue);

        m_Shuffle = new Card[3][2];
        m_Shuffle[0][0] = new Card(Card.IMG_RED);
        SetCardShuffle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(m_backGroundImage,0,0,null);

        for(int y = 0; y < 2; y++){
            for(int x = 0; x < 3; x++){
                canvas.drawBitmap(m_backSideImage,35 + x * 90,150 + y * 130,null);
            }
        }


        for(int y = 0; y < 2; y++){
            for(int x = 0; x < 3; x++){
                if(m_Shuffle[x][y].m_Color==Card.IMG_RED)
                    canvas.drawBitmap(m_Card_Red,35+x*90, 150+y*130, null);
                else if (m_Shuffle[x][y].m_Color==Card.IMG_GREEN)
                    canvas.drawBitmap(m_Card_Green,35+x*90, 150+y*130, null);
                else if (m_Shuffle[x][y].m_Color==Card.IMG_BLUE)
                    canvas.drawBitmap(m_Card_Blue,35+x*90, 150+y*130, null);
            }
        }

    }

    public void SetCardShuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 2;i++){
            shuffled.add(new Card((Card.IMG_RED)));
            shuffled.add(new Card((Card.IMG_GREEN)));
            shuffled.add(new Card((Card.IMG_BLUE)));
        }

//        Card[] shuffled = {new Card(Card.IMG_BLUE),new Card(Card.IMG_BLUE),new Card(Card.IMG_RED),new Card(Card.IMG_RED),
//        new Card(Card.IMG_GREEN),new Card(Card.IMG_GREEN)};

//        int randomPlace = random.nextInt(6);
        for(int outter = 0; outter<2; outter++){
            for(int inner = 0; inner<3; inner++){
                int randomPlace = random.nextInt(shuffled.size());
                m_Shuffle[inner][outter] = shuffled.remove(randomPlace);
            }
        }
//        m_Shuffle[0][0] = new Card(Card.IMG_RED);
//        m_Shuffle[0][1] = new Card(Card.IMG_BLUE);
//        m_Shuffle[1][0] = new Card(Card.IMG_GREEN);
//        m_Shuffle[1][1] = new Card(Card.IMG_GREEN);
//        m_Shuffle[2][0] = new Card(Card.IMG_BLUE);
//        m_Shuffle[2][1] = new Card(Card.IMG_RED);
    }

}
