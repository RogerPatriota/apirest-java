/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quick.med.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import quick.med.api.DTO.HospitalDTO;

/**
 *
 * @author Preci
 */
public interface HospitalRespository extends JpaRepository<HospitalDTO, Long> {
    
    public List<HospitalDTO> findByNome(String nome);
}
