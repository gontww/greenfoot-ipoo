import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoCriarMundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoCriarMundo extends Botao
{
    /**
     * Act - do whatever the BotaoCriarMundo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Mundo1());
        }
    }
    
    @Override
    public void executarAcao() {
        Greenfoot.setWorld(new Mundo1());
    }
    
    public BotaoCriarMundo(){
        GreenfootImage imagem = getImage();
        imagem.scale(30, 30);
        setImage(imagem);
    }
}
