package br.unidf.Testes;

import br.unidf.DAL.LivrosDAL;

public class TesteExcluirLivro {
    public static void main(String[] args) throws Exception {
        LivrosDAL dal= new LivrosDAL();
        dal.excluirLivros(1);
        System.out.println("Excluido com sucesso");
    }
}
