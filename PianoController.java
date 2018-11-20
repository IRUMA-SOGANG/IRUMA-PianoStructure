package com.sogang.capstone2.iruma;
import com.sogang.capstone2.iruma.Key;

import java.util.Scanner;

public class PianoController {
    public void setUserOctave (Key startKey, Key endKey)
    {
        // 받은 첫음과 끝음에 새로운 음을 입력받아 새로운 범위를 설정한다.
        
        int startNote = 0 ;
        int endNote = 0 ;

        // 사용자로부터 입력을 받는다

        Scanner scan = new Scanner(System.in);
        System.out.println("새로운 범위를 선택해주세요.");

        System.out.println("시작할 음을 입력해주세요.");
        startNote = scan.nextInt();
        System.out.println(startNote);

        System.out.println("마지막 음을 입력해주세요.");
        endNote = scan.nextInt();
        System.out.println(endNote);

        scan.close();

        // 받은 입력을 데이터를 적용
        startKey.setSound(startNote); // 설정 범위 첫 음 받아오기
        endKey.setSound(endNote); // 설정 범위 끝 음 받아오기
    }
}
