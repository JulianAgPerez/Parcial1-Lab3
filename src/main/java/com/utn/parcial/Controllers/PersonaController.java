package com.utn.parcial.Controllers;

import com.utn.parcial.Entities.Persona;
import com.utn.parcial.Services.PersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")     //permmite ingresar a la api desde distintos origenes
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona,PersonaServiceImpl> {
}
