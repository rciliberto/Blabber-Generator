package com.rciliberto.blabber;

import com.rciliberto.blabber.controller.FeaturesGeneratorController;
import com.rciliberto.blabber.controller.GeneratorController;
import com.rciliberto.blabber.model.Generator;
import com.rciliberto.blabber.model.VoiceGenerator;
import com.rciliberto.blabber.model.voice.Voices;
import com.rciliberto.blabber.view.FileGeneratorView;
import com.rciliberto.blabber.view.GeneratorView;

import java.io.File;
import java.io.IOException;

public class Blabber {
  static Generator model;
  static GeneratorView view;
  static GeneratorController controller;

  public static void main(String[] args) {
    Voices voice = Voices.GEORGE_VOICE;
    String location = "SophNov";
    String line = "the quick brown fox jumps over the lazy dog";
    String path = "./dialogue/" + location + "/" + voice.toString() + "/" + line + ".wav";
    File f = new File(path);

    try {
      f.getParentFile().mkdirs();
      f.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    model = new VoiceGenerator(voice);
    view = new FileGeneratorView(model.generate(line), path);

//    view = new GuiGeneratorView();
    controller = new FeaturesGeneratorController(model, view);

    controller.start();
  }

}
