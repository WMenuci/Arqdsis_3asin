package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.MercadoriaTO;

public class MercadoriaDAO {

	public void incluir(MercadoriaTO to) {
		String sqlInsert = "INSERT INTO mercadoria(nome, quantidade, preco, codigo, tipo, negocio) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setDouble(2, to.getQuantidade());
			stm.setDouble(3, to.getPreco());
			stm.setInt(4, to.getCodigo());
			stm.setString(5, to.getTipo());
			stm.setString(6, to.getNegocio());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void atualizar(MercadoriaTO to) {
		String sqlUpdate = "UPDATE mercadoria SET nome=?, quantidade=?, preco=?, codigo=?, tipo=?, negocio=? WHERE codigo=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setDouble(2, to.getQuantidade());
			stm.setDouble(3, to.getPreco());
			stm.setInt(4, to.getCodigo());
			stm.setString(5, to.getTipo());
			stm.setString(6, to.getNegocio());
			stm.setInt(7, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(MercadoriaTO to) {
		String sqlDelete = "DELETE FROM mercadoria WHERE codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MercadoriaTO carregar(int cod) {
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(cod);
		String sqlSelect = "SELECT nome, quantidade, preco, codigo, tipo, negocio FROM mercadoria WHERE mercadoria.codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cod);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setQuantidade(rs.getDouble("quantidade"));
					to.setPreco(rs.getDouble("preco"));
					to.setCodigo(rs.getInt("codigo"));
					to.setTipo(rs.getString("tipo"));
					to.setNegocio(rs.getString("negocio"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<MercadoriaTO> listarMercadorias() {
		MercadoriaTO to;
		ArrayList<MercadoriaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, nome, fone, email FROM cliente";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MercadoriaTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString("nome"));
					to.setQuantidade(rs.getDouble("quantidade"));
					to.setPreco(rs.getDouble("preco"));
					to.setTipo(rs.getString("tipo"));
					to.setNegocio(rs.getString("negocio"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
}
