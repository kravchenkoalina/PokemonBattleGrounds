import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *player needs to 
 * 1. walk around(in a fixed point, only the background scrolls)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends MainTrainer
{
    public Player(){
        // the player is initially facing front
        setImage("P-front.png");
    }

    public void act() 
    {   
        walk();
    } 

    /**
     * the method allows the player to walk around
     */
    public void walk(){ 
        Objects ob = new Objects();
        // only walks when the direction key is pressed and it is not at the edge
        if(Greenfoot.isKeyDown("down")&& scrollOnDirection(DOWN)){
            setImage("P-front.png");
            setLocation(getX(), getY() + 5);
            if ((Grass)getOneIntersectingObject (Grass.class) != null){
                changeWorld();
            }
        }
        else if(Greenfoot.isKeyDown("up")&& scrollOnDirection(UP)){
            setImage("P-back.png");
            setLocation(getX(), getY() - 5);
            
            if ((Grass)getOneIntersectingObject (Grass.class) != null){
                changeWorld();
            }
        }
        else if(Greenfoot.isKeyDown("right")&& scrollOnDirection(RIGHT)){
            setImage("p-right.png");
            setLocation(getX() + 5, getY());       
            
            if ((Grass)getOneIntersectingObject (Grass.class) != null){
                changeWorld();
            }
        }
        else if (Greenfoot.isKeyDown("left")&& scrollOnDirection(LEFT)){
            setImage("p-left.png");
            setLocation(getX() - 5, getY());
            
            if ((Grass)getOneIntersectingObject (Grass.class) != null){
                changeWorld();
            }
        }

    }

    public void changeWorld(){
        if (Greenfoot.getRandomNumber(100) <= 2){
            GreenfootImage lighterGrass = new GreenfootImage("grass 2x2 lighter.png");
            setImage(lighterGrass);
            TrainerBattleWorld w = new TrainerBattleWorld(((ScrollingWorld)getWorld()).locationX,((ScrollingWorld)getWorld()).locationY, "grass");
            Greenfoot.setWorld(w);
        }
    }
}
