package br.unidf.Testes;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

public class TesteAlterarLivro {
    public static void main(String[] args) throws Exception {
        LivrosDAL dal = new LivrosDAL();
        LivrosDTO livro = new LivrosDTO();
        livro.setLivID(1);
        livro.setLivTitulo("Livro Alterar 1");
        livro.setLivISBN(1567);

        dal.alterarLivros(livro);
        System.out.println("Livro" + livro.getLivTitulo() + "Alterado com sucesso");

    }
}
