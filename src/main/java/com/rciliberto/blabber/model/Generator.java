package com.rciliberto.blabber.model;

import javax.sound.sampled.AudioInputStream;

import com.rciliberto.blabber.model.sound.Sound;

/**
 * A model that turns text into a rendered {@link AudioInputStream} that speaks the text.
 */
public interface Generator {
  /**
   * Transform the given {@link String} text into a spoken {@link Sound}.
   * @param text The text to turn into a {@link Sound}
   * @return The {@link Sound} that is generated
   */
  Sound generate(String text);
}
