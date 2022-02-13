package com.logicmojo.service;

interface MediaPlayer {
    public abstract void play(String audioType, String fileName);
}

class AudioPlayer implements MediaPlayer {
    MediaPlayer adapter;
    @Override
    public void play(String audioType, String fileName) {
        adapter = new Adapter(audioType);
        adapter.play(audioType, fileName);
    }
}

class Adapter implements MediaPlayer {
    LatestMediaPlayer latestMediaPlayer;

    public Adapter(String mediaType) {
        if(mediaType.equalsIgnoreCase("VLC")) {
            latestMediaPlayer = new VLC();
        }
        else if (mediaType.equalsIgnoreCase("MP4")) {
            latestMediaPlayer = new MP4();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        latestMediaPlayer.play(fileName);
    }
}

interface LatestMediaPlayer {
    public void play(String fileName);
}

class VLC implements LatestMediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing VLC file");
    }
}

class MP4 implements LatestMediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP4 file");
    }
}

public class AdapterDesign {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp4", "NovemberRain.mp4");
        audioPlayer.play("vlc", "HotelCalifornia.mp4");
    }
}
