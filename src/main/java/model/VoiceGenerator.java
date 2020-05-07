package model;

import java.util.Objects;

import javax.sound.sampled.AudioInputStream;

import model.sound.Sound;
import model.voice.Voice;

public class VoiceGenerator implements Generator {
  private final Voice voice;

  public VoiceGenerator(Voice voice) {
    this.voice = voice;
  }

  @Override
  public AudioInputStream generate(String generationText) {
    if (Objects.isNull(generationText)) {
      throw new IllegalArgumentException("Generation text cannot be Null");
    } else if (generationText.equals("")){
      throw new IllegalArgumentException("Generation text cannot be empty");
    }

    generationText = generationText.replaceAll("[^A-Za-z0-9]", "");

    Letter firstLetter = Letter.valueOf(generationText.substring(0, 1).toUpperCase());
    Sound baseSound = voice.getPhonemeOf(firstLetter);
    for (int i = 1; i < generationText.length(); i += 1) {
      Letter nextLetter = Letter.valueOf(generationText.substring(i, i+1).toUpperCase());
      Sound nextSound = voice.getPhonemeOf(nextLetter);

      baseSound = baseSound.appendSound(nextSound);
    }

    return baseSound.renderSound();
  }
}
