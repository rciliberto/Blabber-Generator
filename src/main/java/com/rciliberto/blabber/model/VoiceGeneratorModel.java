package com.rciliberto.blabber.model;

import java.util.Objects;

import com.rciliberto.blabber.model.letter.Letter;
import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.Voice;

/**
 * A {@link GeneratorModel} that generates sounds based on a specific {@link Voice}.
 */
public class VoiceGeneratorModel implements GeneratorModel {
  private final Voice voice;

  /**
   * Construct this {@link VoiceGeneratorModel} based on a specific {@link Voice}.
   * @param voice The {@link Voice} used to construct generated sounds.
   */
  public VoiceGeneratorModel(Voice voice) {
    this.voice = voice;
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
}
