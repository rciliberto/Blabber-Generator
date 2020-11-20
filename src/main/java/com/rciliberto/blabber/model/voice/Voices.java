package com.rciliberto.blabber.model.voice;

public enum Voices {

  HAZEL_VOICE(new HazelVoice(), "Hazel"),
  LIAM_VOICE(new LiamVoice(), "Liam"),
  ROB_VOICE(new RobVoice(), "Rob"),
  BOB_VOICE(new BobVoice(), "Bob"),
  SOPHIE_VOICE(new SophieVoice(), "Sophie");

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
