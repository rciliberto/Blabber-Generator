package com.rciliberto.blabber;

import com.rciliberto.blabber.controller.FeaturesGeneratorController;
import com.rciliberto.blabber.controller.GeneratorController;
import com.rciliberto.blabber.model.Generator;
import com.rciliberto.blabber.model.VoiceGenerator;
import com.rciliberto.blabber.model.voice.RobVoice;
import com.rciliberto.blabber.view.GeneratorView;
import com.rciliberto.blabber.view.PlayerGeneratorView;

public class Blabber {
    public static void main(String[] args) {
        Generator robVoiceGenerator = new VoiceGenerator(new RobVoice());
        GeneratorView generatorView = new PlayerGeneratorView(robVoiceGenerator.generate("money printer go brrrrrrrrrrrr"));

        GeneratorController generatorController = new FeaturesGeneratorController(robVoiceGenerator, generatorView);
        generatorController.start();
    }
}
