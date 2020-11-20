package com.rciliberto.blabber.view.gui;

import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.view.Features;
import com.rciliberto.blabber.view.GeneratorView;

import java.awt.*;

import javax.swing.*;


/**
 * A GUI view of the generator
 */
public class GuiGeneratorView extends JFrame implements GeneratorView {

  private GeneratorPanel generatorPanel;

  public GuiGeneratorView() {
    super("Blabber Generator");
    this.generatorPanel = new GeneratorPanel();

    this.setUpLayout();

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  @Override
  public void setSound(Sound soundToRender) {
    this.generatorPanel.setSound(soundToRender);
  }

  @Override
  public void render() {
    this.setVisible(true);
  }

  @Override
  public void updateRender() {
    this.repaint();
  }

  @Override
  public void addFeatures(Features features) throws UnsupportedOperationException {
    this.generatorPanel.addFeatures(features);
  }

  private void setUpLayout() {
    this.setResizable(false);

    this.add(this.generatorPanel);

    this.pack();
  }
}
