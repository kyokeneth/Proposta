package proposta.src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//Painel para a listagem de produtos.
public class ListaProdutoPanel extends JPanel {
    private JTable table;
    private MainFrame mainFrame;

    public ListaProdutoPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        // Tabela para exibir os produtos
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
        //// Botão para abrir o formulário de cadastro de novo produto
        JButton novoProdutoButton = new JButton("Novo Produto");
        novoProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarCadastroProduto();
            }
        });
        add(novoProdutoButton, BorderLayout.SOUTH);
        atualizarTabela();
    }
    //Atualiza a tabela com os produtos
    public void atualizarTabela() {
        //Obtém a lista de produtos do "banco de dados"
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        String[] colunas = {"Nome", "Valor"};
        Object[][] dados = new Object[produtos.size()][2];
        //Preenche a tabela com os dados dos produtos
        for (int i = 0; i < produtos.size(); i++) {
            dados[i][0] = produtos.get(i).getNome();
            dados[i][1] = produtos.get(i).getValor();
        }
        //Define o modelo da tabela
        table.setModel(new DefaultTableModel(dados, colunas));
    }
}
