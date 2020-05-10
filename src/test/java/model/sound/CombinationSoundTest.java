package model.sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.letter.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSoundTest {
  String robAFile;
  String robBFile;

  AudioInputStream robAStream;
  AudioInputStream robBStream;

  AudioInputStream combinedAB;
  AudioInputStream combinedBA;
  AudioInputStream combinedABBA;

  Phoneme robA;
  Phoneme robB;
  CombinationSound robABCombined;
  CombinationSound robBACombined;
  Sound robABBACombined;

  @BeforeEach
  void setUp() throws IOException, UnsupportedAudioFileException {
    robAFile = "src/main/resources/RobVoice/A.wav";
    robBFile = "src/main/resources/RobVoice/A.wav";

    robAStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/A.wav"));
    robBStream = AudioSystem.getAudioInputStream(new File("src/main/resources/RobVoice/B.wav"));

    combinedAB = new AudioInputStream(new SequenceInputStream(robAStream, robBStream), robAStream.getFormat(),
            robAStream.getFrameLength() + robBStream.getFrameLength());
    combinedBA = new AudioInputStream(new SequenceInputStream(robBStream, robAStream), robBStream.getFormat(),
            robBStream.getFrameLength() + robAStream.getFrameLength());
    combinedABBA = new AudioInputStream(new SequenceInputStream(combinedAB, combinedBA), combinedAB.getFormat(),
            combinedAB.getFrameLength() + combinedBA.getFrameLength());

    robA = new Phoneme(Letter.A, robAFile);
    robB = new Phoneme(Letter.A, robBFile);

    robABCombined = new CombinationSound(combinedAB);
    robBACombined = new CombinationSound(combinedBA);
    robABBACombined = robABCombined.appendSound(robBACombined);
  }

  @Test
  void appendSound() {
    assertEquals(combinedABBA.getFrameLength(), robABBACombined.renderSound().getFrameLength());
  }

  @Test
  void renderSound() {
    assertEquals(combinedAB.getFrameLength(), robABCombined.renderSound().getFrameLength());

    assertEquals(combinedBA.getFrameLength(), robBACombined.renderSound().getFrameLength());
  }
}