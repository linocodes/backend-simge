package br.gov.mg.meioambiente.simge.logger;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMessagem {
	
	  private static final Logger logger = LoggerFactory.getLogger(LogMessagem.class);
	
	/**
	 * Método que vai 'loggar' as mensagens de erro com o parametro ID associado.
	 * 
	 * @author Filipe Santos
	 * @since 15/01/2018
	 **/
	public void printErrorLogWithId(Long id, Exception e) {
			
		logger.error(new LogBuilder().adicionaMensagem("Não existe nenhuma Instituição com o identificador informado.\n")
									 .adicionaParametro("Identificador", String.valueOf(id)).getMensagem(), e);
	}
	
	/**
	 * Método que vai 'loggar' as mensagens de erro ao buscar algum registro e não encontrar nada.
	 * 
	 * @author Filipe Santos
	 * @since 15/01/2018
	 **/
	public void printErrorLog(Exception e) {
			
		logger.error(new LogBuilder().adicionaMensagem("Não existe nenhuma Instituição cadastrada em nossa base de dados.\n")
									 .getMensagem(), e);
		
	}
	
	/*
	 * Método que vai 'loggar' as mensagens de erro ao inserir um registro de maneira incorreta.
	 * 
	 * @author Filipe Santos
	 * @since 15/01/2018
	 */
	public void printErrorLogInsert(Exception e) {
			
		logger.error(new LogBuilder().adicionaMensagem("Ocorreu um erro ao inserir um novo registro da entidade: Instituição. Por favor, analise a exceção para maiores detalhes.\n")
									 .getMensagem(), e);
		
	}
	
	/**
	 * 
	 * @param log
	 * @param id
	 */
	public void printInfoLogWithId(String log, String id) {
		logger.info(new LogBuilder().adicionaMensagem(log).adicionaParametro("ID", id).getMensagem());

	}
	
	/**
	 * 
	 * @param log
	 * @param id
	 */
	public void printInfoLogWithId(String log, Object... params) {
		String texto = MessageFormat.format(log, params);		
		this.printInfoLogWithId(texto);
	}

	/**
	 * 
	 * @param log
	 * @param id
	 */
	public void printInfoLogWithId(String log, Object id) {
		this.printInfoLogWithId(log, id);
	}

	/**
	 * 
	 * @param log
	 */
	public void printInfoLog(String log) {
		logger.info(new LogBuilder().adicionaMensagem(log).getMensagem());
	}
	

}
