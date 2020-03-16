package com.prueba.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.datatransfer.UsuarioDTO;
import com.prueba.domain.Usuario;

@Component
public class UsuarioAdapter {

	public List<UsuarioDTO> usuarioListAdapter(List<Usuario> usuario) {

		List<UsuarioDTO> usuarioListDTO = new ArrayList<>();
		for (Usuario usuarioList : usuario) {

			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdUsuario(usuarioList.getIdUsuario());
			usuarioDTO.setPassword(usuarioList.getPassword());
			usuarioListDTO.add(usuarioDTO);
		}

		return usuarioListDTO;
	}

}
