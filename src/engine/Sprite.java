package engine;

import  java.awt.*;
import  java.awt.geom.Point2D;
import  java.awt.geom.Point2D.Double;

/**
 * class Sprite -- parent class for each component in the game.
 *
 * @author  (Brian Brookwell)
 * @version (20100426)
 */
/*  Attribute       Description
 *
 *  location        2D Location for the center of the sprite
 *  velocity        2D velocity vector for the sprite
 *  acceleration    2D acceleration for the sprite
 *  action          Index of the action being performed by Sprite
 *  type            Motion type of the Sprite (see Constants)
 *  lastLocation    Last display location of the sprite
 *  radius          Collision radius of the sprite
 *  drag            Fluid drag on the sprite
 *  layer           Layer that contains this Sprite
 */
public class Sprite {
    protected Point2D.Double    location, velocity, acceleration;
    protected AnimationSet      set[];
    protected boolean           visible, collidable;
    protected int               action, type;
    protected Point             lastLocation;
    protected double            radius, drag;
    protected Layer             layer;
    protected Rectangle         bounding;
/**
 * Constructor for objects of class Sprite
 */
    public Sprite() {}

/**
 * initialize -- sets up a sprite's internal data for an immobile
 *               sprite.
 *
 * @param   s       Array of Animation Set objects for the Sprite
 * @param   loc     Location for the sprite
 * @param   r       Radius of circle defining collision hull
 * @param   coll    Allow collision detection
 */
    synchronized public void initialize (AnimationSet s[],
                                Point2D.Double loc, double r,
                                boolean coll) {
        set      = s;
        location = loc;
        lastLocation = new Point();
        radius   = r;
        bounding = new Rectangle((int)(location.x - (set[0].getWidth()/2)),(int)(location.y - (set[0].getHeight()/2)), (int)set[0].getWidth(),(int)set[0].getHeight());
        type = Constants.STATIC;

        collidable = coll;
        }

/**
 * initialize -- sets up a sprite's internal data for a fixed speed
 *               sprite.
 *
 * @param   s       Array of Animation Set objects for the Sprite
 * @param   loc     Location for the sprite
 * @param   vel     Velocity for the sprite
 * @param   r       Radius of circle defining collision hull
 * @param   coll    Allow collision detection
 * @param   units    UNITS_PER_FRAME or UNITS_PER_SECOND;
 */

    synchronized public void initialize (AnimationSet s[],
                                Point2D.Double loc, Point2D.Double vel,
                                double r, boolean coll, int units) {
        set = s;

        location = loc;
        lastLocation = new Point();
        velocity = vel;
        if (units == Constants.UNITS_PER_SECOND) {
            velocity.x *= Constants.secondsPerUpdate;
            velocity.y *= Constants.secondsPerUpdate;
            }
        radius   = r;
        bounding = new Rectangle((int)(location.x - (set[0].getWidth()/2)),(int)(location.y - (set[0].getHeight()/2)), (int)set[0].getWidth(),(int)set[0].getHeight());
        type = Constants.MOVING;

        collidable = coll;
        }
/**
 * initialize -- sets up a sprite's internal data for a fixed speed
 *               sprite.
 *
 * @param   s       Array of Animation Set objects for the Sprite
 * @param   loc     Location for the sprite
 * @param   vel     Velocity for the sprite
 * @param   acc     Acceleration for the sprite
 * @param   r       Radius of circle defining collision hull
 * @param   drg     Fluid drag on sprite
 * @param   coll    Allow collision detection
 * @param   units    UNITS_PER_FRAME or UNITS_PER_SECOND;
 */

    synchronized public void initialize (AnimationSet s[],
                                Point2D.Double loc, Point2D.Double vel,
                                Point2D.Double acc, double drg, double r,
                                boolean coll, int units) {
        set = s;

        location = loc;
        lastLocation = new Point();
        velocity = vel;
        acceleration = acc;
        if (units == Constants.UNITS_PER_SECOND) {
            velocity.x *= Constants.secondsPerUpdate;
            velocity.y *= Constants.secondsPerUpdate;

            acceleration.x *= Constants.secondsPerUpdate;
            acceleration.y *= Constants.secondsPerUpdate;
            }
        radius = r;
        bounding = new Rectangle((int)(location.x - (set[0].getWidth()/2)),(int)(location.y - (set[0].getHeight()/2)), (int)set[0].getWidth(),(int)set[0].getHeight());
        type = Constants.IN_FLUID;;

        collidable = coll;

        drag = drg;
        }
/**
 * initialize -- sets up a sprite's internal data for a fixed speed
 *               sprite.
 *
 * @param   s       Array of Animation Set objects for the Sprite
 * @param   loc     Location for the sprite
 * @param   vel     Velocity for the sprite
 * @param   acc     Acceleration for the sprite
 * @param   r       Radius of circle defining collision hull
 * @param   coll    Allow collision detection
 * @param   units    UNITS_PER_FRAME or UNITS_PER_SECOND;
 */

    synchronized public void initialize (AnimationSet s[],
                                Point2D.Double loc, Point2D.Double vel,
                                Point2D.Double acc, double r,
                                boolean coll, int units) {
        set = s;

        location = loc;
        lastLocation = new Point();
        velocity = vel;
        acceleration = acc;
        if (units == Constants.UNITS_PER_SECOND) {
            velocity.x *= Constants.secondsPerUpdate;
            velocity.y *= Constants.secondsPerUpdate;

            acceleration.x *= Constants.secondsPerUpdate;
            acceleration.y *= Constants.secondsPerUpdate;
            }
        radius = r;
           bounding = new Rectangle((int)(location.x - (set[0].getWidth()/2)),(int)(location.y - (set[0].getHeight()/2)), (int)set[0].getWidth(),(int)set[0].getHeight());
        type = Constants.IN_FLUID;

        collidable = coll;
        }

/**
 * display -- displays the current sprite's image at it's current location
 *
 * @param   g   Graphics object to display the sprite image to
 */
    synchronized protected void display (Graphics2D g, Point offset) {
        lastLocation.x = (int)(0.5 + location.x + offset.x -
                                    0.5 * set[action].getWidth());
        lastLocation.y = (int)(0.5 + location.y + offset.y -
                                    0.5 * set[action].getHeight());

        set[action].display (g, lastLocation.x, lastLocation.y);
//           g.setPaint(Color.RED);
//           //   g.fill(bounding);
//              g.draw(bounding);
//             g.setPaint(Color.BLUE);
        }

/**
 * update -- updates the sprite's image and and position
 */
    synchronized protected void update() {
        //if(action != 0){
            set[action].nextImage();
        //}
        switch (type) {
        case Constants.IN_FLUID:
                    double vSquared = velocity.x * velocity.x +
                                        velocity.y * velocity.y;
                    double vAcc = drag * vSquared;
                    double aX, aY;
                    double v = 1.0 / Math.sqrt (vSquared);

                    aX = acceleration.x - vAcc * velocity.x * v;
                    aY = acceleration.y - vAcc * velocity.y * v;

                    location.x += velocity.x + 0.5 * aX;
                    location.y += velocity.y + 0.5 * aY;

                    velocity.x += aX;
                    velocity.y += aY;
                    break;

        case Constants.ACCELERATED:
                    location.x += velocity.x + 0.5 * acceleration.x;
                    location.y += velocity.y + 0.5 * acceleration.y;

                    velocity.x += acceleration.x;
                    velocity.y += acceleration.y;
                    break;

        case Constants.MOVING:location.x += velocity.x;
                    location.y += velocity.y;

        default:    break;
            }
        bounding.setLocation((int)location.x - (set[action].getWidth()/2), (int)(location.y - (set[action].getHeight()/2)));
        bounding.setSize(set[action].getWidth()-9, set[action].getHeight()-9);
        }

/**
 * hasHit -- determines whether two Sprites have collided.
 *
 * @param   other   Sprite being tested against this one
 */
    protected boolean hasHit (Sprite other) {
        if (collidable && other.collidable) {
            return bounding.intersects(other.bounding);
            }
        return false;
        }

/**
 * getWidth -- returns the current width of the Sprite's image
 */
    protected int getWidth() {
        return set[action].getWidth();
        }

/**
 * getHeight -- returns the current height of the Sprite's image
 */
    protected int getHeight() {
        return set[action].getHeight();
        }

/**
 * dispose -- frees all main and volatile memory for a Sprite
 */
    synchronized protected void dispose() {
        switch (type) {
        case Constants.IN_FLUID:
        case Constants.ACCELERATED: PointFactory.dispose (acceleration);
        case Constants.MOVING:      PointFactory.dispose (velocity);
        case Constants.STATIC:      PointFactory.dispose (location);
            }
        if(set != null){
        for (int i=0;i < set.length;i++)
            if(set[i].image != null){
                set[i].dispose();
            }
        }

        set = null;
        location = null;
        velocity = null;
        acceleration = null;
        }
    }