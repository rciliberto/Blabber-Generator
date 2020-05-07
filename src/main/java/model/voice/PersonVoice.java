package model.voice;

import java.util.HashMap;

import model.Letter;
import model.sound.Phoneme;

public abstract class PersonVoice implements Voice {
  HashMap<Letter, Phoneme> phonemes;

  public PersonVoice(HashMap<Letter, String> phonemes) {
    this.phonemes = new HashMap<>();
    for (Letter letter : phonemes.keySet()) {
      String soundFile = phonemes.get(letter);
      this.phonemes.put(letter, new Phoneme(letter, soundFile));
    }
  }

  public Phoneme getPhonemeOf(Letter letter) {
    return this.phonemes.get(letter);
  }
}
