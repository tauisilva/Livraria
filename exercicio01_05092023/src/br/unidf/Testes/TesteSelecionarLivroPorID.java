package br.unidf.Testes;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

public class TesteSelecionarLivroPorID {
    public static void main(String[] args) throws Exception {
        LivrosDAL dal = new LivrosDAL();
        LivrosDTO dto = dal.selecionarLivrosPorID(1);
        System.out.println("Titulo: " + dto.getLivTitulo());
        System.out.println("LivISBN: " + dto.getLivISBN());

    }
}
