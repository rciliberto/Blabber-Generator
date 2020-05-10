package com.rciliberto.blabber;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

import com.rciliberto.blabber.model.GeneratorModel;
import com.rciliberto.blabber.model.VoiceGeneratorModel;
import com.rciliberto.blabber.model.sound.Sound;
import com.rciliberto.blabber.model.voice.RobVoice;

public class Blabber {
    public static void main(String[] args) {
        GeneratorModel blabberGenerator = new VoiceGeneratorModel(new RobVoice());

        Sound blabb = blabberGenerator.generate("Hello World!");

        try {
            AudioSystem.write(blabb.renderSound(),
                    AudioFileFormat.Type.WAVE,
                    new File("test.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
