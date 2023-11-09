package br.com.condominio.dto;

import br.com.condominio.model.Morador;
import jakarta.validation.constraints.NotNull;

public record AtualizarMorador(@NotNull Long id,String nome,String veiculo) {

	public AtualizarMorador(Morador atualize) {
		this(atualize.getId(),atualize.getNome(),atualize.getVeiculo());
	}

}
