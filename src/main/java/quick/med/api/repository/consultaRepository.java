    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quick.med.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import quick.med.api.DTO.consultaDTO;

/**
 *
 * @author Preci
 */
public interface consultaRepository extends JpaRepository<consultaDTO, Long> {

    public List<consultaDTO> findByUsuarioNome(String nome);

    public void deleteByUsuarioId(long id);

    public void deleteByUsuarioNome(String nome);
    
}
