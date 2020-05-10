package com.rciliberto.blabber.model.sound;

import java.io.SequenceInputStream;

import javax.sound.sampled.AudioInputStream;

/**
 * An abstract implementation of {@link Sound} that has protected methods to help full
 * implementations.
 */
public abstract class AbstractSound implements Sound {
  /**
   * A protected method that helps combine two {@link Sound}s together by appending the second to the first.
   * @param baseSound The {@link Sound} that the other will be appended to
   * @param appendedSound The {@link Sound} to append
   * @return The combined {@link Sound}
   */
  protected static AudioInputStream combineSounds(Sound baseSound, Sound appendedSound) {
    AudioInputStream base = baseSound.renderSound();
    AudioInputStream appended = appendedSound.renderSound();

    return new AudioInputStream(new SequenceInputStream(base, appended), base.getFormat(),
            base.getFrameLength() + appended.getFrameLength());
  }
}
