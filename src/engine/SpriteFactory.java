package engine;

import  java.util.*;

/**
 * class SpriteFactory -- handles the creation and disposal of Sprite objects
 * in a way designed to minimize garbage collection.
 *
 * @author  (Brian Brookwell)
 * @version (2010-10-20)
 */
public class SpriteFactory {
    protected static ArrayList<Sprite> list;

/**
 * Constructor for objects of class SpriteFactory
 *
 * @param   sz  Original number of Sprite objects to create
 */
    public SpriteFactory(int sz){
        list = new ArrayList<Sprite> (sz);

        for (int i=0;i < sz;i++)
            list.add (new Sprite());
        }

/**
 * returnSprite -- gets an empty Sprite object for further processing
 */
    synchronized public static Sprite returnSprite() {
        Sprite sp;

        if (list.size() > 0)
            sp = list.remove (list.size() - 1);
        else
            sp = new Sprite();

        sp.location = null;
        sp.velocity = null;
        sp.acceleration = null;
        sp.set = null;

        return sp;
        }
/**
 * create -- returns an immobile Sprite (or allcoates a new one as need)
 */
    synchronized static public Sprite create (AnimationSet s[], double x, double y,
                                    double r, boolean collidable) {
        Sprite sp = returnSprite();

        sp.initialize (s, PointFactory.create (x, y), r, collidable);

        return sp;
        }

/**
 * create -- returns a linear motion Sprite (or allocates a new one as need)
 */
    synchronized static public Sprite create (AnimationSet s[], double x, double y,
                                    double vX, double vY, double r,
                                    boolean collidable, int type) {
        Sprite sp = returnSprite();

        sp.initialize (s, PointFactory.create (x, y), PointFactory.create (vX, vY),
                                        r, collidable, type);

        return sp;
        }


/**
 * create -- returns an accelerated motion Sprite (or allcoates a new one as need)
 */
    synchronized static public Sprite create (AnimationSet s[], double x, double y,
                                    double vX, double vY, double aX, double aY,
                                    double r, boolean collidable, int type) {
        Sprite sp = returnSprite();

        sp.initialize (s, PointFactory.create (x, y), PointFactory.create (vX, vY),
                            PointFactory.create (aX, aY), r, collidable, type);

        return sp;
        }

/**
 * create -- returns an fluid drag motion Sprite (or allcoates a new one as need)
 */
    synchronized static public Sprite create (AnimationSet s[], double x, double y,
                                    double vX, double vY, double aX, double aY,
                                    double r, boolean collidable, double drg, int type) {
        Sprite sp = returnSprite();

        sp.initialize (s, PointFactory.create (x, y), PointFactory.create (vX, vY),
                            PointFactory.create (aX, aY), drg, r, collidable, type);

        return sp;
        }
/**
 * dispose -- Returns a Sprite to the SpriteFactory available list
 *
 * @param   s   Sprite being disposed
 */
    static synchronized public void dispose (Sprite s) {
        s.dispose();

        list.add (s);
        }

/**
 * dispose -- Frees all storage associated with the SpriteFactory to prevent
 *            memmory leaks.
 *
 * @param   s   Sprite being disposed
 */
    public void dispose () {
        for (int s=0;s < list.size();s++)
            list.remove (list.size() - 1);

        list = null;
        }
    }