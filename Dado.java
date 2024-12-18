import greenfoot.*;

public class Dado extends Actor {
    private GreenfootImage[] ladosRolando;
    private GreenfootImage[] ladosFinal;
    private boolean rolando = true;
    private long tempoInicial;
    private final int duracaoRolagem = 5000;
    private int intervaloTroca = 200;
    private long ultimoTroca;

    public Dado() {
        ladosRolando = carregarLados("rolandoDados.png");
        ladosFinal = carregarLados("dado.png");


        setImage(ladosRolando[0]);
        tempoInicial = System.currentTimeMillis();
        ultimoTroca = tempoInicial;
    }

    public void act() {
        if (rolando) {
            rolarDado();
        }
    }

    private void rolarDado() {
        long tempoAtual = System.currentTimeMillis();
        long tempoDecorrido = tempoAtual - tempoInicial;

        if (tempoDecorrido < duracaoRolagem) {
            if (tempoAtual - ultimoTroca >= intervaloTroca) {
                int ladoAtual = Greenfoot.getRandomNumber(6);
                setImage(ladosRolando[ladoAtual]);
                ultimoTroca = tempoAtual;
            }
        } else {
            rolando = false;
            int ladoFinal = Greenfoot.getRandomNumber(6);
            setImage(ladosFinal[ladoFinal]);
            
            ((RolandoDado) getWorld()).exibirBotao();
        }
    }

    private GreenfootImage[] carregarLados(String nomeImagem) {
        GreenfootImage imagemOriginal = new GreenfootImage(nomeImagem);
        int larguraLado = 168 / 6;
        int alturaLado = 24;

        GreenfootImage[] lados = new GreenfootImage[6];
        for (int i = 0; i < 6; i++) {
            lados[i] = new GreenfootImage(larguraLado, alturaLado);
            lados[i].drawImage(imagemOriginal, -(i * larguraLado), 0);
        }

        return lados;
    }
}
