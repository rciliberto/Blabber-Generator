package com.rciliberto.blabber.view;

import com.rciliberto.blabber.model.Generator;
import com.rciliberto.blabber.model.sound.Sound;

/**
 * A {@link GeneratorView} represents the view class for a {@link Generator}.
 */
public interface GeneratorView {

  /**
   * Render the sound in the way according to this {@link GeneratorView}.
   * @param soundToRender The {@link Sound} to render
   */
  void setSound(Sound soundToRender);

  void render();

  void addFeatures(Features features) throws UnsupportedOperationException;
}
