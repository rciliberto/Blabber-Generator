package model.voice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Letter;

import static org.junit.jupiter.api.Assertions.*;

class RobVoiceTest {
  AudioInputStream robAStream;
  AudioInputStream robBStream;

  RobVoice robVoice;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/A.wav"));
    robBStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/B.wav"));

    HashMap<Letter, AudioInputStream> phonemes = new HashMap<>();
    phonemes.put(Letter.A, robAStream);
    phonemes.put(Letter.B, robBStream);

    robVoice = new RobVoice(phonemes);
  }

  @Test
  void getPhonemeOf() {
    assertEquals(robAStream, robVoice.getPhonemeOf(Letter.A).renderSound());
    assertEquals(robBStream, robVoice.getPhonemeOf(Letter.B).renderSound());
  }
}