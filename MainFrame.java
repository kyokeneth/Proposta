package proposta.src;
import javax.swing.*;
import java.awt.*;

//Frame principal que gerencia a exibição dos painéis de cadastro e listagem.
public class MainFrame extends JFrame {
    private CadastroProdutoPanel cadastroProdutoPanel;
    private ListaProdutoPanel listaProdutoPanel;

    //Construtor do frame principal.
    public MainFrame() {
        setTitle("Gestão de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os painéis de cadastro e listagem
        cadastroProdutoPanel = new CadastroProdutoPanel(this);
        listaProdutoPanel = new ListaProdutoPanel(this);

        // Define o layout do frame como CardLayout
        setLayout(new CardLayout());
        add(cadastroProdutoPanel, "Cadastro");
        add(listaProdutoPanel, "Listagem");

        mostrarListaProdutos();
    }
    //Mostra o painel de cadastro de produtos.
    public void mostrarCadastroProduto() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Cadastro");
    }
    //Mostra o painel de listagem de produtos.
    public void mostrarListaProdutos() {
        listaProdutoPanel.atualizarTabela();
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Listagem");
    }
    //Método principal que inicia a aplicação.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
