package Grupo_5_Gestion_de_un_Gimnasio.service;

import Grupo_5_Gestion_de_un_Gimnasio.dto.SocioRequestDTO;
import Grupo_5_Gestion_de_un_Gimnasio.dto.SocioResponseDTO;
import Grupo_5_Gestion_de_un_Gimnasio.model.Socio;
import Grupo_5_Gestion_de_un_Gimnasio.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<SocioResponseDTO> obtenerTodos() {
        return socioRepository.findAll().stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    public SocioResponseDTO guardar(SocioRequestDTO dto) {
        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setEmail(dto.getEmail());
        socio.setTelefono(dto.getTelefono());
        Socio guardado = socioRepository.save(socio);
        return convertirADto(guardado);
    }

    public Optional<SocioResponseDTO> actualizar(Long id, SocioRequestDTO dto) {
        return socioRepository.findById(id).map(socioExistente -> {
            socioExistente.setNombre(dto.getNombre());
            socioExistente.setEmail(dto.getEmail());
            socioExistente.setTelefono(dto.getTelefono());
            Socio actualizado = socioRepository.save(socioExistente);
            return convertirADto(actualizado);
        });
    }

    public boolean eliminar(Long id) {
        if (socioRepository.existsById(id)) {
            socioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método auxiliar con constructor tradicional (sin .builder())
    private SocioResponseDTO convertirADto(Socio socio) {
        return new SocioResponseDTO(
                socio.getId(),
                socio.getNombre(),
                socio.getEmail(),
                socio.getTelefono()
        );
    }

    public SocioResponseDTO obtenerPorId(long l) {
        return null;
    }

    public SocioResponseDTO guardarSocio(SocioRequestDTO dto) {
        return null;
    }
}