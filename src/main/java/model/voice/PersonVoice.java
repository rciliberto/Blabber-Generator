package model.voice;

import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;

import model.Letter;
import model.sound.Phoneme;

public abstract class PersonVoice implements Voice {
  HashMap<Letter, Phoneme> phonemes;

  public PersonVoice(HashMap<Letter, AudioInputStream> phonemes) {
    this.phonemes = new HashMap<>();
    for (Letter letter : phonemes.keySet()) {
      AudioInputStream sound = phonemes.get(letter);
      this.phonemes.put(letter, new Phoneme(letter, sound));
    }
  }

  public Phoneme getPhonemeOf(Letter letter) {
    return this.phonemes.get(letter);
  }
}
