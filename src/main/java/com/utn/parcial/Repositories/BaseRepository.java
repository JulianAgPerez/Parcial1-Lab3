package com.utn.parcial.Repositories;

import com.utn.parcial.Entities.EntidadBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends EntidadBase, ID extends Serializable> extends JpaRepository<E,ID> {
}
