package com.rciliberto.blabber.model.voice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.rciliberto.blabber.model.letter.Letter;

import static org.junit.jupiter.api.Assertions.*;

class RobVoiceTest {
  String robAFile;
  String robBFile;

  AudioInputStream robAStream;
  AudioInputStream robBStream;

  RobVoice robVoice;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAFile = "src/main/resources/RobVoice/A.wav";
    robBFile = "src/main/resources/RobVoice/B.wav";

    robAStream = AudioSystem.getAudioInputStream(new File(robAFile));
    robBStream = AudioSystem.getAudioInputStream(new File(robBFile));

    robVoice = new RobVoice();
  }

  @Test
  void getPhonemeOf() {
    assertEquals(robAStream.getFrameLength(), robVoice.getPhonemeOf(Letter.A).renderSound().getFrameLength());

    assertEquals(robBStream.getFrameLength(), robVoice.getPhonemeOf(Letter.B).renderSound().getFrameLength());
  }
}