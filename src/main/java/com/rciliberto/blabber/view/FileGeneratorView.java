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
  private String filePath;

  public FileGeneratorView(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Render the {@link Sound} and save it to a file. Sets the file path for this
   * {@link FileGeneratorView} for future calls of {@link FileGeneratorView#renderSound(Sound)}
   * @param sound The {@link Sound} to render.
   * @param filePath The path to the file to save.
   */
  public void renderSound(Sound sound, String filePath) {
    this.filePath = filePath;

    try {
      AudioSystem.write(sound.renderSound(),
              AudioFileFormat.Type.WAVE,
              new File(filePath));
    } catch (IOException e) {
      throw new IllegalStateException("Unable to render sound");
    }
  }

  @Override
  public void renderSound(Sound sound) {
    renderSound(sound, this.filePath);
  }
}
