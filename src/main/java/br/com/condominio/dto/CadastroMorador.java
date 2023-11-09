package br.com.condominio.dto;

import br.com.condominio.model.Morador;
import jakarta.validation.constraints.NotBlank;

public record CadastroMorador(@NotBlank String nome,int apartamento,int garagem,String veiculo, String placa) {

	public CadastroMorador(Morador morador) {
		this(morador.getNome(),morador.getAparetamento(),morador.getGaragem(),morador.getVeiculo(),morador.getPlaca());
	}

}
