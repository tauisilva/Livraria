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
public class TestIncluir {

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LivrosDTO li = new LivrosDTO();
        li.setLivTitulo("Carla uma dev Pika, aos que não gostaram Do the L");
        li.setLivISBN(1234);

        LivrosDAL dal = new LivrosDAL();
        dal.incluirLivros(li);
        System.out.print("Livro:" + li.getLivTitulo() + "Cadastrado com sucesso");
    }

}
