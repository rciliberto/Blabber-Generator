package com.rciliberto.blabber.model.voice;

public enum Voices {

  HAZEL_VOICE(new HazelVoice(), "Hazel"),
  LIAM_VOICE(new LiamVoice(), "Liam"),
  ROB_VOICE(new RobVoice(), "Rob"),
  BOB_VOICE(new BobVoice(), "Bob"),
  SOPHIE_C_VOICE(new SophieCVoice(), "SophieC"),
  SOPHIE_O_VOICE(new SophieOVoice(), "SophieO"),
  GEORGE_VOICE(new GeorgeVoice(), "George");

  private final Voice voice;
  private final String representation;

  Voices(Voice voice, String representation) {
    this.voice = voice;
    this.representation = representation;
  }

  public Voice getVoice() {
    return this.voice;
  }


  @Override
  public String toString() {
    return this.representation;
  }
}
