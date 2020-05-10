package model.voice;

import model.letter.Letter;
import model.sound.Sound;

/**
 * A {@link Voice} represents a voice that can speak letters of the alphabet.
 */
public interface Voice {
  /**
   * Generate this {@link Voice}'s {@link Sound} representation of a {@link Letter}.
   * @param letter The {@link Letter} used to generate the {@link Sound}
   * @return The {@link Sound} generated by the {@link Letter}
   */
  Sound getPhonemeOf(Letter letter);
}
