package br.com.a5.exerciciosjava.controllers;
import java.util.List;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;

import br.com.a5.exerciciosjava.models.Usuario;

public class UsuariosController {
	
	private AplicacaoBD consulta= new AplicacaoBD();
	private Usuario usuario= new Usuario();
	
	List<Usuario> mostrarUsuario = consulta.listarTodosUsuarios();
	
	public boolean getUsuariosController() {
		
		boolean lista = true;
		
		for (Usuario usuario : mostrarUsuario) {
			System.out.println("Cpf:"+usuario.getCpf()+" Cnpj: "+usuario.Cnpj+ " data nascimento: "+usuario.Dt_nasc+ " Telefone: "+usuario.Ani);
		}
		
		return lista;
		
	}
	
	

}
