package br.gov.mg.meioambiente.simge.logger;

import br.gov.mg.meioambiente.simge.entity.Usuario;
import br.gov.mg.meioambiente.simge.utils.AuthenticationUtils;

public class LogBuilder {

	private String mensagemLog;

	public LogBuilder() {
		mensagemLog = "";
		adicionaUsuario();

	}

	/** Método que adiciona o usuário logado à mensagem de Log */
	private void adicionaUsuario() {

		final Usuario usuario = AuthenticationUtils.retornaUsuarioLogado();

		if (usuario != null) {
			mensagemLog = "\nUSUARIO  :: [ID: " + usuario.getId() + " | CPF: " + usuario.getCpf() + "]";
		}

	}

	/** Método que concatena a mensagem desejada à mensagem de log
	 *
	 * @param mensagem - Mensagem desejada
	 * @return Retorna o próprio MensagemLogBuilder */
	public LogBuilder adicionaMensagem(String mensagem) {
		mensagemLog += "\nMENSAGEM :: [" + mensagem + "]";
		return this;
	}

	/** Método que concatena os parametros usados no metodo que gerou o log
	 *
	 * @param nomeParametro
	 * @param valor
	 * @return Retorna o próprio MensagemLogBuilder */
	public LogBuilder adicionaParametro(String nomeParametro, String valor) {
		mensagemLog += "\nPARAMETRO:: [NOME: " + nomeParametro + " | VALOR: " + valor + "]";
		return this;
	}

	public String getMensagem() {
		return mensagemLog + "\n";
	}
}
