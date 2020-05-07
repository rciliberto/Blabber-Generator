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
  String robAFile;
  String robBFile;

  AudioInputStream robAStream;
  AudioInputStream robBStream;

  RobVoice robVoice;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAFile = "src/main/resources/RobVoice/A.wav";
    robBFile = "src/main/resources/RobVoice/F.wav";

    robAStream = AudioSystem.getAudioInputStream(new File(robAFile));
    robBStream = AudioSystem.getAudioInputStream(new File(robBFile));

    HashMap<Letter, String> phonemes = new HashMap<>();
    phonemes.put(Letter.A, robAFile);
    phonemes.put(Letter.B, robBFile);

    robVoice = new RobVoice(phonemes);
  }

  @Test
  void getPhonemeOf() {
    assertEquals(robAStream.getFrameLength(), robVoice.getPhonemeOf(Letter.A).renderSound().getFrameLength());

    assertEquals(robBStream.getFrameLength(), robVoice.getPhonemeOf(Letter.B).renderSound().getFrameLength());
  }
}