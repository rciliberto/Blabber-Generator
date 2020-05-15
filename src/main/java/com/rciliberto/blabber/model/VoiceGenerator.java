package com.rciliberto.blabber.model;

import java.util.Objects;

import com.rciliberto.blabber.model.letter.Letter;
import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.Voice;
import com.rciliberto.blabber.model.voice.Voices;

/**
 * A {@link Generator} that generates sounds based on a specific {@link Voice}.
 */
public class VoiceGenerator implements Generator {
  private Voice voice;

  /**
   * Construct this {@link VoiceGenerator} based on a specific {@link Voice}.
   * @param voice The specific {@link Voice} from {@link Voices} used to construct generated sounds.
   */
  public VoiceGenerator(Voices voice) {
    this.voice = voice.getVoice();
  }

  @Override
  public Sound generate(String generationText) {
    if (Objects.isNull(generationText)) {
      throw new IllegalArgumentException("Generation text cannot be Null");
    } else if (generationText.equals("")){
      throw new IllegalArgumentException("Generation text cannot be empty");
    }

    // Remove all non-alphabet characters
    generationText = generationText.replaceAll("[^A-Za-z]", "");

    // Get each phoneme for each letter in the generation text and combine them.
    Letter firstLetter = Letter.valueOf(generationText.substring(0, 1).toUpperCase());
    Sound baseSound = voice.getPhonemeOf(firstLetter);
    for (int i = 1; i < generationText.length(); i += 1) {
      Letter nextLetter = Letter.valueOf(generationText.substring(i, i+1).toUpperCase());
      Sound nextSound = voice.getPhonemeOf(nextLetter);

      baseSound = baseSound.appendSound(nextSound);
    }

    return baseSound;
  }

  @Override
  public void setVoice(Voices voice) {
    this.voice = voice.getVoice();
  }
}
