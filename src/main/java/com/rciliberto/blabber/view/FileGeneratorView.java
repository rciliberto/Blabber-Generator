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
  private Sound soundToRender;
  private String filePath;

  public FileGeneratorView() {
    super();
  }

  public FileGeneratorView(Sound soundToRender, String filePath) {
    this.soundToRender = soundToRender;
    this.filePath = filePath;
  }

  /**
   * Render the {@link Sound} and save it to a file. Sets the file path for this
   * {@link FileGeneratorView} for future calls of {@link FileGeneratorView#setSound(Sound)}
   * @param sound The {@link Sound} to render.
   * @param filePath The path to the file to save.
   */
  public void renderSound(Sound sound, String filePath) {
    try {
      AudioSystem.write(sound.renderSound(),
              AudioFileFormat.Type.WAVE,
              new File(filePath));
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
      throw new IllegalStateException("Unable to render sound");
    }
  }

  /**
   * Update the file path to a different path.
   * @param filePath the path the update to
   */
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void setSound(Sound soundToRender) {
    this.soundToRender = soundToRender;
  }

  @Override
  public void render() {
    updateRender();
  }

  @Override
  public void updateRender() {
    renderSound(this.soundToRender, this.filePath);
  }

  @Override
  public void addFeatures(Features features) {
    throw new UnsupportedOperationException("Features are not supported by FileGeneratorViews");
  }
}
