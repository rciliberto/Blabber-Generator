package com.rciliberto.blabber.view;

/**
 * Represents the feature list that a view can perform.
 */
public interface Features {

  /**
   * Render the phrase using the model.
   * @param phrase The phrase to render as blabber
   */
  void renderPhrase(String phrase);
}
