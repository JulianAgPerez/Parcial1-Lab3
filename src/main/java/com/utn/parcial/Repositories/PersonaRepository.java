package com.utn.parcial.Repositories;

import com.utn.parcial.Entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String Apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String Apellido, Pageable pageable);

    boolean existsByDni(String dni);

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM  Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM  Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    /*
    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM  Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1% ")   //El numero entre %% indica cant parametros
    List<Persona> search(String filtro);
     */
    //Anotacion con query nativa (SQL)
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);




}
