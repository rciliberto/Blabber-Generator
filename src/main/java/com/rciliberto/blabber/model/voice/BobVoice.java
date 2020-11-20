package com.rciliberto.blabber.model.voice;

/**
 * {@link BobVoice} represents the {@link AbstractVoice} "Bob"
 */
public class BobVoice extends AbstractVoice {
  /**
   * Construct a {@link BobVoice}.
   */
  public BobVoice() {
    super(constructPhonemes("src/main/resources/BobVoice"));
  }
}
