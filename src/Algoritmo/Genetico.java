package Algoritmo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author IDanielsFree
 */
public class Genetico {
    
    private int tamanhoPopulacao;
    private List<Individuo> populacao = new ArrayList<>();
    private int geracao;
    private Individuo melhorSolucao;

    public Genetico(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }
    
    public void inicializaPopulacao(List espacos, List valores, Double limiteEspacos) {
        
        for (int i = 0; i < this.tamanhoPopulacao; i++) {
            
            this.populacao.add(new Individuo(espacos, valores, limiteEspacos));
            
        }
        
        this.melhorSolucao = this.populacao.get(0);
        
    }
    
    public void melhorIndividuo(Individuo individuo) {
        
        if (individuo.getNotaAvaliacao() > this.melhorSolucao.getNotaAvaliacao()) {
            this.melhorSolucao = individuo;
        }
        
    }
    
    public Double somaAvaliacao() {
        
        Double soma = 0.0;
        
        for (Individuo individuo: this.populacao) {

            soma += individuo.getNotaAvaliacao();
            
        }
        
        return soma;
    }
    
    public int selecionaPai(Double somaAvaliacao) {
        
        int pai = -1;
        Double valorSorteado = Math.random() * somaAvaliacao;
        Double soma = 0.0;
        int i = 0;
        
        while (i<this.populacao.size() && soma < valorSorteado) {
            
            soma += this.populacao.get(i).getNotaAvaliacao();
            pai += 1;
            i += 1;
            
        }
        return pai;
    }
    
    public void visualizaGeracao() {
        Individuo melhor = this.populacao.get(0);
        System.out.println("G: " + melhor.getGeracao() + " Valor: " + melhor.getGeracao() + " Espaço: " + melhor.getNotaAvaliacao() + " Espaço: " + melhor.getEspacoUsado() + " Cromossomo: " + melhor.getCromossomo());
    }
    
    public List resolver(Double taxaMutacao, int numeroGeracoes, List espacos, List valores, Double limiteEspacos) {
        
        this.inicializaPopulacao(espacos, valores, limiteEspacos);
        for(Individuo individuo: this.populacao) {
            individuo.avaliacao();
        }
        this.ordenaPopulacao();
        this.visualizaGeracao();
        
        for(int geracao = 0; geracao < numeroGeracoes; geracao++) {
            Double somaAvaliacao = this.somaAvaliacao();
            List<Individuo> novaPopulacao = new ArrayList<>();
            
            for (int i = 0; i < this.populacao.size() / 2; i++) {
                int pai1 = this.selecionaPai(somaAvaliacao);
                int pai2 = this.selecionaPai(somaAvaliacao);
                
                List<Individuo> filhos = this.getPopulacao().get(pai1).crossover(this.getPopulacao().get(pai2));
                novaPopulacao.add(filhos.get(0).mutacao(taxaMutacao));
                novaPopulacao.add(filhos.get(1).mutacao(taxaMutacao));
                
            }
            
            this.setPopulacao(novaPopulacao);
            for(Individuo individuo: this.getPopulacao()) {
                individuo.avaliacao();
            }
            this.ordenaPopulacao();
            this.visualizaGeracao();
            Individuo melhor = this.populacao.get(0);
            this.melhorIndividuo(melhor);
        }
        System.out.println("_______________________________________________________\nMelhor solucao G -> " + this.melhorSolucao.getGeracao() +
                "\nValor: " + this.melhorSolucao.getNotaAvaliacao() + 
                "\nEspaço: " + this.melhorSolucao.getEspacoUsado() + 
                "\nCromossomo: " + this.melhorSolucao.getCromossomo());
        return this.melhorSolucao.getCromossomo();
        
    }
    
    public void ordenaPopulacao() {
        Collections.sort(this.populacao);
    }

    public int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public void setTamanhoPopulacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    public List<Individuo> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(List<Individuo> populacao) {
        this.populacao = populacao;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    public Individuo getMelhorSolucao() {
        return melhorSolucao;
    }

    public void setMelhorSolucao(Individuo melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }
    
    
    
}
