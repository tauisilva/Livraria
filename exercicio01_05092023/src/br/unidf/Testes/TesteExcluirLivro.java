package br.unidf.Testes;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import br.unidf.DAL.LivrosDAL;

public class TesteExcluirLivro {
    public static void main(String[] args) throws Exception {
        int id = Integer.parseInt(args[0]);
        LivrosDAL dal= new LivrosDAL();
        try{
            dal.excluirLivros(id);
             JOptionPane.showMessageDialog(null, "Livro excluido com sucesso");
        }catch(ExecutionException e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
        }
    }
}
