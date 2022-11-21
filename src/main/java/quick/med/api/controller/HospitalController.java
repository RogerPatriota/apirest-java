/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick.med.api.controller;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quick.med.api.DTO.HospitalDTO;
import quick.med.api.Hospital;
import quick.med.api.repository.HospitalRespository;

/**
 *
 * @author Preci
 */
@RestController
public class HospitalController {
    
    @Autowired
    private HospitalRespository repositorioHosp;
    
    @GetMapping("/hospitais")
    @CrossOrigin
    public Iterable<HospitalDTO>  showHospitais() {
        return repositorioHosp.findAll();
    }
    
    @GetMapping("/hospitais/{id}")
    public ResponseEntity<HospitalDTO> buscarHospitalPorId(@PathVariable long id) {
        Optional<HospitalDTO> usuario = repositorioHosp.findById(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        }else {
            return ResponseEntity.notFound().build();
}
    }
    
    @PostMapping("/ADDhospital")
    public HospitalDTO salvarHospital(@Validated @RequestBody HospitalDTO usuario) {
        return repositorioHosp.save(usuario);
    }
    
    @PutMapping("/UPDhospital/{id}")
    @Transactional
    public ResponseEntity<Hospital> atualizarHosp(@PathVariable long id, @Validated @RequestBody Hospital hospital) {
        HospitalDTO UPDhospital = hospital.atualiza(id, repositorioHosp);
        
        return ResponseEntity.ok().body(new Hospital(UPDhospital));
    }
    
    @DeleteMapping("/hospital/{id}")
    @Transactional
    public void deletearHosp(@PathVariable long id) {
        repositorioHosp.deleteById(id);
    }
}
