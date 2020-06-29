package scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import main.Compra;
import main.ValidadorDeTransparencia;
import scheduler.ValidadorTransparenciaJob;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


public class ValidadorTransparenciaScheduler {
	public static void crearSchedulerValidadorTransparencia(Compra compra) throws InterruptedException {
		 try {
	         // Uso una instancia por defencto del scheduler
		     Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		     
		     // Creo la instancia del validador de transparencia
		     ValidadorDeTransparencia validador = new ValidadorDeTransparencia(compra);
		     
		     // Paso el validador por el contexto del scheduler
		     scheduler.getContext().put("validador", validador);
		     
		     // Creo el job y la vinculo con el job del validador de transparencia
		     JobDetail job = newJob(ValidadorTransparenciaJob.class)
		         .withIdentity("JobValidadorTransparencia", "GrupoValidadorTransparencia")
		         .build();
		
		     // Creo el disparador para el job
		     Trigger trigger = newTrigger()
		         .withIdentity("TriggerValidadorTransparencia", "GrupoValidadorTransparencia")
		         .startNow()
		         .withSchedule(simpleSchedule()
                 .withIntervalInSeconds(3)
                 .repeatForever())
		         .build();
		
		     // Vinculo job y trigger y ejecuto
		     scheduler.scheduleJob(job, trigger);
				
		     // Lanzamos el scheduler
		     scheduler.start();
		     
		     Thread.sleep(9000);
		     scheduler.shutdown();
		
		 } 
	 
		 catch (SchedulerException se) {
		     se.printStackTrace();
		 }
	}
}
