package model.voice;

import java.util.HashMap;
import java.util.Map;

import model.letter.Letter;
import model.sound.Phoneme;
import model.sound.Sound;

/**
 * An abstract representation of a {@link Voice} based on the voice of a person.
 */
public abstract class AbstractVoice implements Voice {
  Map<Letter, Phoneme> phonemes;

  /**
   * Construct this {@link AbstractVoice} based on a {@link Map} of {@link Letter}s to sound files.
   * @param phonemes the {@link Map} of {@link Letter}s to sound files.
   */
  protected AbstractVoice(Map<Letter, String> phonemes) {
    this.phonemes = new HashMap<>();
    for (Letter letter : phonemes.keySet()) {
      String soundFile = phonemes.get(letter);
      this.phonemes.put(letter, new Phoneme(letter, soundFile));
    }
  }

  /**
   * Construct a {@link Map} of {@link Letter} to file paths of audio files representing that
   * {@link Letter} given the root folder containing the files.
   * @param voiceRoot The root folder containing all audio files of this {@link AbstractVoice}.
   * @return A {@link Map} of {@link Letter} to file paths of audio files representing that
   * {@link Letter}
   */
  protected static Map<Letter, String> constructPhonemes(String voiceRoot) {
    HashMap<Letter, String> phonemes = new HashMap<>();

    for (Letter letter : Letter.values()) {
      String soundFile;

      try {
        soundFile = String.format(voiceRoot + "/%s.wav", letter.toString());
        phonemes.put(letter, soundFile);
      } catch (Exception e){
        e.printStackTrace();
        System.exit(1);
      }
    }

    return phonemes;
  }

  @Override
  public Sound getPhonemeOf(Letter letter) {
    return this.phonemes.get(letter);
  }
}
