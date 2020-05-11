package com.rciliberto.blabber.view;

import com.rciliberto.blabber.model.sound.Sound;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

/**
 * A {@link PlayerGeneratorView} represents a view that can play a {@link Sound}.
 */
public class PlayerGeneratorView  implements GeneratorView {

  boolean playCompleted;

  @Override
  public void renderSound(Sound sound) {
    try {
      AudioInputStream audioStream = sound.renderSound();

      AudioFormat format = audioStream.getFormat();

      DataLine.Info info = new DataLine.Info(Clip.class, format);

      Clip audioClip = (Clip) AudioSystem.getLine(info);

      audioClip.addLineListener(lineEvent -> {
        LineEvent.Type type = lineEvent.getType();

        if (type == LineEvent.Type.START) {
          System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
          playCompleted = true;
          System.out.println("Playback completed.");
        }
      });

      audioClip.open(audioStream);

      audioClip.start();

      while (!playCompleted) {
        // wait for the playback completes
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }

      audioClip.close();

    } catch (LineUnavailableException ex) {
      System.out.println("Audio line for playing back is unavailable.");
      ex.printStackTrace();
    } catch (IOException ex) {
      System.out.println("Error playing the audio file.");
      ex.printStackTrace();
    }
  }
}
