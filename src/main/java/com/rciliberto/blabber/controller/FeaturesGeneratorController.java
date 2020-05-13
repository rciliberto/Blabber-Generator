package com.rciliberto.blabber.controller;

import com.rciliberto.blabber.model.Generator;
import com.rciliberto.blabber.view.Features;
import com.rciliberto.blabber.view.GeneratorView;

/**
 * Represents the Controller for a generator.
 * Mutates the model when a Feature is called in the View.
 */
public class FeaturesGeneratorController implements GeneratorController, Features {

  Generator model;
  GeneratorView view;

  /**
   * Constructs a {@link FeaturesGeneratorController} with a given {@link Generator} model and
   * {@link GeneratorView} view.
   * @param model The model of the generator
   * @param view The view of the generator
   */
  public FeaturesGeneratorController(Generator model, GeneratorView view) {
    this.model = model;
    this.view = view;
    try {
      this.view.addFeatures(this);
    } catch (UnsupportedOperationException e) {
      System.out.println("Attempted to add features to a view that does not support them");
    }
  }

  @Override
  public void start() {
    view.render();
  }

  @Override
  public void renderPhrase(String phrase) {
    view.setSound(model.generate(phrase));
    view.render();
  }
}
