package model.sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhonemeTest {
  AudioInputStream robAStream;
  AudioInputStream robBStream;

  Phoneme robA;
  Phoneme robB;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/A.wav"));
    robBStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/B.wav"));

    robA = new Phoneme(Letter.A, robAStream);
    robB = new Phoneme(Letter.A, robBStream);
  }

  @Test
  void renderSound() throws IOException, UnsupportedAudioFileException {
    assertEquals(robAStream, robA.renderSound());
    assertEquals(robBStream, robB.renderSound());
  }
}