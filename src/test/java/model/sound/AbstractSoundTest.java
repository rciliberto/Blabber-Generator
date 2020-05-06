package model.sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractSoundTest {
  AudioInputStream robAStream;
  AudioInputStream robBStream;

  Phoneme robA;
  Phoneme robB;

  AudioInputStream combined;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/A.wav"));
    robBStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/B.wav"));

    robA = new Phoneme(Letter.A, robAStream);
    robB = new Phoneme(Letter.A, robBStream);

    combined = new AudioInputStream(new SequenceInputStream(robAStream, robBStream), robAStream.getFormat(),
            robAStream.getFrameLength() + robBStream.getFrameLength());
  }

  @Test
  void combineSounds() {
    assertEquals(combined.getFrameLength(), AbstractSound.combineSounds(robA, robB).getFrameLength());
    assertEquals(combined.getFormat(), AbstractSound.combineSounds(robA, robB).getFormat());
  }
}