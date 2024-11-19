package apifestivo.apifestivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivo.apifestivo.dominio.entidades.Tipo;

@Repository

public interface ITipoRepositorio extends JpaRepository<Tipo, Long>{

}
