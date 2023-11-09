package br.com.condominio.dto;

import br.com.condominio.model.Morador;

public record BuscarMorador(Long id,String nome,String veiculo) {
 public BuscarMorador(Morador morador) {
	this(morador.getId(),morador.getNome(),morador.getVeiculo()); 
 }
}
