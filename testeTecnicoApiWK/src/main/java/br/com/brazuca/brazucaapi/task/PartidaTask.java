package br.com.brazuca.brazucaapi.task;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.brazuca.brazucaapi.service.ScrapingService;
import br.com.brazuca.brazucaapi.util.DataUtil;

@Configuration
@EnableScheduling
public class PartidaTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartidaTask.class);
	private static final String TIME_ZONE = "America/Sao_Paulo";
	private static final String DD_MM_YYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";

	@Autowired(required = true)
	private ScrapingService scrapingService;
	
	@Scheduled(cron = "0/30 * * * * ?", zone = TIME_ZONE)
	public void taskPartidaDay() throws Throwable {
		 inicializaAgendamento("taskCargaDoadores()");
		scrapingService.cargaDoadores();
	}
	
	private void inicializaAgendamento(String diaSemana) {
		this.gravaLogInfo(String.format("%s: %s", diaSemana, DataUtil.formataDataEmString(new Date(), DD_MM_YYY_HH_MM_SS)));
	}

	private void gravaLogInfo(String mensagem) {
		LOGGER.info(mensagem);
	}

}
