package apifestivo.apifestivo.presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apifestivo.apifestivo.aplicacion.FestivoServicio;

@RestController 
@RequestMapping("/api/festivos") 

public class FestivoControlador { 

    private FestivoServicio festivoServicio; 

    @GetMapping("/validar") 
    public boolean validarFestivo(@RequestParam String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(fecha);
    
            return festivoServicio.esFestivo(date);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha inválido. Use 'yyyy-MM-dd'");
        }
    }

}
