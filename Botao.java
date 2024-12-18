import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Botao extends HUD
{   
    public abstract void executarAcao();
    
    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            executarAcao();
        }
    }
}
