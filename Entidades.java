import greenfoot.*;

/**
 * Write a description of class Entidades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entidades extends Actor
{
    public double velocidadeY = 0;
    public double gravidade = 0.5;
    public double forcaDePulo = -10;
    public boolean emChao = false;

    public void aplicarGravidade() {
        if (!emChao) {
            velocidadeY += gravidade;
        }

        setLocation(getX(), getY() + (int) velocidadeY);

        if (isTouching(Plataforma.class)) {
            emChao = true;
            velocidadeY = 0;
            setLocation(getX(), getY());
        } else {
            emChao = false;
        }
    }

    public void pular() {
        if (emChao) {
            velocidadeY = forcaDePulo;
            emChao = false;
        }
    }
    
    public int getImgWidth()
    {
        return  getImage().getWidth();
    }
    public int getImgHeight()
    {
        return getImage().getHeight();
    }
}
