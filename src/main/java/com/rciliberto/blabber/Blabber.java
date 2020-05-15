package com.rciliberto.blabber;

import com.rciliberto.blabber.controller.FeaturesGeneratorController;
import com.rciliberto.blabber.controller.GeneratorController;
import com.rciliberto.blabber.model.Generator;
import com.rciliberto.blabber.model.VoiceGenerator;
import com.rciliberto.blabber.model.voice.Voices;
import com.rciliberto.blabber.view.GeneratorView;
import com.rciliberto.blabber.view.PlayerGeneratorView;

public class Blabber {
    public static void main(String[] args) {
        model = new VoiceGenerator(Voices.ROB_VOICE);
        view = new PlayerGeneratorView(model.generate("Hello World!"));
        controller = new FeaturesGeneratorController(model, view);

        GeneratorController generatorController = new FeaturesGeneratorController(robVoiceGenerator, generatorView);
        generatorController.start();
    }
}
