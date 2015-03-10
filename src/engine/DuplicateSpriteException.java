package engine;


/**
 * Write a description of class DuplicateSpriteException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DuplicateSpriteException extends Exception {

    /**
     * Constructor for objects of class DuplicateSpriteException
     */
    public DuplicateSpriteException() {
        super ("Duplicate Sprite in Sprite Group");
        }

    /**
     * Constructor for objects of class DuplicateSpriteException
     */
    public DuplicateSpriteException(String str) {
        super ("Duplicate Sprite in Sprite Group: " + str);
        }
    }