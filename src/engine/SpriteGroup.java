package engine;

import java.util.ArrayList;

/**
 * Holds an array of all of your sprites, and allows easy updating of them all at once.
 * Add them here as you add them to the screen, and remove them when you no longer want them to be updated.
 *
 * @author Jordan Thompson
 * @version 1.1
 */


/*Notes:
 *  you may want to implement a has hit function that checks all of the sprites on screen for collisions with eachother.
 * This may end up too slow, and you may just want to handle collisions with the likely sprites.
 */
public class SpriteGroup {
    protected ArrayList<Sprite> list;
    /**
     * Constructor for objects of class SpriteGroup
     */
    public SpriteGroup(int size) {
        list = new ArrayList<Sprite> (size);
        }

        /**
         * Adds a sprite to the group as long as it hasn't been already
         * @param newSp
         * @throws DuplicateSpriteException
         */
    synchronized public void add (Sprite newSp) throws DuplicateSpriteException  {
        if (list.contains (newSp))
            throw new DuplicateSpriteException();

        list.add (newSp);
        }
        /**
         * removes the sprite from the array
         * @param sp
         */
    synchronized public void remove (Sprite sp) {
        list.remove (sp);
        }

    /**
     * Updates every sprite in the sprite group.
     */

    public void updates () {
        for (Sprite current: list)
            current.update();
        }

    /**
     * calls dispose on each sprite and then removes it. does not currently work, may later
     */
    public synchronized void disposeAll(){
        Sprite current = new Sprite();
        for (int i = list.size()-1; i >=0;i--){
            if(!list.isEmpty()){
                current = list.get(i);
                if(current != null){
                    if(current.layer != null){
                        current.layer.removeSprite(current);
                    }
                    SpriteFactory.dispose(current);
                    list.remove(current);
                }
            }
        }
            
   }
    }