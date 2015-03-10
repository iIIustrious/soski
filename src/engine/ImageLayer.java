package engine;

import  java.awt.image.*;
import  java.awt.*;
import  java.util.*;
import  java.awt.geom.*;
import  java.io.*;

/**
 * class ImageLayer -- a single display layer in the game.  The background image
 *      is a single image.  This is suitable only for those games where the
 *      background is comparable in size to the screen
 *
 * @author  (Brian Brookwell)
 * @version (2011-01-13)
 */
public class ImageLayer extends Layer {
    protected ManagedImage  background;

/**
 * Constructor for objects of class ImageLayer
 *
 * @param   wC  Width of each cell in pixels
 * @param   hC  Height of each cell in pixels
 */
    public ImageLayer(int wC, int hC) {
        super (wC, hC);
        background = null;
        }

/**
 * Constructor for objects of class ImageLayer
 *
 * @param   wC          Width of each cell in pixels
 * @param   hC          Height of each cell in pixels
 * @param   startPt     Location of upper left corner of image[0][0]
 */
    public ImageLayer(Point startPt, int wC, int hC) {
        super(startPt, wC, hC);
        background = null;
        }

@Override
protected void dispose(){
        ManagedImageFactory.dispose (background);
    }
/**
 * loadImages -- loads the background image from a file on the hard disk.
 *
 * @param   fName       Base file name of the image set
 * @param   maxRow      Number of rows of cells in layer (ignored)
 * @param   maxColumn   Number of columns of cells in layer (ignored)
 */
    protected void loadImages (String fName, int maxRow, int maxColumn) throws IOException {
        if (background != null)
            ManagedImageFactory.dispose (background);
        background = ManagedImageFactory.get (fName);
        }

/**
 * displayBackground -- Redisplays the background image
 *
 * @param   g       Graphics object to display background changes to
 */
    protected void displayBackground (Graphics2D g) {
        background.display (g, -offset.x, -offset.y);
        }

/**
 * displayEntireBackground -- erases all visible cells
 *
 * @param   g       Graphics object to display background changes to
 */
    protected void displayEntireBackground (Graphics2D g) {
        background.display (g, -offset.x, -offset.y);
        }

/**
 * display -- rebuilds the background and draws the Sprites onto it
 *
 * @param   g   Graphics object to display to
 */
    synchronized protected void display (Graphics2D g) {
        displayBackground (g);

        switch (Constants.centering) {
        case Constants.NOT_PLAYER_CENTERED:
                    offset.x = 0;
                    offset.y = 0;
                    break;
        case Constants.PLAYER_CENTERED_X:
//                    offset.x = (int)(Constants.centerX - player.location.x + 0.5);
//                    offset.y = 0;
//                    break;
        case Constants.PLAYER_CENTERED_Y:
//                    offset.y = (int)(Constants.centerY - player.location.y + 0.5);
//                    offset.x = 0;
//                    break;
        case Constants.PLAYER_CENTERED_X | Constants.PLAYER_CENTERED_Y:
//                    offset.x = (int)(Constants.centerX - player.location.x + 0.5);
//                    offset.y = (int)(Constants.centerY - player.location.y + 0.5);
//                    break;
                }

        for (Sprite current: sprite)
            current.display (g, offset);
        }
   }