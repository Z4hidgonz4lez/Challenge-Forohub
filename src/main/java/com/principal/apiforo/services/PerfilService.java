package com.principal.apiforo.services;

import com.principal.apiforo.dto.CreatePerfilDTO;
import com.principal.apiforo.dto.PerfilDTO;
import com.principal.apiforo.entities.Perfil;
import com.principal.apiforo.repositories.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository, ModelMapper modelMapper) {
        this.perfilRepository = perfilRepository;
        this.modelMapper = modelMapper;
    }

    public PerfilDTO createPerfil(CreatePerfilDTO createPerfilDTO) {
        Perfil perfil = modelMapper.map(createPerfilDTO, Perfil.class);
        Perfil savedPerfil = perfilRepository.save(perfil);
        return modelMapper.map(savedPerfil, PerfilDTO.class);
    }

    public List<PerfilDTO> getAllPerfiles() {
        List<Perfil> perfiles = perfilRepository.findAll();
        return perfiles.stream()
                .map(perfil -> modelMapper.map(perfil, PerfilDTO.class))
                .collect(Collectors.toList());
    }

    public PerfilDTO getPerfilById(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil not found"));
        return modelMapper.map(perfil, PerfilDTO.class);
    }

    public PerfilDTO updatePerfil(Long id, CreatePerfilDTO perfilDTO) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil not found"));

        perfil.setNombre(perfilDTO.getNombre());
        perfil.setDescripcion(perfilDTO.getDescripcion());
        Perfil updatedPerfil = perfilRepository.save(perfil);

        return modelMapper.map(updatedPerfil, PerfilDTO.class);
    }

    public void deletePerfil(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil not found"));
        perfilRepository.delete(perfil);
    }
}
