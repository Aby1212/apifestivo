package apifestivo.apifestivo.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivo.apifestivo.dominio.entidades.Festivo;

@Repository

public interface IFestivoRepositorio extends JpaRepository<Festivo, Long> { 
    
    List<Festivo> findByDiaAndMes(int dia, int mes);

}
