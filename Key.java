package com.sogang.capstone2.iruma;

import android.graphics.RectF;

public class Key {
    public int sound; // 14개씩으로 끊어서 하도록 정함
    // 도=1, 레=2, 미=3, 파=4, 솔=5, 라=6, 시=7 다음 옥타브엔 도 = 8 부터 시 = 14
     // 옥타브 피아노 왼->오 1~7
    public int color; // 0=White, 1=Black
    public RectF rect;
    Boolean down; // 0=안 누른거 , 1=누른거

    public Key(int sound, int color, RectF rect) {
        this.sound = sound;
        this.color = color;
        this.rect = rect;
    }


    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    /*public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }*/

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Boolean getPress() {
        return down;
    }

    public void setPress(Boolean press) {
        this.down = press;
    }
    public RectF getRect() {
        return rect;
    }

    public void setRect(RectF rect) {
        this.rect = rect;
    }
}
