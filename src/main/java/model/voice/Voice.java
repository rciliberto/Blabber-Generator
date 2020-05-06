package model.voice;

import model.Letter;
import model.sound.Phoneme;

public interface Voice {
  Phoneme getPhonemeOf(Letter letter);
}
