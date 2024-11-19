package apifestivo.apifestivo.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")

public class Festivo {

    @Id 
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    private Long id; 

    @Column(name = "nombre", nullable = false)
    private String nombre; 

    @Column(name = "dia", nullable = false)
    private int dia; 

    @Column(name = "mes", nullable = false)
    private int mes; 

    @Column(name = "diapascua", nullable = false)
    private int diasPascua; 

    @ManyToOne 
    @JoinColumn(name = "idTipo", referencedColumnName = "id", nullable = false) 
    private Tipo tipo;

    public Festivo() {
    }

    public Festivo(Long id, String nombre, int dia, int mes, int diasPascua, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
