/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.unidf;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;
import br.unidf.Testes.TesteAlterarLivro;
import br.unidf.Testes.TesteExcluirLivro;
import br.unidf.Testes.TesteIncluir;
import br.unidf.Testes.TesteSelecionarLivroPorID;

/**
 *
 * @author carla braga && taui silva && joao victor
 */

public class Livros {
    /**
     * @param args 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int choice;

        do {
            String[] options = { "Adicionar Livro", "Procurar Livro", "Editar Livro", "Excluir Livro", "Listar Livros",
                    "Sair" };
            choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "CRUD de Livros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addLivros();
                    break;
                case 1:
                    procurarLivro();
                    break;
                case 2:
                    editLivro();
                    break;
                case 3:
                    deletarLivro();
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (choice != -1);
    }

    public static void addLivros() {
        String titulo = JOptionPane.showInputDialog("Digite o titulo do livro:");
        String isbString = JOptionPane.showInputDialog("Digi o ISBN do Livro:");

        try {
            TesteIncluir.main(new String[] { titulo, isbString });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ISBN deve seu um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o livro.");

        }
    }

    public static void procurarLivro() throws Exception {
        String idLivString = JOptionPane.showInputDialog("Informe o ID do Livro:");
        try {
            TesteSelecionarLivroPorID.main(new String[] { idLivString });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID deve seu um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o livro.");

        }
    }

    public static void editLivro() {
        String idLivString = JOptionPane.showInputDialog("Informe o ID do Livro que deseja editar:");
        try {
            TesteAlterarLivro.main(new String[] { idLivString });

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID deve ser um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar o livro.");
        }
    }

    public static void deletarLivro() throws Exception {
        String idLivString = JOptionPane.showInputDialog("Informe o ID do Livro que deseja excluir:");
        try {
            TesteExcluirLivro.main(new String[] { idLivString });

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID deve ser um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o livro.");
        }
    }

    public static void listarLivros() {
        try {
            List<LivrosDTO> livrosList = LivrosDAL.selecionarListaLivros();
            if (livrosList != null && !livrosList.isEmpty()) {
                exibirListaLivros(livrosList);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum livro encontrado.");
            }
        } catch (Exception e) {
            String msg = "Erro ao listar livros!\n" +
                    "Verifique a conexção com o banco!\n" +
                    " ' " + e.getMessage() + " '";
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void exibirListaLivros(List<LivrosDTO> livrosList) {
        try {

            Object[][] data = new Object[livrosList.size()][3];

            for (int i = 0; i < livrosList.size(); i++) {
                LivrosDTO livro = livrosList.get(i);
                data[i][0] = livro.getLivID();
                data[i][1] = livro.getLivTitulo();
                data[i][2] = livro.getLivISBN();
            }

            String[] columns = { "ID", "Título", "ISBN" };

            DefaultTableModel model = new DefaultTableModel(data, columns);

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Livros", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir lista de livros: " + e.getMessage());
        }

}