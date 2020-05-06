package model.sound;

import javax.sound.sampled.AudioInputStream;

public class CombinationSound extends AbstractSound {
  private AudioInputStream combinedSounds;

  public CombinationSound(AudioInputStream combinedSounds) {
    this.combinedSounds = combinedSounds;
  }

  @Override
  public Sound appendSound(Sound sound) {
    return new CombinationSound(combineSounds(this, sound));
  }

  @Override
  public AudioInputStream renderSound() {
    return new AudioInputStream(this.combinedSounds, this.combinedSounds.getFormat(),
            this.combinedSounds.getFrameLength());
  }
}
