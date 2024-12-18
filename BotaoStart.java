import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoStart extends Botao
{
    public BotaoStart() {
        GreenfootImage imagem = getImage();
        imagem.scale(30, 30);
        setImage(imagem);
    }

    @Override
    public void executarAcao() {
        Greenfoot.setWorld(new RolandoDado());
    }
}
