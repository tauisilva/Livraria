/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.unidf.Testes;

import javax.swing.JOptionPane;

import br.unidf.DAL.LivrosDAL;
import br.unidf.DTO.LivrosDTO;

/**
 *
 * @author carla braga && taui silva && joao victor
 */
public class TesteIncluir {

    public static void main(String[] args) throws Exception {
        // Metodos Padrão
        // LivrosDTO livro = new LivrosDTO();
        // livro.setLivTitulo("Testando connection");
        // livro.setLivISBN(333);
        
        // LivrosDAL dal = new LivrosDAL();
        // dal.incluirLivros(livro);
        // System.out.println("add:" + livro.getLivTitulo() + "com sucesso");

        // Metodos JOpPane
        if (args.length == 2) {
            String titulo = args[0];
            int isbn = Integer.parseInt(args[1]);

            LivrosDTO livro = new LivrosDTO();
            livro.setLivTitulo(titulo);
            livro.setLivISBN(isbn);

            LivrosDAL dal = new LivrosDAL();
            dal.incluirLivros(livro);

            JOptionPane.showMessageDialog(null, "Livro " + titulo + " adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao incluir" , "Erro:", JOptionPane.ERROR_MESSAGE);

        }
    }

}
