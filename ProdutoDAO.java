package proposta.src;
import java.util.ArrayList;
import java.util.List;
//Classe que simula um banco de dados para produtos.
public class ProdutoDAO {
    private static List<Produto> produtos = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> listarProdutos() {
        produtos.sort((p1, p2) -> Double.compare(p1.getValor(), p2.getValor()));
        return produtos;
    }
}