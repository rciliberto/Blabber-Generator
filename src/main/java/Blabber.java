import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import model.Generator;
import model.VoiceGenerator;
import model.voice.RobVoice;

public class Blabber {
    public static void main(String[] args) {
        Generator blabberGenerator = new VoiceGenerator(new RobVoice());

        AudioInputStream blabb = blabberGenerator.generate("hello world");

        try {
            AudioSystem.write(blabb,
                    AudioFileFormat.Type.WAVE,
                    new File("test.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
