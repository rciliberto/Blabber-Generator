package model.voice;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import model.Letter;

public class RobVoice extends PersonVoice {

  private static HashMap<Letter, AudioInputStream> constructPhonemes() {
    HashMap<Letter, AudioInputStream> phonemes = new HashMap<>();

    for (Letter letter : Letter.values()) {
      File soundFile;

      try {
        soundFile = new File(String.format("src/main/resources/RobVoice/%s.wav", letter.toString()));
        phonemes.put(letter, AudioSystem.getAudioInputStream(soundFile));
      } catch (Exception e){
        e.printStackTrace();
        System.exit(1);
      }
    }

    return phonemes;
  }

  public RobVoice() {
    super(constructPhonemes());
  }

  RobVoice(HashMap<Letter, AudioInputStream> phonemes) {
    super(phonemes);
  }
}
