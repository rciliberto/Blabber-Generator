package com.rciliberto.blabber.model.voice;

public enum Voices {

  ROB_VOICE(new RobVoice()),
  LIAM_VOICE(new LiamVoice());

  private final Voice voice;

  Voices(Voice voice) {
    this.voice = voice;
  }

  public Voice getVoice() {
    return this.voice;
  }
}
