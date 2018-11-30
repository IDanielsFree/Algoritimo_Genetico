package Algoritmo;

import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.I;

/**
 *
 * @author IDanielsFree
 */

public class Executar {
    
    public static void main(String args[]) {
        
        List<Produto> listaProduto = new ArrayList<>();
        
        listaProduto.add(new Produto("Geladeira Dako", 0.751, 999.90));
        listaProduto.add(new Produto("Iphone 6", 0.000089, 2911.12));
        listaProduto.add(new Produto("TV 55", 0.400, 4346.99));
        listaProduto.add(new Produto("TV 50", 0.290, 3999.90));
        listaProduto.add(new Produto("TV 42", 0.200, 2999.00));
        listaProduto.add(new Produto("Notebook Dell", 0.00350, 2499.90));
        listaProduto.add(new Produto("Ventilador Panasonic", 0.496, 199.90));
        listaProduto.add(new Produto("Microondas Electrolux", 0.0424, 308.66));
        listaProduto.add(new Produto("Microondas LG", 0.0544, 429.90));
        listaProduto.add(new Produto("Microondas Panasonic", 0.0319, 299.29));
        listaProduto.add(new Produto("Geladeira Brastemp", 0.635, 849.00));
        listaProduto.add(new Produto("Geladeira Consul", 0.870, 1199.89));
        listaProduto.add(new Produto("Notebook Lenovo", 0.498, 1999.90));
        listaProduto.add(new Produto("Notebook Asus", 0.527, 3999.00));
        
        List espacos = new ArrayList<>();
        List valores = new ArrayList<>();
        List nome = new ArrayList<>();
        
        for (Produto produto: listaProduto) {
            
            espacos.add(produto.getEspaco());
            valores.add(produto.getValor());
            nome.add(produto.getNome());
            
        }
        
        Double limite = 3.0;
        int tamanhoPopulacao = 20;
        Double taxaMutacao = 0.01;
        int numeroGeracoes = 500;
        Genetico g = new Genetico(tamanhoPopulacao);
        List resultado = g.resolver(taxaMutacao, numeroGeracoes, espacos, valores, limite);
        for(int i = 0; i< listaProduto.size(); i++) {
            if(resultado.get(i).equals("1")) {
                System.out.println("Nome: " + listaProduto.get(i).getNome());
            }
        }
    }
    
}
