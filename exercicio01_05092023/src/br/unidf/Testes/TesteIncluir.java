/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.unidf.Testes;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

/**
 *
 * @author carla braga && taui silva && joao victor
 */
public class TesteIncluir {

    public static void main(String[] args) throws Exception{
        LivrosDTO livro = new LivrosDTO();
        livro.setLivTitulo("Testando connection 2");
        livro.setLivISBN(123);
        
        LivrosDAL dal = new LivrosDAL();
        dal.incluirLivros(livro);
        System.out.println("add:"+ livro.getLivTitulo() + "com sucesso");
    }

}
