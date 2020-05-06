package model.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Letter;

public class Phoneme extends AbstractSound {
  private final Letter letter;
  private final AudioInputStream phonemeSound;

  public Phoneme(Letter letter, AudioInputStream phonemeSound) {
    this.letter = letter;
    this.phonemeSound = phonemeSound;
  }

  @Override
  public Sound appendSound(Sound sound) {
    return new CombinationSound(combineSounds(this, sound));
  }

  @Override
  public AudioInputStream renderSound() {
    return new AudioInputStream(this.phonemeSound, this.phonemeSound.getFormat(),
            this.phonemeSound.getFrameLength());
  }

  @Override
  public String toString() {
    return letter.toString();
  }
}
