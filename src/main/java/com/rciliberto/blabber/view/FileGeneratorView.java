package com.rciliberto.blabber.view;

import com.rciliberto.blabber.model.sound.Sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

/**
 * A {@link FileGeneratorView} is a {@link GeneratorView} that renders a given {@link Sound} to a
 * file.
 */
public class FileGeneratorView implements GeneratorView {
  private final String filePath;

  public FileGeneratorView(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void renderSound(Sound sound) {
    try {
      AudioSystem.write(sound.renderSound(),
              AudioFileFormat.Type.WAVE,
              new File(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
