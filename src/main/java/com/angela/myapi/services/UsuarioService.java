package com.angela.myapi.services;

import com.angela.myapi.domain.Usuario;
import com.angela.myapi.repositories.UsuarioRepository;
import com.angela.myapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "
                + Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario obj) {
        Usuario newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setLogin(obj.getLogin());
        newObj.setSenha(obj.getSenha());
        return usuarioRepository.save(newObj);
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return usuarioRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);

    }
}
