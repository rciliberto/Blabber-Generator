package com.rciliberto.blabber.model.voice;

/**
 * {@link RobVoice} represents the {@link AbstractVoice} "Rob"
 */
public class RobVoice extends AbstractVoice {

  /**
   * Construct a {@link RobVoice}.
   */
  public RobVoice() {
    super(constructPhonemes("src/main/resources/RobVoice"));
  }
}
