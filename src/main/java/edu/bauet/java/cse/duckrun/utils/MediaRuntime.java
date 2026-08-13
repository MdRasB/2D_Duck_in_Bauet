package edu.bauet.java.cse.duckrun.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Centralized factory and failure guard for JavaFX {@link MediaPlayer}
 * creation.
 * <p>
 * DuckDash does not bundle a private copy of GStreamer/FFmpeg. It relies on
 * the host system's own GStreamer 1.x installation for video/audio decoding
 * (the .deb package declares the exact plugin sets it needs as apt
 * dependencies; see release.yml). Because of that, a single failed
 * {@link MediaPlayer} construction does not necessarily mean playback is
 * broken for the rest of the session -- it can be a transient hiccup (a
 * cold GStreamer registry cache on first launch, brief resource contention
 * at startup, etc.). Each scene owns its own bounded retry loop and is
 * responsible for calling {@link #reportExhausted(String)} only once it has
 * genuinely used up its retries. That is the one thing that disables
 * further attempts for the remainder of the run, so a later scene (e.g. the
 * ending cutscene, after the opening cutscene already proved video is
 * unavailable on this machine) skips straight to its fallback instead of
 * repeating a doomed retry sequence.
 */
public final class MediaRuntime {

    private static final Logger LOGGER = Logger.getLogger(MediaRuntime.class.getName());
    private static volatile boolean playbackAvailable = true;

    private MediaRuntime() {}

    /**
     * Whether it is still worth attempting to create a {@link MediaPlayer}
     * this session. Starts {@code true} and only ever flips to
     * {@code false} via {@link #reportExhausted(String)}.
     */
    public static boolean isPlaybackAvailable() {
        return playbackAvailable;
    }

    /**
     * Attempts to construct a {@link MediaPlayer} for {@code media}.
     * Never throws -- returns {@code null} on failure so the caller can
     * drive its own retry/fallback logic instead of the failure being
     * silently treated as permanent.
     *
     * @param media   the media to play, or {@code null}
     * @param context short, human-readable label identifying the caller
     *                (used only for logging), e.g. {@code "StoryScene/opening-video"}
     */
    public static MediaPlayer createPlayer(Media media, String context) {
        if (!playbackAvailable || media == null) {
            return null;
        }
        try {
            return new MediaPlayer(media);
        } catch (RuntimeException ex) {
            LOGGER.log(Level.WARNING, "MediaPlayer creation failed in " + context
                    + " -- this attempt will be retried if the caller has retries left.", ex);
            return null;
        }
    }

    /**
     * Called by a scene once it has exhausted its own retry budget for a
     * piece of media. Disables further playback attempts for the rest of
     * this run.
     *
     * @param context short, human-readable label identifying the caller
     *                (used only for logging)
     */
    public static void reportExhausted(String context) {
        if (playbackAvailable) {
            LOGGER.log(Level.SEVERE, "Media playback disabled for the remainder of this session"
                    + " -- retries exhausted in " + context);
        }
        playbackAvailable = false;
    }
}
