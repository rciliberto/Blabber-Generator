package com.rciliberto.blabber.view.gui;

import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.Voices;
import com.rciliberto.blabber.view.Features;
import com.rciliberto.blabber.view.FileGeneratorView;
import com.rciliberto.blabber.view.PlayerGeneratorView;

import java.awt.*;
import java.util.Objects;

import javax.swing.*;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.HORIZONTAL;

class GeneratorPanel extends JPanel {
  private static final int PREFERRED_WIDTH = 640;
  private static final int PREFERRED_HEIGHT = 120;

  FileGeneratorView fileView;
  PlayerGeneratorView playerView;

  Features features;

  JTextField textField;

  JComboBox<Voices> dropdownBox;

  JButton previewButton;
  JButton saveButton;

  JFileChooser fileChooser;

  GeneratorPanel() {

    this.fileView = new FileGeneratorView();
    this.playerView = new PlayerGeneratorView();

    this.textField = new JTextField();

    this.dropdownBox = new DropDownBox();

    this.previewButton = new JButton("Preview");
    this.saveButton = new JButton("Save");

    this.fileChooser = new JFileChooser();

    this.setUpLayout();
    this.setUpActionListeners();
  }

  void setSound(Sound soundToRender) {
    this.fileView.setSound(soundToRender);
    this.playerView.setSound(soundToRender);
  }

  void addFeatures(Features features) {
    this.features = features;
  }

  private void setUpActionListeners() {
    previewButton.addActionListener(e -> {
      String text = textField.getText();
      if (!Objects.isNull(text) && !text.equals("")) {
        this.features.renderPhrase(text);
        this.playerView.render();
      }
    });

    saveButton.addActionListener(e -> {
      System.out.println(this.fileChooser.showSaveDialog(this));
    });
  }

  private void setUpLayout() {
    this.setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1;
    c.weighty = 1;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.fill = BOTH;
    this.add(this.textField, c);

    c.gridx = 0;
    c.gridy = 2;
    c.weightx = 1;
    c.weighty = 0;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.fill = HORIZONTAL;
    this.add(this.dropdownBox, c);

    c.gridx = 0;
    c.gridy = 3;
    c.weightx = 1;
    c.weighty = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.fill = HORIZONTAL;
    this.add(this.previewButton, c);

    c.gridx = 1;
    c.gridy = 3;
    c.weightx = 1;
    c.weighty = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.fill = HORIZONTAL;
    this.add(this.saveButton, c);
  }
}
