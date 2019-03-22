package br.com.a5.exerciciosjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.a5.exerciciosjava.models.Usuario;
import br.com.a5.exerciciosjava.util.Procedure;

public class AplicacaoBD {
	
	private Connection connection;
	public Usuario usuario;
	private Procedure procedure= new Procedure(); 

	public List<Usuario> listarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuario = new Usuario();
		String Select = procedure.selectUsuarios();
		PreparedStatement ex;

		try {
			ex = Conexao.getConection().prepareStatement(Select);

			ResultSet rs = ex.executeQuery();

			while (rs.next()) {

				usuario.setCpf(rs.getString("cpf"));
				usuario.setCnpj(rs.getString("cnpj"));
				usuario.setDt_nasc(rs.getString("dt_nasc"));
				usuario.setAni(rs.getString("ani"));

				usuarios.add(usuario);

			}

			ex.close();
			return usuarios;

		} catch (Exception e) {

		}
		return null;

	}
	
	public Usuario getDocumento(String documento) {
		String selectDocumento= procedure.SelectDocumento();
	
		
		PreparedStatement ex;

		try {
			ex = Conexao.getConection().prepareStatement(selectDocumento);
			ex.setString(1,documento);
			ResultSet rs = ex.executeQuery();
			usuario = new Usuario();
			

			while (rs.next()) {

				if (!(rs.getString("documento") == null || rs.getString("documento").isEmpty())) {

					if(rs.getString("documento").length()>9 && rs.getString("documento").length()<=11)
					{
						usuario.setCpf(rs.getString("documento"));
						
					}
					else if(rs.getString("documento").length()==14) {
						
						usuario.setCnpj(rs.getString("documento"));
						
					}
				

				} 
				else 
				{
					usuario.setCpf("0");
					usuario.setCnpj("0");
				}
				
			
				
			}

			ex.close();
			
			return usuario;

		} catch (Exception e) {
			
			System.out.println("Erro "+e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return usuario;

	}
	
	
	
	public Usuario verificaTelefone(String telefone)
	{
		String selectCpf= procedure.verificaTelefone();
		
		PreparedStatement ex;

		try {
			ex = Conexao.getConection().prepareStatement(selectCpf);
			ex.setString(1,telefone);
			ResultSet rs = ex.executeQuery();
			usuario = new Usuario();
			
			String documento=null;
			
			while (rs.next()) {
			documento=rs.getString("documento");
			
				if (documento== null || documento.isEmpty()) {

					usuario.setCpf("0");
					usuario.setCnpj("0");

				} else {
					if(documento.length()==14)
					{
						usuario.setCnpj(documento);
						
					}
					else if(documento.length()>9 && documento.length()<=11) {
						usuario.setCpf(documento);
						
					}
					
				}
				
			
				
			}

			ex.close();
			return usuario;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return usuario;

		
	}
	
	public Usuario getTelefone(String telefone) {
		String selectTelefone= procedure.SelectTelefone();
		
		PreparedStatement ex;

		try {
			ex = Conexao.getConection().prepareStatement(selectTelefone);
			ResultSet rs = ex.executeQuery();
			ex.setString(1,telefone);
			usuario = new Usuario();
			

			while (rs.next()) {

				if (rs.getString("ani") == null || rs.getString("ani").isEmpty()) {

					usuario.setAni("0");

				} else {
					usuario.setAni(rs.getString("ani"));
				}
				
			}

			ex.close();
			return usuario;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return usuario;

	}
	
	
	
	
	public Usuario getAnoNascimento(String anoNascimento) {
		String selectAnoNascimento= procedure.SelectAnoNascimento();
		
		PreparedStatement ex;
		
		try {
			ex = Conexao.getConection().prepareStatement(selectAnoNascimento);
			ex.setString(1,anoNascimento);
			ResultSet rs = ex.executeQuery();
			
			usuario = new Usuario();
			
			
			while (rs.next()) {

				if (rs.getString("dt_nasc") == null || rs.getString("dt_nasc").isEmpty()) {

					usuario.setDt_nasc("0");

				} else {
					usuario.setDt_nasc(rs.getString("dt_nasc"));
				}
				
			}

			ex.close();
			return usuario;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return usuario;

	}

	public List<Usuario> getAllDataNascimento() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String selectDataNasc =procedure.selectDataNascimento();

		PreparedStatement ex;

		try {
			ex = Conexao.getConection().prepareStatement(selectDataNasc);
			ResultSet rs = ex.executeQuery();
			usuario = new Usuario();

			while (rs.next()) {

				if (rs.getString("dt_nasc") == null || rs.getString("dt_nasc").isEmpty()) {

					usuario.setDt_nasc("0");

				} else {
					usuario.setDt_nasc(rs.getString("dt_nasc"));

				}

				usuarios.add(usuario);
			}

			ex.close();
			return usuarios;

		} catch (Exception e) {
			System.out.println("Erro na funcao");

		}
		return usuarios;

	}

	public void InsertUsuario(Usuario usuario) {

		String Insert = procedure.addUsuario();
		PreparedStatement ex;
		try {
			ex = Conexao.getConection().prepareStatement(Insert);
			String documento=null;
			
			if(usuario.getCpf()==null) {
				
				documento=usuario.getCnpj();
			}
			else if( usuario.getCnpj()==null) {
				
				documento=usuario.getCpf();
				
			}
			ex.setString(1, documento);
			ex.setString(2, usuario.getDt_nasc());
			ex.setString(3, usuario.getAni());

			ex.execute();
			ex.close();
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			System.out.println("Causa: "+e.getCause());
			e.printStackTrace();
			System.out.println("Erro na funcao");

		}

	}

	public Boolean deleteUsuario(String id) {
		Boolean resultado = false;
		if (id.matches("[0-9]")) {

			id = id;

		} else {
			id = "0";

		}
		String delete = procedure.DeleteUsuario(id);
		String selectId = procedure.selectId(id);

		PreparedStatement ex;
		PreparedStatement exSelect;

		try {
			exSelect = Conexao.getConection().prepareStatement(selectId);
			ex = Conexao.getConection().prepareStatement(delete);

			ResultSet rs = exSelect.executeQuery();
			ex.execute();

			while (rs.next()) {

				if (!rs.getString("id").equals(id)) {

					resultado = false;
				}
				resultado = true;

			}

			exSelect.close();
			ex.close();

		} catch (Exception e) {

			System.out.println("Erro na funcao");

		}

		return resultado;
	}

	public Boolean UpdateUsuario(Usuario usuario, String id) {

		Boolean resultado = false;

		String updateQuery = procedure.Update(id);
		

		String selectIdQuery = procedure.selectId(id);

		PreparedStatement ex;
		PreparedStatement selectEx;

		try {
			selectEx = Conexao.getConection().prepareStatement(selectIdQuery);
			ex = Conexao.getConection().prepareStatement(updateQuery);

			ResultSet rs = selectEx.executeQuery();

			while (rs.next()) {

				if (!rs.getString("id").equals(id)) {
					System.out.println("entrou");
					resultado = false;
				}
				resultado = true;
			}
			String documento=null;
				
				if(usuario.getCpf()==null) {
					
					documento=usuario.getCnpj();
				}
				else if( usuario.getCnpj()==null) {
					
					documento=usuario.getCpf();
					
				}
			
			ex.setString(1, documento);
			ex.setString(2, usuario.getDt_nasc());
			ex.setString(3, usuario.getAni());
			

			ex.execute();
			selectEx.execute();

//			CLOSE
			ex.close();
			selectEx.close();

			return resultado;

		} catch (Exception e) {
			System.out.println("Erro na funcao");

		}
		return resultado;

	}

	

}
