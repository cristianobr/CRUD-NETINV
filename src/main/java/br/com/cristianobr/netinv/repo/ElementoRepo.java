package br.com.cristianobr.netinv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cristianobr.netinv.model.Elemento;

public interface ElementoRepo extends JpaRepository<Elemento, Long> {

}
