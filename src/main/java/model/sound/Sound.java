package model.sound;

import javax.sound.sampled.AudioInputStream;

/**
 * A {@link Sound} represents a sound that can be spoken.
 */
public interface Sound {

  /**
   * Append a {@link Sound} to this {@link Sound} and return it as a new {@link Sound}.
   * @param sound The sound to append
   * @return A new combinded {@link Sound}
   */
  Sound appendSound(Sound sound);

  /**
   * Returns the audio that a sound makes as a {@link AudioInputStream}.
   * @return The audio that a sound makes
   */
  AudioInputStream renderSound();


}