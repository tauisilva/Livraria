/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unidf.DAL;

import br.unidf.DTO.LivrosDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carla
 */
public class LivrosDAL extends ConexaoMySQL {

    public void incluirLivros(LivrosDTO livros) throws Exception {
        //Prepara a conexão com o MySQL
        abrirBD();
        SQL = "INSERT INTO livros (livTitulo, livISBN) VALUES (?, ?, ?)";
        ps = con.prepareStatement(SQL);
        //Busca os valores da classe clienteDTO
        ps.setString(1, livros.getLivTitulo());
        ps.setInt(2, livros.getLivISBN());
        ps.execute();
        fecharBD();
    }
    
    public LivrosDTO selecionarLivrosPorID(Integer livID) throws Exception
    {
        abrirBD();
        SQL = "SELECT * FROM livros WHERE livID = ?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, livID);
        rs = ps.executeQuery();
        LivrosDTO livros = new LivrosDTO();
        if(rs.next())
        {
            livros.setLivID(rs.getInt("livID"));
            livros.setLivTitulo(rs.getString("livTitulo"));
            livros.setLivISBN(rs.getInt("livISBN"));
            fecharBD();            
        }
        return livros;
    }
    
    //Método que vai selecionar todos os clientes no nosso Banco de Dados
    //e ordenar por nome do cliente
    public List selecionarListaLivros() throws Exception
    {
        abrirBD();
        SQL = "SELECT * FROM livros ORDER BY livTitulo";
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();
        List listaLivros = new ArrayList();
        while(rs.next())
        {
            LivrosDTO livros = new LivrosDTO();
            livros.setLivID(rs.getInt("livID"));
            livros.setLivTitulo(rs.getString("livTitulo"));
            livros.setLivISBN(rs.getInt("livISBN"));
            listaLivros.add(livros);         
        }
        fecharBD();
        return listaLivros;
     }
     //Método que vai fazer as alterações necessárias nos dados dos clientes
     //selecionados por seu código no nosso Banco de Dados
     public void alterarLivros(LivrosDTO livros) throws Exception
     {
         abrirBD();         
         //SQL = "UPDATE livros SET livTitulo = ?, livISBN = ? WHERE livID = ?";
         SQL = "UPDATE livros SET livTitulo = ?, livISBN = ? WHERE livID = ?";
         ps = con.prepareStatement(SQL);
         ps.setLong(1, livros.getLivID());
         ps.setString(2, livros.getLivTitulo());
         ps.setLong(3, livros.getLivISBN());
         ps.execute();
         fecharBD();
     }
     public void excluirLivros(Integer livID) throws Exception
     {
         abrirBD();
         SQL = "DELETE FROM livros WHERE livID = ?";
         ps = con.prepareStatement(SQL);
         ps.setInt(1, livID);
         ps.execute();
         fecharBD();
     }

}
