package com.rciliberto.blabber.model.voice;

/**
 * {@link GeorgeVoice} represents the {@link AbstractVoice} "Sophie"
 */
public class GeorgeVoice extends AbstractVoice {

  /**
   * Construct a {@link GeorgeVoice}.
   */
  public GeorgeVoice() {
    super(constructPhonemes("src/main/resources/GeorgeVoice"));
  }
}
