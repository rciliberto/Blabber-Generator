package com.rciliberto.blabber;

import com.rciliberto.blabber.model.GeneratorModel;
import com.rciliberto.blabber.model.VoiceGeneratorModel;
import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.RobVoice;
import com.rciliberto.blabber.view.FileGeneratorView;
import com.rciliberto.blabber.view.GeneratorView;

public class Blabber {
    public static void main(String[] args) {
        GeneratorModel robVoiceGeneratorModel = new VoiceGeneratorModel(new RobVoice());
        GeneratorView fileGeneratorView = new FileGeneratorView("test.wav");
        Sound blab = robVoiceGeneratorModel.generate("Hello World!");

        fileGeneratorView.renderSound(blab);
    }
}
