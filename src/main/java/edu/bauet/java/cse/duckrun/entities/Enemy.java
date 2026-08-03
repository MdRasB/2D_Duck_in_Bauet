package edu.bauet.java.cse.duckrun.entities;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Enemy {

    protected Group root; // Changed from just ImageView to Group
    protected ImageView view;
    protected Rectangle debugHitbox;

    protected Image state1;
    protected Image state2;

    protected double speed;
    protected double flapAccumulator = 0.0;
    protected boolean toggleFrame = false;

    protected boolean active = true;
    protected boolean hasCollided = false;

    // Cached scene-space hitbox, refreshed once per frame in update()
    protected Bounds cachedHitBox;

    public Enemy(double startX,
                 double startY,
                 double worldSpeed,
                 double extraSpeed,
                 double displayHeight) {

        this.speed = worldSpeed + extraSpeed;

        view = new ImageView();
        view.setFitHeight(displayHeight);
        view.setPreserveRatio(true);
        
        // Debug Hitbox (Invisible)
        debugHitbox = new Rectangle();
        debugHitbox.setFill(Color.TRANSPARENT);
        debugHitbox.setStroke(Color.TRANSPARENT); // Made invisible
        debugHitbox.setStrokeWidth(0);

        root = new Group();
        root.getChildren().addAll(view, debugHitbox);

        root.setLayoutX(startX);
        root.setLayoutY(startY);
    }

    public void update(double deltaTime) {
        if (!active) return;

        double effectiveSpeed = speed * 60;
        root.setLayoutX(root.getLayoutX() - effectiveSpeed * deltaTime);
        animate(deltaTime);
        updateDebugHitbox();
        cachedHitBox = debugHitbox.localToScene(debugHitbox.getBoundsInLocal());

        if (root.getLayoutX() + view.getBoundsInParent().getWidth() < 0) {
            active = false;
        }
    }
    
    private void updateDebugHitbox() {
        Bounds viewBounds = view.getBoundsInParent();
        
        double shrinkX = viewBounds.getWidth() * getHitboxShrinkX();
        double shrinkYTop = viewBounds.getHeight() * getHitboxShrinkYTop();
        double shrinkYBottom = viewBounds.getHeight() * getHitboxShrinkYBottom();
        
        debugHitbox.setX(viewBounds.getMinX() + shrinkX);
        debugHitbox.setY(viewBounds.getMinY() + shrinkYTop);
        debugHitbox.setWidth(viewBounds.getWidth() - shrinkX * 2);
        debugHitbox.setHeight(viewBounds.getHeight() - shrinkYTop - shrinkYBottom);
    }

    // Time-based flap so the animation cadence stays correct at any refresh
    // rate (60 Hz vs 144 Hz). Threshold preserved at the original 30 frames
    // (0.5 s per flap) so existing visual behaviour is unchanged.
    protected void animate(double deltaTime) {
        flapAccumulator += deltaTime;
        boolean frameJustToggled = false;

        if (flapAccumulator >= 30.0 / 60.0) {
            flapAccumulator -= 30.0 / 60.0;
            toggleFrame = !toggleFrame;
            frameJustToggled = true;
        }

        if (frameJustToggled) {
            view.setImage(toggleFrame ? state1 : state2);
        }
    }

    // Default hitbox shrinking values (can be overridden by subclasses)
    protected int getAnimationSpeed() { return 12; }
    protected double getHitboxShrinkX() { return 0.2; }
    protected double getHitboxShrinkYTop() { return 0.2; } // Default shrink from top
    protected double getHitboxShrinkYBottom() { return 0.2; } // Default shrink from bottom

    public Bounds getHitBox() {
        if (cachedHitBox != null) return cachedHitBox;
        return debugHitbox.localToScene(debugHitbox.getBoundsInLocal());
    }

    public boolean isActive() { return active; }
    public boolean hasCollided() { return hasCollided; }
    public void markCollided() { hasCollided = true; }
    public Node getNode() { return root; }
}
