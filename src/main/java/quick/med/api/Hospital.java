/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick.med.api;

import java.util.List;
import java.util.stream.Collectors;
import quick.med.api.DTO.Especialidade;
import quick.med.api.DTO.HospitalDTO;
import quick.med.api.repository.HospitalRespository;

/**
 *
 * @author Preci
 */
public class Hospital {
    private String nome;
    private String endereco;
    private Especialidade especialidade;
    
    public Hospital (HospitalDTO hospital) {
        this.nome = hospital.getNome();
        this.endereco = hospital.getEndereco();
        this.especialidade = hospital.getEspecialidade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    public static List<Hospital> converter(List<HospitalDTO> hospital) {
        return hospital.stream().map(Hospital::new).collect(Collectors.toList());
    }

    public HospitalDTO atualiza(long id, HospitalRespository repositorioHosp) {
        HospitalDTO hospital = repositorioHosp.getReferenceById(id);
        
        hospital.setNome(this.nome);
        hospital.setEndereco(this.endereco);
        hospital.setEspecialidade(this.especialidade);
        
        return hospital;
    }
        
}