package com.hyunsic.gameprograming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

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
        //과제 수정부분 카드가 매번 실행때마다 바뀌게끔
        m_Shuffle[0][0] = new Card(Card.IMG_RED);
        m_Shuffle[0][1] = new Card(Card.IMG_BLUE);
        m_Shuffle[1][0] = new Card(Card.IMG_GREEN);
        m_Shuffle[1][1] = new Card(Card.IMG_GREEN);
        m_Shuffle[2][0] = new Card(Card.IMG_BLUE);
        m_Shuffle[2][1] = new Card(Card.IMG_RED);
    }

}
