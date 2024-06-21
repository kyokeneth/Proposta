package proposta.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Painel para o formulário de cadastro de produtos.
public class CadastroProdutoPanel extends JPanel {
    private JTextField nomeField;
    private JTextField descricaoField;
    private JSpinner valorSpinner;
    private JCheckBox disponivelCheckBox;
    private MainFrame mainFrame;

    public CadastroProdutoPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nome do produto:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Descrição do produto:"));
        descricaoField = new JTextField();
        add(descricaoField);

        add(new JLabel("Valor do produto:"));
        valorSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 0.1));
        add(valorSpinner);

        add(new JLabel("Disponível para venda:"));
        disponivelCheckBox = new JCheckBox();
        add(disponivelCheckBox);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtém os valores dos campos do formulário
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                double valor = (double) valorSpinner.getValue();
                boolean disponivelParaVenda = disponivelCheckBox.isSelected();
                // Cria um novo produto e adiciona ao "banco de dados"
                Produto produto = new Produto(nome, descricao, valor, disponivelParaVenda);
                ProdutoDAO.adicionarProduto(produto);
                
                // Mostra a lista de produtos após cadastrar
                mainFrame.mostrarListaProdutos();
            }
        });
        add(cadastrarButton);
    }
}
