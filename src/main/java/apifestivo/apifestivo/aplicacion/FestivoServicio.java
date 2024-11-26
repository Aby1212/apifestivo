
package apifestivo.apifestivo.aplicacion;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apifestivo.apifestivo.core.interfaces.repositorios.IFestivoRepositorio;
import apifestivo.apifestivo.core.interfaces.servicios.IServicioFechas;
import apifestivo.apifestivo.dominio.entidades.Festivo;



@Service

public class FestivoServicio implements IServicioFechas{ 

    private final IFestivoRepositorio festivoRepositorio;

    public FestivoServicio(IFestivoRepositorio festivoRepositorio) {
        this.festivoRepositorio = festivoRepositorio;
    }

    public boolean esFestivo(Date fecha) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;

        List<Festivo> festivo = festivoRepositorio.findByDiaAndMes(dia, mes);

        return !festivo.isEmpty();
    }

    public List<Festivo> obtenerFestivosPorAño(int año) {
        List<Festivo> festivos = festivoRepositorio.findAll();
        Date pascua = IServicioFechas.getInicioSemanaSanta(año);

        // Calcular los festivos basados en Pascua
        for (Festivo festivo : festivos) {
            if (festivo.getDiasPascua() != 0) {
                Date fechaCalculada = IServicioFechas.agregarDias(pascua, festivo.getDiasPascua());
                Calendar cal = Calendar.getInstance();
                cal.setTime(fechaCalculada);

                festivo.setDia(cal.get(Calendar.DAY_OF_MONTH));
                festivo.setMes(cal.get(Calendar.MONTH) + 1);
            }
        }

        return festivos;
    }

}

