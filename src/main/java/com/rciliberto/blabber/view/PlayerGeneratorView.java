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
public class PlayerGeneratorView implements GeneratorView {
  private Sound soundToRender;

  static class AudioListener implements LineListener {
    private boolean done = false;
    @Override public synchronized void update(LineEvent event) {
      LineEvent.Type eventType = event.getType();
      if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
        done = true;
        notifyAll();
      }
    }
    public synchronized void waitUntilDone() throws InterruptedException {
      while (!done) {
        wait();
      }
    }
  }

  public PlayerGeneratorView(Sound soundToRender) {
    this.soundToRender = soundToRender;
  }

  @Override
  public void setSound(Sound sound) {
    this.soundToRender = sound;
  }

  @Override
  public void render() {
    try {
      AudioInputStream audioStream = this.soundToRender.renderSound();
      AudioFormat format = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      Clip audioClip = (Clip) AudioSystem.getLine(info);

      AudioListener listener = new AudioListener();
      audioClip.addLineListener(listener);


      audioClip.addLineListener(listener);
      audioClip.open(audioStream);

      audioClip.start();
      listener.waitUntilDone();
      audioClip.close();
    } catch (IOException | LineUnavailableException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addFeatures(Features features) {
    throw new UnsupportedOperationException("Features are not supported by FileGeneratorViews");
  }
}
