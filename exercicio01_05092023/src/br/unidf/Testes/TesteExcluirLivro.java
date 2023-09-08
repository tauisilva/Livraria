package br.unidf.Testes;

import javax.swing.JOptionPane;

import br.unidf.DAL.LivrosDAL;

public class TesteExcluirLivro {
    public static void main(String[] args) throws Exception {
        int id = Integer.parseInt(args[0]);
        LivrosDAL dal= new LivrosDAL();
        dal.excluirLivros(id);
         JOptionPane.showMessageDialog(null, "Livro excluido com sucesso");
    }
}
