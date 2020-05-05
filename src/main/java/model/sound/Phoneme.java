package model.sound;

import javax.sound.sampled.AudioInputStream;

import model.Letter;

public class Phoneme implements Sound {
  Letter letter;
  AudioInputStream phonemeSound;

  public Phoneme(Letter letter, AudioInputStream phonemeSound) {
    this.letter = letter;
    this.phonemeSound = phonemeSound;
  }

  public AudioInputStream renderSound() {
    return phonemeSound;
  }
}
