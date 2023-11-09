package br.com.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.model.Morador;

public interface CondominioRepository extends JpaRepository<Morador , Long> {

}
