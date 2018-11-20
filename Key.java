package com.sogang.capstone2.iruma;
import android.graphics.RectF;

public class Key {
    public int sound; // 1~7 도 ~ 시
    public int octave; // 옥타브
    Boolean die = false; // true: white key, false: black key
    Boolean down = false; // true: 누른거 , false: 안누른거


    public Key(int sound, int octave, Boolean die, Boolean down) {
        this.sound = sound;
        this.octave = octave;
        this.die = die;
        this.down = down;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public Boolean getDie() {
        return die;
    }

    public void setDie(Boolean die) {
        this.die = die;
    }

    public Boolean getDown() {
        return down;
    }

    public void setDown(Boolean down) {
        this.down = down;
    }
}
