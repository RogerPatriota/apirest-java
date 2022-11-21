 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick.med.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quick.med.api.DTO.UsuarioDTO;
import quick.med.api.repository.UsuarioRepository;
import quick.med.api.repository.consultaRepository;

/**
 *
 * @author Preci
 */

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;
    
    @Autowired
    private consultaRepository repositorioConsulta;
    
    @GetMapping("/usuarios")
    @CrossOrigin
    public Iterable<UsuarioDTO>  showUsuarios(String email) {
        if (email == null) {
            return repositorioUsuario.findAll();
        }
        else {
            return repositorioUsuario.findByEmail(email);
        }   
    }
    
    @GetMapping("/usuario/{id}")
    @CrossOrigin
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable long id) {
        Optional<UsuarioDTO> usuario = repositorioUsuario.findById(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        }else {
            return ResponseEntity.notFound().build();
}
    }
    
    @PostMapping("/ADDusuario")
    public UsuarioDTO salvarUsuario(@Validated @RequestBody UsuarioDTO usuario) {
        System.out.println(usuario);
        return repositorioUsuario.save(usuario);
    }
    
    @DeleteMapping("/usuarios/{id}")
    @CrossOrigin
    public ResponseEntity<?> deletaUser(@PathVariable long id) {
        repositorioConsulta.deleteAll();
        repositorioUsuario.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
