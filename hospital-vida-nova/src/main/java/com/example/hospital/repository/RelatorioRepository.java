package com.example.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Relatorio;
import java.util.List;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
    List<Relatorio> findByMedicoAutor(String medicoAutor);
}
