package com.rciliberto.blabber;

import com.rciliberto.blabber.model.GeneratorModel;
import com.rciliberto.blabber.model.VoiceGeneratorModel;
import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.RobVoice;
import com.rciliberto.blabber.view.FileGeneratorView;
import com.rciliberto.blabber.view.GeneratorView;
import com.rciliberto.blabber.view.PlayerGeneratorView;

public class Blabber {
    public static void main(String[] args) {
        GeneratorModel robVoiceGeneratorModel = new VoiceGeneratorModel(new RobVoice());
        GeneratorView generatorView = new PlayerGeneratorView();
        Sound blab = robVoiceGeneratorModel.generate("i love sophie she is beautiful");

        generatorView.renderSound(blab);
    }
}
