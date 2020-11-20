package com.rciliberto.blabber.model.voice;

/**
 * {@link SophieVoice} represents the {@link AbstractVoice} "Sophie"
 */
public class SophieVoice extends AbstractVoice {

  /**
   * Construct a {@link SophieVoice}.
   */
  public SophieVoice() {
    super(constructPhonemes("src/main/resources/SophieVoice"));
  }
}
