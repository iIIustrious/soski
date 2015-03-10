package engine;

import  java.awt.image.*;
import  java.awt.*;
import  java.util.*;
import  java.awt.geom.*;
import  java.io.*;

/**
 * class Layer -- a single display layer in the game
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract public class Layer {
    protected Point                     offset;
    protected java.util.List<Sprite>    sprite;
    protected int                       width, height;
    //protected Sprite                    player;
   // protected SurfaceTree               surfaces;

/**
 * Constructor for objects of class Layer
 */
    public Layer(int wC, int hC) {
        sprite = Collections.synchronizedList (new ArrayList<Sprite> (10));

        offset = new Point (0, 0);
       // surfaces = new SurfaceTree (wC, hC);
        }

    /**
     * Constructor that creates a layer with an offset
     * @param startPt
     * @param wC
     * @param hC
     */
    public Layer(Point startPt, int wC, int hC) {
        sprite = Collections.synchronizedList (new ArrayList<Sprite> (10));

        offset = startPt;
       // surfaces = new SurfaceTree (wC, hC);
        }

    abstract protected void loadImages (String fName, int maxRow, int maxColumn)
                                                            throws IOException;

    /**
     * Set the offset with a point
     * @param newPt
     */
    protected void setLocation (Point newPt) {
        offset = newPt;
        }

    protected void setLocation (int x, int y) {
        offset.x = x;
        offset.y = y;
        }

    /**
     * set the offset with x and y
     * @param pl
     */
    protected void setPlayer (Sprite pl) {
        //player = pl;
        }

    /**
     * adds a sprite to the layer
     * @param newSprite
     */
    protected void addSprite (Sprite newSprite) {
        sprite.add (newSprite);
        newSprite.layer = this;
    }

    /**
     * removes the sprite from the layer
     * @param oldSprite
     */
    protected void removeSprite (Sprite oldSprite) {
        oldSprite.layer = null;
        sprite.remove (oldSprite);
    }

    protected void removeAllSprites(){
        Sprite current = new Sprite();
        for (int i = sprite.size()-1;i >=0; i--){
            current = sprite.get(i);
            current.layer = null;
            sprite.remove(current);
        }
    }

    /**
     * adds a surface to the layer
     * @param newSurface
     */
   // protected void addSurface (Surface newSurface) {
       // surfaces.add (newSurface);
     //   }

    abstract protected void displayBackground (Graphics2D g);
    abstract protected void displayEntireBackground (Graphics2D g);
    abstract protected void display (Graphics2D g);
    abstract protected void dispose();
    }