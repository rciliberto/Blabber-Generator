package model.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Letter;

public class Phoneme extends AbstractSound {
  private final Letter letter;
  private final String phonemeFile;

  public Phoneme(Letter letter, String phonemeFile) {
    this.letter = letter;
    this.phonemeFile = phonemeFile;
  }

  @Override
  public Sound appendSound(Sound sound) {
    return new CombinationSound(combineSounds(this, sound));
  }

  @Override
  public AudioInputStream renderSound() {
    try {
      return AudioSystem.getAudioInputStream(new File(phonemeFile));
    } catch (UnsupportedAudioFileException | IOException e) {
      throw new IllegalStateException("Failed to render sound.");
    }
  }

  @Override
  public String toString() {
    return letter.toString();
  }
}
