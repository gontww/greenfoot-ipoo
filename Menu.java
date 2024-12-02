import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    public Menu() {
        super(400, 300, 1);
        adicionarBotoes();
    }

    private void adicionarBotoes() {
        addObject(new BotaoStart(), 200, 100);
    }
}
