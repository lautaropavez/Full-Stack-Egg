package com.perrosv4.app.modelos;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PerroModel implements Serializable {

	private static final long serialVersionUID = 6522896498689132123L;
	
	private String id;

	private String idFotoPerfil;
	private FotoModel fotoPerfil;
	
	private String nombre;
	private String apodo;
	private String raza;

	private Date creado;

	private Date editado;

	private boolean activo;
}
