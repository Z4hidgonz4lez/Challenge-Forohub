package com.principal.apiforo.controllers;

import com.principal.apiforo.dto.CreatePerfilDTO;
import com.principal.apiforo.dto.PerfilDTO;
import com.principal.apiforo.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> createPerfil(@RequestBody CreatePerfilDTO createPerfilDTO) {
        PerfilDTO createdPerfil = perfilService.createPerfil(createPerfilDTO);
        return new ResponseEntity<>(createdPerfil, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> getAllPerfiles() {
        List<PerfilDTO> perfiles = perfilService.getAllPerfiles();
        return new ResponseEntity<>(perfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getPerfilById(@PathVariable Long id) {
        PerfilDTO perfil = perfilService.getPerfilById(id);
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> updatePerfil(@PathVariable Long id, @RequestBody CreatePerfilDTO perfilDTO) {
        PerfilDTO updatedPerfil = perfilService.updatePerfil(id, perfilDTO);
        return new ResponseEntity<>(updatedPerfil, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id) {
        perfilService.deletePerfil(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
