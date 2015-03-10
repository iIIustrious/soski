

package engine;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import java.awt.event.*;
import  java.io.IOException;

/**
 *
 * @author Jack
 */
public class SoSKi {

    protected static void cell11(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(150, 150), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    protected static void cell12(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(250, 250), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    protected static void cell13(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(350, 350), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    protected static void cell14(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(350, 550), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    protected static void cell21(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(450, 950), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    protected static void cell22(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(450, 250), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("shrub",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell23(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("shrub",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(150, 150), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("shrub",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(550, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "wilderness.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell24(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite rockSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("rock",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            rockSprite.initialize(nothing,PointFactory.create(550, 350), 1.0, true);
            newSprites[0] = rockSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        AnimationSet nothing2[] = new AnimationSet[1];
         try{
        nothing2[0] = new AnimationSet("rock",1,true);
        }
         catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing2[0] != null){
            redSprite2.initialize(nothing2,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("rock",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(550, 150), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell31(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

       

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell32(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(50, 50), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
         AnimationSet nothing2[] = new AnimationSet[1];
         try{
        nothing2[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing2[0] != null){
            redSprite2.initialize(nothing2,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("shrub",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(90, 350), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "dirt.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell33(double locationX, double locationY){
        MUGE2D.unloadMap();
        
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("rock",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(150, 150), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        AnimationSet nothing2[] = new AnimationSet[1];
         try{
        nothing2[0] = new AnimationSet("rock",1,true);
        } catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing2[0] != null){
            redSprite2.initialize(nothing2,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("rock",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell34(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("rock",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(150, 150), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        AnimationSet nothing2[] = new AnimationSet[1];
         try{
        nothing2[0] = new AnimationSet("rock",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing2[0] != null){
            redSprite2.initialize(nothing2,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("rock",1,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(50, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "war.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }
    protected static void cell35(double locationX, double locationY){
        MUGE2D.unloadMap();
        Sprite[] newSprites = new Sprite[3];

        Sprite redSprite = SpriteFactory.returnSprite();
        AnimationSet nothing[] = new AnimationSet[1];
         try{
        nothing[0] = new AnimationSet("red",1,true);
        }

        catch (IOException e){System.out.println("failed\n"); return;}
        if(nothing[0] != null){
            redSprite.initialize(nothing,PointFactory.create(650, 650), 1.0, true);
            newSprites[0] = redSprite;
        }


        Sprite redSprite2 = SpriteFactory.returnSprite();
        if(nothing[0] != null){
            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
            newSprites[1] = redSprite2;
        }


         Sprite newSprite = SpriteFactory.returnSprite();
         AnimationSet nothing3[] = new AnimationSet[1];
         try{
        nothing3[0] = new AnimationSet("otherDown",2,true);
    } catch (IOException e){System.out.println("failed\n"); return;}
         if(nothing3[0] != null){
            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
            newSprites[2] = newSprite;
         }

        String[] newLayers = new String[2];
        newLayers[0] = "BLUE.png";
        newLayers[1] = "background.png";
        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

    }

    public static void moveMap(int cellX, int cellY, double locationX, double locationY){
//        MUGE2D.unloadMap();
//        Sprite[] newSprites = new Sprite[3];
//
//        Sprite redSprite = SpriteFactory.returnSprite();
//        AnimationSet nothing[] = new AnimationSet[1];
//         try{
//        nothing[0] = new AnimationSet("red",1,true);
//        }
//
//        catch (IOException e){System.out.println("failed\n"); return;}
//        if(nothing[0] != null){
//            redSprite.initialize(nothing,PointFactory.create(650, 650), 1.0, true);
//            newSprites[0] = redSprite;
//        }
//
//
//        Sprite redSprite2 = SpriteFactory.returnSprite();
//        if(nothing[0] != null){
//            redSprite2.initialize(nothing,PointFactory.create(450, 450), 1.0, true);
//            newSprites[1] = redSprite2;
//        }
//
//
//         Sprite newSprite = SpriteFactory.returnSprite();
//         AnimationSet nothing3[] = new AnimationSet[1];
//         try{
//        nothing3[0] = new AnimationSet("otherDown",2,true);
//    } catch (IOException e){System.out.println("failed\n"); return;}
//         if(nothing3[0] != null){
//            newSprite.initialize(nothing3,PointFactory.create(650, 250), 1.0, true);
//            newSprites[2] = newSprite;
//         }
//
//        String[] newLayers = new String[2];
//        newLayers[0] = "BLUE.png";
//        newLayers[1] = "background.png";
//        MUGE2D.newMap(newLayers, newSprites, locationX, locationY );

        switch(cellX){
            case 1:
                switch(cellY){
                    case 1:
                        cell11(locationX, locationY);
                        MUGE2D.currentMapCellX = 1;
                        MUGE2D.currentMapCellY = 1;
                        return;

                    case 2:
                        cell12(locationX, locationY);
                        MUGE2D.currentMapCellX = 1;
                        MUGE2D.currentMapCellY = 2;
                        return;
                    case 3:
                        cell13(locationX, locationY);
                        MUGE2D.currentMapCellX = 1;
                        MUGE2D.currentMapCellY = 3;
                        return;
                    case 4:
                        cell14(locationX, locationY);
                        MUGE2D.currentMapCellX = 1;
                        MUGE2D.currentMapCellY = 4;
                        return;
                }

                break;
           case 2:
                switch(cellY){
                    case 1:
                        cell21(locationX, locationY);
                        MUGE2D.currentMapCellX = 2;
                        MUGE2D.currentMapCellY = 1;
                        return;

                    case 2:
                        cell22(locationX, locationY);
                        MUGE2D.currentMapCellX = 2;
                        MUGE2D.currentMapCellY = 2;
                        return;
                    case 3:
                        cell23(locationX, locationY);
                        MUGE2D.currentMapCellX = 2;
                        MUGE2D.currentMapCellY = 3;
                        return;
                    case 4:
                        cell24(locationX, locationY);
                        MUGE2D.currentMapCellX = 2;
                        MUGE2D.currentMapCellY = 4;
                        return;
                }

                break;

            case 3:
                switch(cellY){
                    case 1:
                        cell31(locationX, locationY);
                        MUGE2D.currentMapCellX = 3;
                        MUGE2D.currentMapCellY = 1;
                        return;

                    case 2:
                        cell32(locationX, locationY);
                        MUGE2D.currentMapCellX = 3;
                        MUGE2D.currentMapCellY = 2;
                        return;
                    case 3:
                        cell33(locationX, locationY);
                        MUGE2D.currentMapCellX = 3;
                        MUGE2D.currentMapCellY = 3;
                        return;
                    case 4:
                        cell34(locationX, locationY);
                        MUGE2D.currentMapCellX = 3;
                        MUGE2D.currentMapCellY = 4;
                        return;
                }

                break;

        }
        
    }



    public static void main (String param[]) throws Exception {
        MUGE2D game = new MUGE2D(Color.BLUE, 1, 1, 500, 200, 500, 100);
        game.addLayer("background.png");
        game.createCharacter();
       // cell33(MUGE2D.aSprite.location.x, MUGE2D.aSprite.location.y);
        game.COLLIDING = true;
        game.LISTENING = true;
        game.timer.start();
        game.setVisible (true);

        
        
    }

}
