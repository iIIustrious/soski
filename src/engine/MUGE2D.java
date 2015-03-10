package engine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import java.awt.event.*;
import  java.io.IOException;

/**
 * class MUGE2D -- Primary driver class for game.  It consists of the main
 * program for the game plus the primary display loop
 *
 * @author  (Brian Brookwell)
 * @version (2010-04-26)
 */
/*  Attribute       Description
 *
 *  sFactory        Factory for all Sprites in the Game
 *  pFactory        Factory for all Points in the Game
 *  miFactory       Factory for all Managed Images in the Game
 *  stillRunning    Flag used to control execution of the game Thread
 *  layers          List of Layers that make up the game (At least one)
 *  timer           Running thread handling the display of the game
 */
public class MUGE2D extends Frame implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    protected SpriteFactory             sFactory;
    protected PointFactory              pFactory;
    protected ManagedImageFactory       miFactory;
    public static boolean                   stillRunning = false;
    protected static java.util.List<Layer>     layers;
    protected Thread                    timer;
    protected Point                     location;
    protected static SpriteGroup               sGroup;
    protected static Sprite                    aSprite;
    protected int                       ANIMATIONS = 7;
    public static boolean                      COLLIDING = false;
    public static boolean                      LISTENING = false;
    public static int                  currentMapCellX;
    public static int                  currentMapCellY;

/**
 * Constructor for objects of class MUGE2D that generate a ColorLayer as the primary Layer
 *
 * @param   backColor   Color to use as the background
 * @param   tRows       Number of rows in the SurfaceTree
 * @param   tCols       Number of columns in the SurfaceTree
 * @param   sprites     Initial number of sprites in the SpriteFactory
 * @param   points      Initial number of points in the PointFactory
 * @param   images      Initial number of Managed Images in the ManagedImageFactory
 * @param   layerCount  Initial number of Layers in the Game
 */
    public MUGE2D (Color backColor, int tRows, int tCols, int sprites, int points,
                            int images, int layerCount) throws Exception {
        super();

        // Acquire system constants
        new Constants();
        currentMapCellX = 3;
        currentMapCellY = 3;
        for(int i = 0; i < tRows; i++){

        }
        
        // Create object factories and image layer list
        layers = Collections.synchronizedList (new ArrayList<Layer> (layerCount));
        layers.add (new ColorLayer (tCols, tRows, backColor));
        setUpScreen(sprites, points, images);
        
        }

/**
 * Constructor for objects of class MUGE2D that generates an ImageLayer as the primary layer
 *
 * @param   backFile    File containing the image or image set for the layer
 * @param   tRows       Number of rows in the SurfaceTree
 * @param   tCols       Number of columns in the SurfaceTree
 * @param   sprites     Initial number of sprites in the SpriteFactory
 * @param   points      Initial number of points in the PointFactory
 * @param   images      Initial number of Managed Images in the ManagedImageFactory
 * @param   layerCount  Initial number of Layers in the Game
 */
    public MUGE2D (String backFile, int tRows, int tCols, int sprites, int points,
                            int images, int layerCount) throws Exception {
        super();

        // Acquire system constants
        new Constants();
        
        ImageLayer panel = new ImageLayer (tCols, tRows);
        panel.loadImages (backFile, 0, 0);

        // Create object factories and image layer list
        layers = Collections.synchronizedList (new ArrayList<Layer> (layerCount));
        layers.add (panel);

        setUpScreen(sprites, points, images);  
        }

/**
 * setUpScreen -- sets up all the game factories and the screen
 *
 * @param   sprites     Initial number of sprites in the SpriteFactory
 * @param   points      Initial number of points in the PointFactory
 * @param   images      Initial number of Managed Images in the ManagedImageFactory
 */
    protected void setUpScreen(int sprites, int points, int images) {
        Constants.centering = Constants.NOT_PLAYER_CENTERED;
        sFactory = new SpriteFactory (sprites);
        pFactory = new PointFactory (points);
        miFactory = new ManagedImageFactory (images);

        setUndecorated (Constants.isFullScreen);
        setResizable (!Constants.isFullScreen);
        setIgnoreRepaint (true);

        if (Constants.isFullScreen)
            Constants.device.setFullScreenWindow (this);

        // Choose the best display mode
        if (Constants.device.isDisplayChangeSupported ())
            chooseBestDisplayMode ();

        // Set up double Buffering
        createBufferStrategy (2);
        Constants.bufferStrategy = getBufferStrategy();

        BufferCapabilities.FlipContents flipContents =
                                Constants.bufferStrategy.getCapabilities().getFlipContents();

        System.out.println ("" + flipContents + " " + Constants.bufferStrategy);

        if (flipContents == BufferCapabilities.FlipContents.BACKGROUND)
            Constants.strategy = Constants.BACKGROUND;
        else if (flipContents == BufferCapabilities.FlipContents.COPIED)
            Constants.strategy = Constants.COPIED;
        else if (flipContents == BufferCapabilities.FlipContents.PRIOR)
            Constants.strategy = Constants.PRIOR;
        else
            Constants.strategy = Constants.UNDEFINED;
            
        sGroup = new SpriteGroup(sprites);
        stillRunning = true;
        timer = new Thread (this);
        //timer.start();

        }


/**
 * chooseBestDisplayMode -- sets the screen to the size with the best bit depth
 * of the maximum size.  This will choose a greater bit depth over size.  Thus,
 * a 1280 x 1024 screen in 16 bits would not be selected if a a 1024 x 800 in
 * 32 bits were available.
 */
/*  Variable        Description
 *
 *  mode            Array of display modes associated with the system
 *  bestMode        Display mode having the greatest size possible at the
 *                  highest bit depth
 */

    private void chooseBestDisplayMode() {
        DisplayMode mode[] = Constants.device.getDisplayModes();
        DisplayMode bestMode = new DisplayMode(640, 480, 32, 60);

//        for (int x = 0; x < mode.length; x++) {
//            if (bestMode == null)
//                bestMode = mode[x];
//            else if (mode[x].getBitDepth() > bestMode.getBitDepth())
//                bestMode = mode[x];
//            else if (mode[x].getBitDepth() == bestMode.getBitDepth()) {
//                if (mode[x].getWidth() > 1000 && mode[x].getWidth() < 1200)
//                    bestMode = mode[x];
//                else if (mode[x].getWidth() == bestMode.getWidth() &&
//                         mode[x].getHeight() < bestMode.getHeight()){
//                    bestMode = mode[x];
//                }
//                }
//            }
         String toPrint = Integer.toString(bestMode.getHeight()) + Integer.toString(bestMode.getWidth());
         System.out.println(toPrint);
        Constants.device.setDisplayMode(bestMode);
        Constants.screenWidth = bestMode.getWidth();
        Constants.screenHeight = bestMode.getHeight();

        Constants.centerX = bestMode.getWidth() >> 1;
        Constants.centerY = bestMode.getHeight() >> 1;
        }

    public void createCharacter(){
        String[] setNames = new String[7];
        setNames[0] = "alekStand";
        setNames[1] = "alekLeft";
        setNames[2] = "alekDown";
        setNames[3] = "alekRight";
        setNames[4] = "alekUp";
        setNames[5] = "alekRight";
        setNames[6] = "alekDown";
        int[] setNums = new int[7];
        setNums[0] = 1;
        setNums[1] = 2;
        setNums[2] = 2;
        setNums[3] = 2;
        setNums[4] = 2;
        setNums[5] = 2;
        setNums[6] = 2;


        addPerson(400,400, setNames, setNums, true);
//        aSprite = SpriteFactory.returnSprite();
//         try{
//        AnimationSet nothing[] = new AnimationSet[5];
//        nothing[0] = new AnimationSet("alekStand",1,true);
//        nothing[1] = new AnimationSet("alekLeft",2,true);
//        nothing[2] = new AnimationSet("alekDown",2,true);
//        nothing[3] = new AnimationSet("alekRight",2,true);
//        nothing[4] = new AnimationSet("alekUp",2,true);
//        aSprite.initialize(nothing,PointFactory.create(400, 400) , PointFactory.create(0, 0), 1.0, true, Constants.UNITS_PER_SECOND);
//        layers.get(1).addSprite(aSprite);
//        try{
//            sGroup.add(aSprite);
//             }
//             catch(DuplicateSpriteException e){}
//        }
//        catch (IOException e){System.out.println("failed\n"); return;}
    }

    public void addPerson(int startX, int startY, String[] setNames, int[] setNumbers, boolean isChar ){
        //assert setNames.length == ANIMATIONS;
        Sprite theSprite = SpriteFactory.returnSprite();
       // try{
            AnimationSet animations[] = new AnimationSet[ANIMATIONS];
            for (int i = 0; i < setNumbers.length; i++){
                try{
                     animations[i] = new AnimationSet(setNames[i], setNumbers[i], true);
                }catch(IOException e){System.out.print("wat\n");}
            }
            theSprite.initialize(animations, PointFactory.create(startX, startY), PointFactory.create(0, 0), 1.0, true, Constants.UNITS_PER_SECOND);
            layers.get(layers.size()-1).addSprite(theSprite);
//            try{
//                sGroup.add(theSprite);
//            }
//            catch(DuplicateSpriteException e){}
       // }
       // catch (IOException e){System.out.println("failed\n"); return;}
        if(isChar){aSprite = theSprite;}
    }


    public static void addLayer(String image){
        ImageLayer newImage = new ImageLayer(1, 1);
        try{
        newImage.loadImages(image, 1, 1);
        layers.add(newImage);}
        catch(IOException e){System.out.print("FAILED TO LOAD BACKGROUND\n");};
    }



    public static void newMap(String[] backs, Sprite[] sprites, double startx, double starty){
        //unloadMap();
        for(String current: backs){
            if (current != null){
                addLayer(current);
            }
        }
        layers.get(layers.size()-1).addSprite(aSprite);
        
        if (sprites != null){
             for (Sprite currentS: sprites){
                 if(currentS != null){
                    layers.get(1).addSprite(currentS);
                      try{
                         sGroup.add(currentS);
                        }
                        catch(DuplicateSpriteException e){}
                 }
                 }
        }
       // createCharacter();
        
        aSprite.location.x = startx;
        aSprite.location.y = starty;
        LISTENING = true;
    }

    public static synchronized void unloadMap(){
        aSprite.layer = null;
        for(Layer current: layers){
                        current.removeAllSprites();
                        current.dispose();
         }
        sGroup.disposeAll();
        LISTENING = false;
        layers.clear();
        
    }







/**
 * run -- handles the update of the screen, alternating between 'flip' buffers
 * to create smooth animation
 */
/*  Variable        Description
 *
 *  g               Graphics display object used to update the current back buffer
 */
    public void run() {
        int count = 5;
        Constants.Game = true;
        addKeyListener(this);
        

        //add all the on screen sprites
        


        //This is our main display and input loop
        while (stillRunning) {
            count --;

            //every few display cycles, we update the sprites position
            if(count == 1){              
                sGroup.updates();
                aSprite.update();
                count = 4;
            }

            //After the update, we do the collision detection this will not be here in the actual game, this is just for testing purposes
            if(COLLIDING == true){
                if(!layers.isEmpty() && !layers.get(1).sprite.isEmpty() ){
                     if(aSprite.location.x < 0){
                           //aSprite.location.x += (-aSprite.velocity.x);
                         SoSKi.moveMap(currentMapCellX-1, currentMapCellY, Constants.screenWidth - 20, aSprite.location.y);
                        }
                         if(aSprite.location.x > Constants.screenWidth ){
                          // aSprite.location.x += (-aSprite.velocity.x);
                             SoSKi.moveMap(currentMapCellX+1, currentMapCellY, 20, aSprite.location.y);
                        }
                        if(aSprite.location.y < 0){
                            // aSprite.location.y += (-aSprite.velocity.y);
                            SoSKi.moveMap(currentMapCellX, currentMapCellY-1, aSprite.location.x, Constants.screenHeight -20);
                        }
                         if(aSprite.location.y > Constants.screenHeight ){
                          // aSprite.location.y += (-aSprite.velocity.y);
                             SoSKi.moveMap(currentMapCellX, currentMapCellY+1, aSprite.location.x, 20);
                          }

                          for (Sprite current: sGroup.list){
                              if(aSprite.hasHit(current) && current != aSprite){
                                 aSprite.location.x += (-aSprite.velocity.x);
                                 aSprite.location.y += (-aSprite.velocity.y);
                              }
                          }

                }
            }
            if (Constants.Game){
                 if(Constants.keyDown.get(KeyEvent.VK_ESCAPE) )
                 {
                     addLayer("MENU.png");
                     String[] spr = new String[1];
                     spr[0] = "menuSprite";
                     int[] intspr = new int[1];
                     intspr[0] = 1;
                     addPerson((Constants.screenWidth/2) , (Constants.screenHeight/2), spr, intspr, false );
                     spr[0] = "alekLeft";
                     addPerson((Constants.screenWidth/2) -100 , (Constants.screenHeight/2) -75, spr, intspr, false);
                     //MUGE2D.stillRunning = false;
                     Constants.Game = false;
                     Constants.Menu = true;
                    Constants.MenuX = 1;
                 }


                 if(MUGE2D.LISTENING == true){

                     if (Constants.keyDown.get(KeyEvent.VK_LEFT))
                     {   MUGE2D.aSprite.set[0].setImage(0);
                         MUGE2D.aSprite.action = 1;
                          MUGE2D.aSprite.velocity.x = -8;
                          MUGE2D.aSprite.velocity.y = 0;
                     }
                    else if(Constants.keyDown.get(KeyEvent.VK_DOWN))
                    {   MUGE2D.aSprite.set[0].setImage(0);
                        MUGE2D.aSprite.action = 2;
                        MUGE2D.aSprite.velocity.x = 0;
                        MUGE2D.aSprite.velocity.y = 8;
                    }
                     else if (Constants.keyDown.get(KeyEvent.VK_RIGHT)) {
                         MUGE2D.aSprite.set[0].setImage(0);
                         MUGE2D.aSprite.action = 3;
                         MUGE2D.aSprite.velocity.x = 8;
                         MUGE2D.aSprite.velocity.y = 0;
                     }
                     else  if (Constants.keyDown.get(KeyEvent.VK_UP)) {
                         MUGE2D.aSprite.set[0].setImage(0);
                         MUGE2D.aSprite.action = 4;
                         MUGE2D.aSprite.velocity.x = 0;
                         MUGE2D.aSprite.velocity.y = -8;
                     }
                     else{
                        if(MUGE2D.layers.get(1).sprite.isEmpty() == false){
                         MUGE2D.aSprite.action = 0;
                         MUGE2D.aSprite.velocity.x = 0;
                         MUGE2D.aSprite.velocity.y = 0;
                         }
                     }
                }
            }
            else if (Constants.Menu){
            

                if (Constants.keyDown.get(KeyEvent.VK_UP)) {
                    if(Constants.MenuX > 1){
                        layers.get(layers.size()-1).sprite.get(1).location.y -= 100;
                        Constants.MenuX--;
                    }
                }
                else if (Constants.keyDown.get(KeyEvent.VK_DOWN)) {
                    if(Constants.MenuX < Constants.MenuMaxX){
                        layers.get(layers.size()-1).sprite.get(1).location.y += 100;
                        Constants.MenuX++;
                    }
                }
                else if(Constants.keyDown.get(KeyEvent.VK_ENTER)){
                   if(Constants.MenuX == 2){
                       MUGE2D.stillRunning = false;
                   }
                   else if(Constants.MenuX == 1){
                       layers.get(layers.size()-1).removeAllSprites();
                       layers.remove(layers.size()-1);
                       Constants.Menu = false;
                       Constants.Game = true;
                   }
                }
             }

           
                //The display part of the loop
                long startTime = System.nanoTime();
                 if(!layers.isEmpty()){
                Graphics2D g = (Graphics2D)Constants.bufferStrategy.getDrawGraphics();

                if (Constants.bufferStrategy.contentsLost() || (Constants.strategy <= 0))
                    layers.get(0).displayEntireBackground(g);

                for (int i=0;i < layers.size();i++)
                    layers.get(i).display (g);

                Constants.bufferStrategy.show();
                g.dispose();
            }
           
            try {
                long toSleep = (33333333 - System.nanoTime() + startTime + 500000) / 1000000;
                if(toSleep > 0){
                    timer.sleep (toSleep);
                }
                } catch (InterruptedException ex) {
                    stillRunning = false;
                    }
            }
        Constants.device.setDisplayMode (Constants.oldDisplayMode);
        Constants.device.setFullScreenWindow (null);
        dispose();
        }

/**
 * keyPressed -- method used to handle KeyEvents for key press events
 *
 * @param   e   Keyevent being processed
 */
    public void keyPressed(KeyEvent e) {
        Constants.keyDown.set (e.getKeyCode());
        handleMetas (e);
        }

/**
 * keyReleased -- method used to handle KeyEvents for key release events
 *
 * @param   e   Keyevent being processed
 */
    public void keyReleased(KeyEvent e) {
        Constants.keyDown.clear (e.getKeyCode());
        handleMetas (e);
        }

/**
 * keyType -- method used to handle KeyEvents for key click events (unused)
 *
 * @param   e   Keyevent being processed
 */
    public void keyTyped(KeyEvent e) {}

/**
 * handleMouseButtons -- method used to process the left/right button mask bit to
 *              determine which button(s) are currently down
 *
 * @param   e   MouseEvent being processed
 */
    protected void handleMouseButtons(MouseEvent e) {
        Constants.leftMouse    = (e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0;
        Constants.rightMouse   = (e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0;
        }

/**
 * handleMetas -- method used to process the key mask bits to
 *              determine which meta keys are currently down
 *
 * @param   e   InputEvent being processed
 */
    protected void handleMetas(InputEvent e) {
        Constants.altDown     = (e.getModifiersEx() & MouseEvent.ALT_DOWN_MASK) != 0;
        Constants.ctrlDown    = (e.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) != 0;
        Constants.shiftDown   = (e.getModifiersEx() & MouseEvent.SHIFT_DOWN_MASK) != 0;
        Constants.metaDown    = (e.getModifiersEx() & MouseEvent.META_DOWN_MASK) != 0;
        }

/**
 * mouseClicked -- handles a mouse click event (Press + Release)
 *
 * @param   e   MouseEvent being processed
 */
    public void mouseClicked(MouseEvent e) {}

/**
 * mouseEntered -- handles a mouse moving into the frame (unused)
 *
 * @param   e   MouseEvent being processed
 */
    public void mouseEntered(MouseEvent e) {
        handleMouseButtons (e);
        handleMetas (e);
        }

/**
 * mouseExited -- handles a mouse moving out of the frame (unused)
 *
 * @param   e   MouseEvent being processed
 */
    public void mouseExited(MouseEvent e) {}

/**
 * mousePressed -- handles a mouse button being pressed
 *
 * @param   e   MouseEvent being processed
 */
    public void mousePressed(MouseEvent e) {
        handleMouseButtons (e);
        handleMetas (e);
        }

/**
 * mouseReleased -- handles a mouse button being released
 *
 * @param   e   MouseEvent being processed
 */
    public void mouseReleased(MouseEvent e) {
        handleMouseButtons (e);
        handleMetas (e);
        }

/**
 * mouseDragged -- handles a mouse drag event.
 *
 * @param   e   MouseEvent being processed
 */

    public void mouseDragged(MouseEvent e) {
        Constants.mouse.x = e.getX();
        Constants.mouse.y = e.getY();

        handleMouseButtons (e);
        handleMetas (e);
        }

/**
 * mouseMoved -- handles a mouse move event.
 *
 * @param   e   MouseEvent being processed
 */

    public void mouseMoved(MouseEvent e) {
        Constants.mouse.x = e.getX();
        Constants.mouse.y = e.getY();

        handleMouseButtons (e);
        handleMetas (e);
        }
/**
 * main -- main program that sets up the main GameFrame
 *
 * @param   param   Array of parameters...ignored
 */

    }