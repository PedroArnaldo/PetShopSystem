package com.mycompany.petshoplogin;

import javax.swing.*;
import java.awt.*;

public class PetShopSistema extends JFrame {

    // Variáveis para armazenar os dados
    private String nomeCliente, telefoneCliente;
    private String nomePet;
    private String nomeServico, valorServico;
    private String nomeProduto, valorProduto;

    public PetShopSistema() {
        setTitle("Sistema PetShop");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton iniciarCadastro = new JButton("Iniciar Cadastro");
        iniciarCadastro.addActionListener(e -> abrirCadastroCliente());

        add(iniciarCadastro);
        setVisible(true);
    }

    private void abrirCadastroCliente() {
        JFrame form = new JFrame("Cadastro de Cliente");
        form.setSize(350, 200);
        form.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField txtNome = new JTextField();
        JTextField txtTelefone = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Nome do Cliente:"));
        panel.add(txtNome);
        panel.add(new JLabel("Telefone:"));
        panel.add(txtTelefone);
        panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            nomeCliente = txtNome.getText();
            telefoneCliente = txtTelefone.getText();
            form.dispose();
            abrirCadastroPet();
        });

        form.add(panel);
        form.setVisible(true);
    }

    private void abrirCadastroPet() {
        JFrame form = new JFrame("Cadastro de Pet");
        form.setSize(350, 200);
        form.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField txtNomePet = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Nome do Pet:"));
        panel.add(txtNomePet);
        panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            nomePet = txtNomePet.getText();
            form.dispose();
            abrirCadastroServico();
        });

        form.add(panel);
        form.setVisible(true);
    }

    private void abrirCadastroServico() {
        JFrame form = new JFrame("Cadastro de Serviço");
        form.setSize(400, 250);
        form.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField txtServico = new JTextField();
        JTextField txtValor = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnProduto = new JButton("Adicionar Produto");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Serviço:"));
        panel.add(txtServico);
        panel.add(new JLabel("Valor do Serviço:"));
        panel.add(txtValor);
        panel.add(btnSalvar);
        panel.add(btnProduto);

        btnSalvar.addActionListener(e -> {
            nomeServico = txtServico.getText();
            valorServico = txtValor.getText();
            form.dispose();
            mostrarResumoFinal();
        });

        btnProduto.addActionListener(e -> {
            nomeServico = txtServico.getText();
            valorServico = txtValor.getText();
            form.dispose();
            abrirCadastroProduto();
        });

        form.add(panel);
        form.setVisible(true);
    }

    private void abrirCadastroProduto() {
        JFrame form = new JFrame("Cadastro de Produto");
        form.setSize(350, 200);
        form.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField txtProduto = new JTextField();
        JTextField txtValor = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Produto:"));
        panel.add(txtProduto);
        panel.add(new JLabel("Valor (R$):"));
        panel.add(txtValor);
        panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            nomeProduto = txtProduto.getText();
            valorProduto = txtValor.getText();
            form.dispose();
            mostrarResumoFinal();
        });

        form.add(panel);
        form.setVisible(true);
    }

    private void mostrarResumoFinal() {
        String resumo = "✅ Cadastro Concluído!\n\n"
            + " Cliente: " + nomeCliente + "\n"
            + " Telefone: " + telefoneCliente + "\n"
            + " Pet: " + nomePet + "\n"
            + " Serviço: " + nomeServico + " - R$ " + valorServico + "\n";

        if (nomeProduto != null && valorProduto != null) {
            resumo += "🛒 Produto: " + nomeProduto + " - R$ " + valorProduto + "\n";
        }

        JOptionPane.showMessageDialog(this, resumo, "Resumo do Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetShopSistema());
    }
}