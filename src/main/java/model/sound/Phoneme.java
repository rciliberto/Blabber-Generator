package model.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.letter.Letter;

/**
 * A {@link Phoneme} represents a {@link Sound} from a letter of the alphabet.
 */
public class Phoneme extends AbstractSound {
  private final Letter letter;
  private final String phonemeFile;

  /**
   * Construct a {@link Phoneme} from the {@link Letter} and file that contains the sound
   * representing that {@link Letter}.
   * @param letter The {@link Letter} that represents this {@link Phoneme}
   * @param phonemeFile The file location that contains the sound made by this {@link Phoneme}
   */
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
