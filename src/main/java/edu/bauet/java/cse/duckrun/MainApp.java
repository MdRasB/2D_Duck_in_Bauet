package edu.bauet.java.cse.duckrun;

import edu.bauet.java.cse.duckrun.scenes.LogoScene;
import edu.bauet.java.cse.duckrun.scenes.StoryScene;
import edu.bauet.java.cse.duckrun.utils.AssetLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Duck Dash");
        primaryStage.setResizable(false);

        System.setProperty(
                "com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform.DISABLE_AV_SYNC",
                "true"
        );

        AssetLoader.preloadAssets();
        AssetLoader.preloadVideos();

        LogoScene logoScene = new LogoScene();
        Scene scene = logoScene.createScene(stage);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void switchScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        // Present with vsync disabled. With vsync enabled, the D3D present
        // occasionally misses a vblank (2-vblank 32ms stall a few times per
        // second), which shows as stutter on the moving background. With vsync
        // off, presents never block and DWM still composites, eliminating the
        // hitches. Must be set before the toolkit initialises.
        System.setProperty("prism.vsync", "false");
        // Render well above the display refresh rate so every DWM vblank can
        // pick a freshly-completed frame. With vsync off, the default ~60Hz
        // pulse (62.5fps) drifts against the 60Hz display and produces a slow
        // duplicate-frame wobble on the scrolling background; running ~180fps
        // leaves every vblank with a <=6ms-fresh frame, removing that beat.
        System.setProperty("javafx.animation.fullspeed", "true");
        launch(args);
    }
}