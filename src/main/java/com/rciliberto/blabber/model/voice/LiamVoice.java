package com.rciliberto.blabber.model.voice;

/**
 * {@link LiamVoice} represents the {@link AbstractVoice} "Rob"
 */
public class LiamVoice extends AbstractVoice {

  /**
   * Construct a {@link LiamVoice}.
   */
  public LiamVoice() {
    super(constructPhonemes("src/main/resources/LiamVoice"));
  }
}
