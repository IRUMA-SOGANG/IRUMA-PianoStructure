package com.sogang.capstone2.iruma;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.util.SparseArray;
import android.media.AudioTrack;

import java.io.InputStream;
// '수정' 검색하고 밑부분이 수정된 함수


public class AudioSoundPlayer {
    private static SparseArray<PlayThread> threadMap = null;
    private static Context context;
    private static final SparseArray<String> SOUND_MAP = new SparseArray<>();
    public static final int MAX_VOLUME = 100, CURRENT_VOLUME = 90;
    static {
        // white keys sounds
        SOUND_MAP.put(1, "note_do");
        SOUND_MAP.put(2, "note_re");
        SOUND_MAP.put(3, "note_mi");
        SOUND_MAP.put(4, "note_fa");
        SOUND_MAP.put(5, "note_sol");
        SOUND_MAP.put(6, "note_la");
        SOUND_MAP.put(7, "note_si");
        SOUND_MAP.put(8, "second_do");
        SOUND_MAP.put(9, "second_re");
        SOUND_MAP.put(10, "second_mi");
        SOUND_MAP.put(11, "second_fa");
        SOUND_MAP.put(12, "second_sol");
        SOUND_MAP.put(13, "second_la");
        SOUND_MAP.put(14, "second_si");
        // black keys sounds
        SOUND_MAP.put(15, "do_dies");
        SOUND_MAP.put(16, "re_dies");
        SOUND_MAP.put(17, "fa_dies");
        SOUND_MAP.put(18, "sol_dies");
        SOUND_MAP.put(19, "la_dies");
        SOUND_MAP.put(20, "second_dies_do");
        SOUND_MAP.put(21, "second_dies_re");
        SOUND_MAP.put(22, "second_dies_fa");
        SOUND_MAP.put(23, "second_dies_sol");
        SOUND_MAP.put(24, "second_dies_la");
    }
    public AudioSoundPlayer(Context context){
        this.context = context;
        threadMap = new SparseArray<>();
    }

    /*public void playNote(int note) {
        if (!isNotePlaying(note)) {
            PlayThread thread = new PlayThread(note);
            thread.start();
            threadMap.put(note, thread);
        }
    }*/

    //수정
    public static void playNote(int sound, int octave){
        if ( !isNotePlaying(sound, octave)){
            PlayThread thread = new PlayThread(sound,octave);
            thread.start();
            threadMap.put(sound+octave-1, thread);
        }
    }

    /*public void stopNote(int note) {
        PlayThread thread = threadMap.get(note);

        if (thread != null) {
            threadMap.remove(note);
        }
    }*/
    //수정
    public void stopNote (int sound, int octave){
        PlayThread thread = threadMap.get(sound+octave-1);

        if (thread != null)
        {
            threadMap.remove((sound+octave-1));
        }
    }

   /* public boolean isNotePlaying(int note) {
        return threadMap.get(note) != null;
    }*/
   //수정
    public static boolean isNotePlaying(int sound, int octave){
        return threadMap.get((sound+octave)-1) != null;
    }

    private static class PlayThread extends Thread{

        //int note;
        //수정
        int sound;
        int octave;
        AudioTrack audioTrack;

        /*public PlayThread(int note){
            this.note = note;
        }*/
        // 수정
        public PlayThread(int sound, int octave){
            this.sound = sound;
            this.octave = octave;
        }

        public void run(){
            try{
                //String path = SOUND_MAP.get(note) + ".wav";
                //수정
                String path = SOUND_MAP.get(sound+octave-1) + ".wav";
                ///////

                AssetManager assetManager = context.getAssets();
                AssetFileDescriptor ad = assetManager.openFd(path);
                long fileSize = ad.getLength();
                int bufferSize = 4096;
                byte[] buffer = new byte[bufferSize];

                audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                        AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM);

                float logVolume = (float) (1 - (Math.log(MAX_VOLUME - CURRENT_VOLUME) / Math.log(MAX_VOLUME)));
                audioTrack.setStereoVolume(logVolume, logVolume);

                audioTrack.play();
                InputStream audioStream = null;
                int headerOffset = 0x2C;
                long bytesWritten = 0;
                int byteRead = 0;

                audioStream = assetManager.open(path);
                audioStream.read(buffer, 0, headerOffset);
                while(bytesWritten < fileSize - headerOffset){
                    byteRead = audioStream.read(buffer, 0, bufferSize);
                    bytesWritten += audioTrack.write(buffer, 0, byteRead);
                }

                audioTrack.stop();
                audioTrack.release();

            }catch (Exception e){

            }finally{
                if(audioTrack != null){
                    audioTrack.release();
                }
            }
        }
    }
}
