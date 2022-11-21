/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quick.med.api.repository;

import org.springframework.data.repository.CrudRepository;
import quick.med.api.DTO.UsuarioDTO;

/**
 *
 * @author Preci
 */
public interface UsuarioRepository extends CrudRepository<UsuarioDTO, Long> {

    public Iterable<UsuarioDTO> findByNome(String nome);
    
    public Iterable<UsuarioDTO> findByEmail(String email);

    public void deleteByNome(String nome);
    
    
}
