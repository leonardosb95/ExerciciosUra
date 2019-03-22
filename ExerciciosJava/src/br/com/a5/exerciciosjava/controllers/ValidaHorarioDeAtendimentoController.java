package br.com.a5.exerciciosjava.controllers;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class ValidaHorarioDeAtendimentoController {
	
	
	public int HorarioDeAtendimento() {		
 		try {
 			Boolean aberto=false;
 			int periodo = 0;
 			LerArquivoProperties lerArquivo= new LerArquivoProperties();
 	 		CaminhosProperties caminho= new CaminhosProperties();
 	 		Properties prop= lerArquivo.getProp(caminho.propHorarioDeAtendimento);
	 	 		

 	 		String horarioPropAberto=prop.getProperty("HorarioDeAbertura");
 	 		String horarioPropFechado=prop.getProperty("horarioDeFechamento");
 	 		
 	 		Date horarioAtual= Calendar.getInstance().getTime();	
 	 			
 	 		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
 	 		
 	 		
 	 		if (!(sdf.parse(sdf.format(horarioAtual)).after(sdf.parse(horarioPropFechado)))) {
			
 	 		
 	 		if(sdf.parse(sdf.format(horarioAtual)).before(sdf.parse("12:00"))) {
 	 			
 	 			periodo=1;
 	 			
 	 		}
 	 		else if(sdf.parse(sdf.format(horarioAtual)).after(sdf.parse("12:00")) && sdf.parse(sdf.format(horarioAtual)).before(sdf.parse("18:00")) ) {
 	 			
 	 			periodo=2;
 	 		}
 	 		else if(sdf.parse(sdf.format(horarioAtual)).after(sdf.parse("18:00"))) {
 	 			
 	 			periodo=3;
 	 			
 	 		}
 	 		
 	 		}
 	 		
 	 		return periodo;
 	 	
 		}
 		catch (Exception e) {
 			System.out.println("Erro na funcao Horario de atendimento");
			return 0;
		}
 	 		 		
       
	}
}
        



