package model.sound;

import javax.sound.sampled.AudioInputStream;

/**
 * A {@link CombinationSound} represents a {@link Sound} that is made from the combination of one or
 * more sounds.
 */
public class CombinationSound extends AbstractSound {
  private AudioInputStream combinedSounds;

  /**
   * Construct a {@link CombinationSound} from the {@link AudioInputStream} that represents it.
   * @param combinedSounds The {@link AudioInputStream} that represents the sound.
   */
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
