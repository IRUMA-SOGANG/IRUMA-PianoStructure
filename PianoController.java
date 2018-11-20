 // 소리 이외의 피아노 부분
// controller 부분에서 소리 부분 다룰 수 있도록 만든다.
package com.sogang.capstone2.iruma;


 public class PianoController {
     // piano 옥타브 몇개를 생성할 것인지 그 수만 parameter로 받아 생성
    public void setOctave (int octaveNum) {
        // octaveNum = 옥타브 몇 개 생성할 것인지?
        for ( int i = 1 ; i <= octaveNum ; i++ ) {
            new Key(1, i, false, false); //도
            new Key(1, i, true, false); //도#
            new Key(2, i, false, false); //레
            new Key(2, i, true, false); //레#
            new Key(3, i, false, false); //미
            new Key(4, i, false, false); // 파
            new Key(4, i, true, false); // 파#
            new Key(5, i, false, false); //솔
            new Key(5, i, true, false); //솔#
            new Key(6, i, false, false); //라
            new Key(6, i, true, false); //라#
            new Key(7, i, false, false); //시
        }
    }
    // 사용자가 누르면 View에서 isDown호출
    public void isDown (Key keydown) {
        // 눌렀을 때
        keydown.down = true;
        // 소리 내기
        AudioSoundPlayer.playNote(keydown.sound, keydown.octave);

    }
    // 사용자가 떼면 View에서 isUp호출
    public void isUp (Key keyup){
        // 손가락 뗐을 때
        keyup.down = false;
        // 소리 끄기
        AudioSoundPlayer.stopNote(keyup.sound, keyup.octave);
    }

}
