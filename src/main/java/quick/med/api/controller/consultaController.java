/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick.med.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quick.med.api.DTO.HospitalDTO;
import quick.med.api.DTO.consultaDTO;
import quick.med.api.Hospital;
import quick.med.api.repository.consultaRepository;
import quick.med.api.repository.HospitalRespository;

/**
 *
 * @author Preci
 */
@RestController
public class consultaController {
    
    @Autowired
    private consultaRepository repositorioConsulta;
    
    @Autowired
    private HospitalRespository repositorioHosp;
    
    @GetMapping("/consultas")
    @CrossOrigin
    public List<Hospital>  showConsultas(String nome) {
        List<HospitalDTO> casc = new ArrayList<>();
        
        if (nome == null) {
            return null;
        } else {
            
            List<consultaDTO> consultas =  repositorioConsulta.findByUsuarioNome(nome);
            
                  
            for (consultaDTO consulta: consultas) {
                
                HospitalDTO hospitais = consulta.getHospital();
                
                List<HospitalDTO> hospsNomes = repositorioHosp.findByNome(hospitais.getNome());
                
                for (HospitalDTO hospital: hospsNomes) {
                    casc.add(hospital);
                }
            }
            
            return Hospital.converter(casc);
        }
    }
    
    @PostMapping("/ADDconsulta")
    public consultaDTO salvarConsultas (@Validated @RequestBody consultaDTO usuario) {
        System.out.println(usuario);
        return repositorioConsulta.save(usuario);
    }
}
