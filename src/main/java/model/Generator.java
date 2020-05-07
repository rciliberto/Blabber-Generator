package model;

import javax.sound.sampled.AudioInputStream;

public interface Generator {
  public AudioInputStream generate(String text);
}
