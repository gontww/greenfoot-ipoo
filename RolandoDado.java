import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RolandoDado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RolandoDado extends World
{

    /**
     * Constructor for objects of class RolandoDado.
     * 
     */
    public RolandoDado()
    {    
        super(400, 300, 1); 
        addObject(new Dado(), 152, 100);
    }
    
    public void exibirBotao(){
        addObject(new Continuar(), 100, 270);
        addObject(new BotaoCriarMundo(), 200, 270);
    }
}
