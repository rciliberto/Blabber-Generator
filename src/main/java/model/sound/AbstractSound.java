package model.sound;

import java.io.SequenceInputStream;

import javax.sound.sampled.AudioInputStream;

public abstract class AbstractSound implements Sound {
  protected static AudioInputStream combineSounds(Sound baseSound, Sound appendedSound) {
    AudioInputStream base = baseSound.renderSound();
    AudioInputStream appended = appendedSound.renderSound();

    return new AudioInputStream(new SequenceInputStream(base, appended), base.getFormat(),
            base.getFrameLength() + appended.getFrameLength());
  }
}
