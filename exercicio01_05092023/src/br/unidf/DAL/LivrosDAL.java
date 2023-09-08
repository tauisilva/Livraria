package br.unidf.DAL;

import br.unidf.DTO.LivrosDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivrosDAL extends ConexaoMySQL {

    private static void prepararStatement(String sql, Object... parametros) throws SQLException {
        abrirBD();
        ps = con.prepareStatement(sql);
        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i + 1, parametros[i]);
        }
    }

    private static void fecharStatement() throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public void incluirLivros(LivrosDTO livros) throws SQLException {
        String sql = "INSERT INTO livros (livTitulo, livISBN) VALUES (?, ?)";
        try {
            prepararStatement(sql, livros.getLivTitulo(), livros.getLivISBN());
            ps.execute();
        } finally {
            fecharStatement();
            fecharBD();
        }
    }

    public LivrosDTO selecionarLivrosPorID(Integer livID) throws SQLException {
        String sql = "SELECT * FROM livros WHERE livID = ?";
        try {
            prepararStatement(sql, livID);
            rs = ps.executeQuery();
            LivrosDTO livros = new LivrosDTO();
            if (rs.next()) {
                livros.setLivID(rs.getInt("livID"));
                livros.setLivTitulo(rs.getString("livTitulo"));
                livros.setLivISBN(rs.getInt("livISBN"));
            }
            return livros;
        } finally {
            fecharStatement();
            fecharBD();
        }
    }

    public static List<LivrosDTO> selecionarListaLivros() throws SQLException {
        String sql = "SELECT * FROM livros ORDER BY livTitulo";
        try {
            prepararStatement(sql);
            rs = ps.executeQuery();
            List<LivrosDTO> listaLivros = new ArrayList<>();
            while (rs.next()) {
                LivrosDTO livros = new LivrosDTO();
                livros.setLivID(rs.getInt("livID"));
                livros.setLivTitulo(rs.getString("livTitulo"));
                livros.setLivISBN(rs.getInt("livISBN"));
                listaLivros.add(livros);
            }
            return listaLivros;
        } finally {
            fecharStatement();
            fecharBD();
        }
    }

    public void alterarLivros(LivrosDTO livros) throws SQLException {
        String sql = "UPDATE livros SET livTitulo = ?, livISBN = ? WHERE livID = ?";
        try {
            prepararStatement(sql, livros.getLivTitulo(), livros.getLivISBN(), livros.getLivID());
            ps.executeUpdate();
        } finally {
            fecharStatement();
            fecharBD();
        }
    }

    public void excluirLivros(Integer livID) throws SQLException {
        String sql = "DELETE FROM livros WHERE livID = ?";
        try {
            prepararStatement(sql, livID);
            ps.execute();
        } finally {
            fecharStatement();
            fecharBD();
        }
    }
}
