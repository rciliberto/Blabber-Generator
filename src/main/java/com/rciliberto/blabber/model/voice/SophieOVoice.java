package com.rciliberto.blabber.model.voice;

/**
 * {@link SophieOVoice} represents the {@link AbstractVoice} "Sophie"
 */
public class SophieOVoice extends AbstractVoice {

  /**
   * Construct a {@link SophieOVoice}.
   */
  public SophieOVoice() {
    super(constructPhonemes("src/main/resources/SophieOVoice"));
  }
}
