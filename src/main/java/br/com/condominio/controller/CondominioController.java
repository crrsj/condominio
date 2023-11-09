package br.com.condominio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.condominio.dto.AtualizarMorador;
import br.com.condominio.dto.BuscarMorador;
import br.com.condominio.dto.CadastroMorador;
import br.com.condominio.model.Morador;
import br.com.condominio.repository.CondominioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

	@Autowired
	CondominioRepository condominioRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CadastroMorador>cadastrar(@RequestBody CadastroMorador cadastro, UriComponentsBuilder uriBuilder){
		var dados = new Morador(cadastro);
		condominioRepository.save(dados);
		var uri =uriBuilder.path("/condominio/{id}").buildAndExpand(dados.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastroMorador(dados));
	}
	@GetMapping 
     public ResponseEntity<List<BuscarMorador>>buscar(){
	  var busca = condominioRepository.findAll().stream().map(BuscarMorador::new).toList();
      return ResponseEntity.ok(busca);
  }
	@PutMapping
	@Transactional
     public ResponseEntity<AtualizarMorador> atualizar(@RequestBody @Valid AtualizarMorador dados){
	   var atualize = condominioRepository.getReferenceById(dados.id());
	   atualize.update(dados);
	   return ResponseEntity.ok(new AtualizarMorador(atualize));
   }
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deletar(@PathVariable Long id) {
		condominioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
