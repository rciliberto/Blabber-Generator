package com.rciliberto.blabber.view.gui;

import com.rciliberto.blabber.model.voice.Voices;

import javax.swing.*;

class DropDownBox extends JComboBox<Voices> {
  DropDownBox() {
    super(Voices.values());
  }
}
