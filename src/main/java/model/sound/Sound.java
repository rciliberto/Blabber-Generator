package model.sound;

import javax.sound.sampled.AudioInputStream;

/**
 * A {@link Sound} represents a sound that can be spoken.
 */
public interface Sound {
  Sound appendSound(Sound sound);

  /**
   * Returns the audio that a sound makes
   * @return the audio that a sound makes
   */
  AudioInputStream renderSound();


}