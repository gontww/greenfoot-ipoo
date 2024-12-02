import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogador extends Entidades
{
    // PARADO
    private static GreenfootImage[] PARADO_DIREITA = { new GreenfootImage("jogador_direita1.png") };
    private static GreenfootImage[] PARADO_ESQUERDA = { new GreenfootImage("jogador_esquerda1.png") };

    // ANDANDO PARA ESQUERDA
    private static GreenfootImage [] ESQUERDA = {
        new GreenfootImage("jogador_esquerda1.png"),
        new GreenfootImage("jogador_esquerda2.png"),
        new GreenfootImage("jogador_esquerda3.png")};
    // ANDANDO PARA DIREITA 
    private static GreenfootImage[] DIREITA = {
        new GreenfootImage("jogador_direita1.png"),
        new GreenfootImage("jogador_direita2.png"),
        new GreenfootImage("jogador_direita3.png")};
    // CAINDO
    private static GreenfootImage [] CAINDODIREITA = {
        new GreenfootImage("jogador_direita_caindo.png")};
    private static GreenfootImage [] CAINDOESQUERDA = {
        new GreenfootImage("jogador_esquerda_caindo.png")};
    // PULANDO
    private static GreenfootImage [] PULANDODIREITA = {
        new GreenfootImage("jogador_direita_pulo.png")};
    private static GreenfootImage [] PULANDOESQUERDA = {
        new GreenfootImage("jogador_esquerda_pulo.png")};
    private static GreenfootImage [] animacao;

    private boolean olhandoEsquerda;
    
    private int frame = 0;
    private int skipRate = 7;
    private int contadorAct = 0;
    
     private int velocidadeMovimento = 5;
    
    public void act() {
        contadorAct++;
        atualizarAnimacao();
        setarAnimacao();
        verificarMovimento();
        aplicarGravidade();
        
    }
    
    public void verificarMovimento(){
        if (Greenfoot.isKeyDown("a")) {  // Movimenta para a esquerda
            setLocation(getX() - velocidadeMovimento, getY());
            olhandoEsquerda = true;
        } else if (Greenfoot.isKeyDown("d")) {  // Movimenta para a direita
            setLocation(getX() + velocidadeMovimento, getY());
            olhandoEsquerda = false;
        }

        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) {
            pular();  // Faz o personagem pular
        }
    }
    
    public boolean olhandoParaDireita()
    {
        if(animacao == DIREITA || animacao == PULANDODIREITA || animacao == CAINDODIREITA)
        {
            return true;
        }
        else
        {
            olhandoEsquerda = true;
            return false;
        }
    }
    
    public void animacaoDeGravidade() {
        if (gravidade < 0) {
            if (olhandoParaDireita()) {
                animacao = PULANDODIREITA;
            } else {
                animacao = PULANDOESQUERDA;
            }
        }
        else if (gravidade > 0 && !emChao) {
            if (olhandoParaDireita()) {
                animacao = CAINDODIREITA;
            } else {
                animacao = CAINDOESQUERDA;
            }
        }
    
        if (isTouching(Plataforma.class)) {
            if (olhandoParaDireita()) {
                animacao = DIREITA;
            } else {
                animacao = ESQUERDA;
            }
        }
    }

    public void atualizarAnimacao() {
        if (Greenfoot.isKeyDown("w")) { // Pulando
            if (Greenfoot.isKeyDown("d")) {
                animacao = PULANDODIREITA;
                olhandoEsquerda = false; // Atualiza a direção para direita
            } else if (Greenfoot.isKeyDown("a")) {
                animacao = PULANDOESQUERDA;
                olhandoEsquerda = true; // Atualiza a direção para esquerda
            }
        } else if (Greenfoot.isKeyDown("a")) { // Andando para a esquerda
            animacao = ESQUERDA;
            skipRate = 7;
        } else if (Greenfoot.isKeyDown("d")) { // Andando para a direita
            animacao = DIREITA;
            skipRate = 7;
        } else if (gravidade > 0 && !emChao) { // Caindo
            if (olhandoParaDireita()) {
                animacao = CAINDODIREITA;
            } else {
                animacao = CAINDOESQUERDA;
            }
        } else { // Parado
            frame = 0; // Reseta a animação ao estado inicial
            if (olhandoParaDireita()) {
                animacao = DIREITA;
            } else {
                animacao = ESQUERDA;
            }
        }
    }

    public void setarAnimacao() {
        if(animar()) {
            if(frame >= animacao.length) {
                frame = 0;
            }
            setImagem(animacao[frame]);
            frame++;
        }
    }
    
    private boolean animar() {
        return contadorAct % skipRate == 0;
    }
    
}
