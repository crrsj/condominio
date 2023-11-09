package br.com.condominio.model;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.condominio.dto.AtualizarMorador;
import br.com.condominio.dto.CadastroMorador;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "Morador")
@Table(name = "morador")
public class Morador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	private int aparetamento;
	private int garagem;
	private String veiculo;
	private String placa;
	public Morador(Long id, String nome, int aparetamento, int garagem, String veiculo, String placa) {
		super();
		this.id = id;
		this.nome = nome;
		this.aparetamento = aparetamento;
		this.garagem = garagem;
		this.veiculo = veiculo;
		this.placa = placa;
	}
	public Morador() {
		super();
	}
	public Morador(CadastroMorador cadastro) {
		this.nome = cadastro.nome();
		this.aparetamento = cadastro.apartamento();
		this.garagem = cadastro.garagem();
		this.veiculo = cadastro.veiculo();
		this.placa = cadastro.placa();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAparetamento() {
		return aparetamento;
	}
	public void setAparetamento(int aparetamento) {
		this.aparetamento = aparetamento;
	}
	public int getGaragem() {
		return garagem;
	}
	public void setGaragem(int garagem) {
		this.garagem = garagem;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void update(@RequestBody @Valid AtualizarMorador dados) {
		if(dados.nome()!= null) {
			this.nome = dados.nome();
		}
		if(dados.veiculo()!= null) {
			this.veiculo = dados.veiculo();
		}
	}
	
	

}
