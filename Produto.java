package proposta.src;
//Classe que representa um produto.
public class Produto {
    private String nome;
    private String descricao;
    private double valor;
    private boolean disponivelParaVenda;

    public Produto(String nome, String descricao, double valor, boolean disponivelParaVenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isDisponivelParaVenda() {
        return disponivelParaVenda;
    }
}