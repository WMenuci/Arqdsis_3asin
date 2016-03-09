package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import to.AlunoTO;

//importa a classe modelo Aluno

public class AlunoDao {

	Connection conn = null; // atributo para a conexao com o banco de dados
	AlunoTO aluno; // instancia do objeto aluno

	// metodo construtor
	public AlunoDao() {

	}// fim metodo construtor

	public void incluirAluno(int codigoAluno, String nome, String endereco, String telefone, String email, String rg,
			long cpf, String login, int senha) {
		// aluno = new Aluno(codigoAluno, nome, endereco, telefone, email, rg,
		// cpf, login, senha);
		try {
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = (Connection) bd.obtemConexao();

			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);

			aluno = new AlunoTO(codigoAluno, nome, endereco, telefone, email, rg, cpf, login, senha);

			incluirAlunoDAO(conn);

			// *** IMPORTANTE ***: Efetiva inclusões
			conn.commit();

			JOptionPane.showMessageDialog(null, "Inclusao realizada");

		} catch (Exception e) {

			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}

	}// fim incluirAluno

	public void incluirAlunoDAO(Connection conn) {
		String sqlInsert = "INSERT INTO aluno(codigoAluno, nome, endereco, telefone, email, rg, cpf, login, senha)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stm = null;

		// Inclusao dos dados na tabela Aluno
		try {

			stm = (PreparedStatement) conn.prepareStatement(sqlInsert);
			stm.setInt(1, aluno.getCodigoAluno());
			stm.setString(2, aluno.getNome());
			stm.setString(3, aluno.getEndereco());
			stm.setString(4, aluno.getTelefone());
			stm.setString(5, aluno.getEmail());
			stm.setString(6, aluno.getRg());
			stm.setLong(7, aluno.getCpf());
			stm.setString(8, aluno.getLogin());
			stm.setInt(9, aluno.getSenha());
			stm.execute();

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();

			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}

		} finally {
			if (stm != null) {
				try {
					stm.close();

				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}

	}// fim metodo incluirAluno(incluirAluno(Connection conn))

	// metodo incluirAluno, para inclusao dos dados do aluno no bd

	public void alterarAluno(int codigoAluno, String nome, String endereco, String telefone, String email, String rg,
			long cpf, String login, int senha) {

		// public void alterarAluno(Aluno aluno) {
		try {

			// this.aluno = aluno;
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = (Connection) bd.obtemConexao();

			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);

			aluno = new AlunoTO(codigoAluno, nome, endereco, telefone, email, rg, cpf, login, senha);

			alterarAlunoDAO(conn);

			// *** IMPORTANTE ***: Efetiva alteracoes no banco
			conn.commit();

			JOptionPane.showMessageDialog(null, "Atualização realizada");
		} catch (Exception e) {

			System.out.print(e.getStackTrace());
		}

	}

	public void alterarAlunoDAO(Connection conn) {
		// String sqlUpdate = "UPDATE aluno SET aluno.nome = ?, aluno.endereco =
		// ?, aluno.telefone = ?, aluno.email = ?, aluno.rg = ?, aluno.cpf = ?,
		// aluno.login = ?, aluno.senha = ? WHERE codigoAluno = ?)";

/*		String sqlUpdate = "UPDATE aluno SET aluno.nome = '1', aluno.endereco = '1', aluno.telefone = '234',"
				+ "aluno.email = 'teste@teste.com.br', aluno.rg = '1234', aluno.cpf = 1234, aluno.login = '1234', "
				+ "aluno.senha = 1234 WHERE codigoAluno = 1";
*/
/*		String sqlUpdate = "UPDATE aluno SET aluno.nome = '?', aluno.endereco = '?', aluno.telefone = '?',"
				+ "aluno.email = '?', aluno.rg = '?', aluno.cpf = ?, aluno.login = '?', "
				+ "aluno.senha = ? WHERE codigoAluno = ?";
*/
		String sqlUpdate = "UPDATE aluno SET aluno.nome = ? WHERE codigoAluno = ?" ;
		
		
		PreparedStatement stm = null;

		try {
			stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);
			stm.setString(1, aluno.getNome());
			stm.setInt(2, aluno.getCodigoAluno());
			//stm.setString(2, aluno.getEndereco());
			//stm.setString(3, aluno.getTelefone());
			//stm.setString(4, aluno.getEmail());
			//stm.setString(5, aluno.getRg());
			//stm.setLong(6, aluno.getCpf());
			//stm.setString(7, aluno.getLogin());
			//stm.setInt(8, aluno.getSenha());
			//stm.setInt(9, aluno.getCodigoAluno());

			stm.executeUpdate(sqlUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}

			}

		}

	}// fim alterarAlunoDAO(Connection conn)

	public AlunoTO pesquisarAluno(int codAluno) {
		try {
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = (Connection) bd.obtemConexao();

			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);

			aluno = new AlunoTO();
			aluno.setCodigoAluno(codAluno);

			pesquisarAlunoDAO(conn);

			// *** IMPORTANTE ***: Efetiva inclusões
			conn.commit();

			JOptionPane.showMessageDialog(null, "Pesquisa realizada");
		} catch (Exception e) {

			System.out.print(e.getStackTrace());
		}

		return aluno;

	}

	public void pesquisarAlunoDAO(Connection conn) {
		String sqlSelect = "SELECT * FROM aluno WHERE aluno.codigoAluno = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) conn.prepareStatement(sqlSelect);
			stm.setInt(1, aluno.getCodigoAluno());
			rs = stm.executeQuery();

			if (rs.next()) {
				aluno.setNome(rs.getString(2));
				aluno.setEndereco(rs.getString(3));
				aluno.setTelefone(rs.getString(4));
				aluno.setEmail(rs.getString(5));
				aluno.setRg(rs.getString(6));
				aluno.setCpf(rs.getLong(7));
				aluno.setLogin(rs.getString(8));
				aluno.setSenha(rs.getInt(9));

			}
		} catch (Exception e) {

		}

	}

	public void excluirAluno(AlunoTO aluno) {
		try {
			this.aluno = aluno;
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = (Connection) bd.obtemConexao();

			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);

			excluirAlunoDAO(conn);

			// *** IMPORTANTE ***: Efetiva alteracoes no banco
			conn.commit();

			JOptionPane.showMessageDialog(null, "Exclusão realizada");
		} catch (Exception e) {

			System.out.print(e.getStackTrace());
		}
	}

	public void excluirAlunoDAO(Connection conn) {
		String sqlDelete = "DELETE FROM aluno WHERE bd_projeto_integrado.aluno.codigoAluno = ?";
		PreparedStatement stm = null;
		try {
			stm = (PreparedStatement) conn.prepareStatement(sqlDelete);
			stm.setInt(1, aluno.getCodigoAluno());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}

			}

		}

	}// fim excluirDAO

	public void fazerLogin() {

	}

}// fim classe AlunoDao
