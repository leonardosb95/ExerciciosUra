package br.com.a5.exerciciosjava.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;

public class CalculaIdadeController {
	private AplicacaoBD consulta = new AplicacaoBD();
	private ValidaData_nascimentoController valida = new ValidaData_nascimentoController();

	public int calcularIdade(String anoNascimento) {
		String resultado = consulta.getAnoNascimento(anoNascimento).getDt_nasc();

		// aqui eu tento converter a String em um objeto do tipo date, se funcionar
		// sua data é valida

		int idade = 0;
		if (resultado != null && !resultado.isEmpty()) {
			if (resultado.length() == 4) {

				String ano_nascimento = resultado;
				System.out.println(ano_nascimento);
				int anoNascimento1 = 0;

				anoNascimento1 = Integer.parseInt(ano_nascimento);

				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				
				idade = year - anoNascimento1;

				
			} else {

				idade = 0;
			}
		}
		return idade;
	}

}
