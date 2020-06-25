package scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

import main.ValidadorDeTransparencia;

public class ValidadorTransparenciaJob implements Job {

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		// Obtengo el contexto del scheduler
		SchedulerContext schedulerContext = null;
		
		try {
			schedulerContext = jobExecutionContext.getScheduler().getContext();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		// Traigo la compra enviada por contexto
		ValidadorDeTransparencia validador = (ValidadorDeTransparencia) schedulerContext.get("validador");
		
		// Ejecuto la validación
		validador.validarCompra();
		
	}
}
