public class Key {
    public int sound; // 도=1, 레=2, 미=3, 파=4, 솔=5, 라=6, 시=7
    public int octave; // 옥타브 피아노 왼->오 1~7
    public int color; // 0=White, 1=Black
    boolean press; // 0=안 누른거 , 1=누른거

    public Key(int sound, int octave, int color, boolean press) {
        this.sound = sound;
        this.octave = octave;
        this.color = color;
        this.press = press;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }
}
