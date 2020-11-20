package com.rciliberto.blabber.model.voice;

/**
 * {@link HazelVoice} represents the {@link AbstractVoice} "Hazel"
 */
public class HazelVoice extends AbstractVoice {

  /**
   * Construct a {@link HazelVoice}.
   */
  protected HazelVoice() {
    super(constructPhonemes("src/main/resources/HazelVoice"));
  }
}
