package com.rciliberto.blabber.model.voice;

/**
 * {@link SophieCVoice} represents the {@link AbstractVoice} "Sophie"
 */
public class SophieCVoice extends AbstractVoice {

  /**
   * Construct a {@link SophieCVoice}.
   */
  public SophieCVoice() {
    super(constructPhonemes("src/main/resources/SophieCVoice"));
  }
}
