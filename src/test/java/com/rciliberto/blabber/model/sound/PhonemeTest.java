package com.rciliberto.blabber.model.sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.rciliberto.blabber.model.letter.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhonemeTest {
  String robAFile;
  String robBFile;

  AudioInputStream robAStream;
  AudioInputStream robBStream;

  Phoneme robA;
  Phoneme robB;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAFile = "src/main/resources/RobVoice/A.wav";
    robBFile = "src/main/resources/RobVoice/B.wav";

    robAStream = AudioSystem.getAudioInputStream(new File(robAFile));
    robBStream = AudioSystem.getAudioInputStream(new File(robBFile));

    robA = new Phoneme(Letter.A, robAFile);
    robB = new Phoneme(Letter.A, robBFile);
  }

  @Test
  void appendSound() {
    assertEquals(robA.renderSound().getFrameLength() + robB.renderSound().getFrameLength(),
            robA.appendSound(robB).renderSound().getFrameLength());
    assertEquals(robA.renderSound().getFrameLength() + robB.renderSound().getFrameLength(),
            robB.appendSound(robA).renderSound().getFrameLength());
  }

  @Test
  void renderSound() {
    assertEquals(robAStream.getFrameLength(), robA.renderSound().getFrameLength());

    assertEquals(robBStream.getFrameLength(), robB.renderSound().getFrameLength());
  }
}