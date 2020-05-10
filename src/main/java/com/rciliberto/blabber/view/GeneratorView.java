package com.rciliberto.blabber.view;

import com.rciliberto.blabber.model.GeneratorModel;
import com.rciliberto.blabber.model.sound.Sound;

/**
 * A {@link GeneratorView} represents the view class for a {@link GeneratorModel}.
 */
public interface GeneratorView {

  /**
   * Render the sound in the way according to this {@link GeneratorView}.
   * @param sound The {@link Sound} to render
   */
  void renderSound(Sound sound);
}
