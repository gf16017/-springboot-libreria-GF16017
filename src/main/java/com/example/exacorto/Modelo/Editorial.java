package com.example.exacorto.Modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private int editorialId;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "sitio_web")
    private String sitioWeb;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    public Editorial() {
    }

    // Relaciones
    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;
    
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

}
