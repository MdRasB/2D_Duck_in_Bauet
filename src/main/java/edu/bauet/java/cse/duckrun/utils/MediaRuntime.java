package edu.bauet.java.cse.duckrun.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Centralized guard for JavaFX media backend failures on Linux packaging/runtime mismatches.
 */
public final class MediaRuntime {

    private static final Logger LOGGER = Logger.getLogger(MediaRuntime.class.getName());
    private static volatile boolean playbackAvailable = true;

    private MediaRuntime() {}

    public static boolean isPlaybackAvailable() {
        return playbackAvailable;
    }

    public static MediaPlayer createPlayer(Media media, String context) {
        if (!playbackAvailable || media == null) {
            return null;
        }
        try {
            return new MediaPlayer(media);
        } catch (RuntimeException ex) {
            markPlaybackUnavailable(context, ex);
            return null;
        }
    }

    public static void markPlaybackUnavailable(String context, Throwable error) {
        if (playbackAvailable) {
            LOGGER.log(Level.SEVERE, "Media playback disabled after failure in " + context, error);
        } else {
            LOGGER.log(Level.FINE, "Additional media failure in " + context, error);
        }
        playbackAvailable = false;
    }
}
