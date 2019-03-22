package br.com.a5.exerciciosjava.controllers;

import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class ValidaDiaDeAtendimentoController {

	public Boolean DiaDeAtendimento() {
			
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));		
		int DiaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(DiaDaSemana);
		
		if(DiaDaSemana==7 || DiaDaSemana==1) {
			System.out.println("Dia de atendimento fechado: "+DiaDaSemana);
			return false;
		}
		
		System.out.println("Dia de atendimento aberto: "+DiaDaSemana);
		return true;
		
		
		
	
		
	}
	
}
