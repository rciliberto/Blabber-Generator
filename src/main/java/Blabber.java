import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

import model.GeneratorModel;
import model.VoiceGeneratorModel;
import model.sound.Sound;
import model.voice.RobVoice;

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
