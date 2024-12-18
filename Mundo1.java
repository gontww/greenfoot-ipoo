import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mundo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo1 extends World
{

    public Mundo1() {    
        super(400, 300, 1);
        adicionarTerreno();
        prepare();
    }

    private void adicionarTerreno() {
        int larguraSprite = 44;
        int numBlocos = (int) Math.ceil((double) getWidth() / larguraSprite);
        
        addObject(new Terra(), 300, 240);

        for (int i = 0; i < numBlocos; i++) {
            int posX = i * larguraSprite + larguraSprite / 2;
            int posY = getHeight() - larguraSprite / 2; 

            addObject(new Terra(), posX, posY);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Jogador jogador = new Jogador();
        addObject(jogador,20,231);
    }
}
