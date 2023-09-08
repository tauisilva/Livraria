package br.unidf.Testes;

import javax.swing.JOptionPane;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

public class TesteSelecionarLivroPorID {
    public static void main(String[] args) throws Exception {
        // Metodos Padrão
            // LivrosDAL dal = new LivrosDAL();
            // LivrosDTO dto = dal.selecionarLivrosPorID(2);
            // System.out.println("Titulo: " + dto.getLivTitulo());
            // System.out.println("LivISBN: " + dto.getLivISBN());
            
        // Metodos JOptionPane
        if (args != null) {
            try {

                int id = Integer.parseInt(args[0]);
                LivrosDAL dal = new LivrosDAL();
                LivrosDTO dto = dal.selecionarLivrosPorID(id);

                String mensagem = "Livro encontrado com sucesso!\n" +
                        "ID: " + dto.getLivID() + "\n" +
                        "Título: " + dto.getLivTitulo() + "\n" +
                        "ISBN: " + dto.getLivISBN();

                JOptionPane.showMessageDialog(null, mensagem);
            } catch (Exception e) {
                String msg = "Erro ao encontrar o livro!\n" +
                        "Verifique a conexção com o banco!\n" +
                        " ' " + e.getMessage() + " '";
                JOptionPane.showMessageDialog(null, msg);

            }
        }

    }
}
