package br.unidf.Testes;

import javax.swing.JOptionPane;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

public class TesteAlterarLivro {
    public static void main(String[] args) throws Exception {
        int id = Integer.parseInt(args[0]);
        LivrosDAL dal = new LivrosDAL();
        LivrosDTO livro = new LivrosDTO();
        // livro.setLivID(14);
        // livro.setLivTitulo("Livro Alterar 14");
        // livro.setLivISBN(1998);
        // dal.alterarLivros(livro);
        // System.out.println("Livro" + livro.getLivTitulo() + "Alterado com sucesso");
        
        String novoTitulo = JOptionPane.showInputDialog("Digite o novo título do livro:");
        String novoISBNStr = JOptionPane.showInputDialog("Digite o novo ISBN do livro:");
        
        try {
            int novoISBN = Integer.parseInt(novoISBNStr);
            livro.setLivID(id);
            livro.setLivTitulo(novoTitulo);
            livro.setLivISBN(novoISBN);
        
            dal.alterarLivros(livro);
            JOptionPane.showMessageDialog(null, "Livro " + livro.getLivTitulo() + " editado com sucesso");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ISBN deve ser um número válido.");
        }
        

    }
}
