package com.example.exacorto.Modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int ISBN;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "idioma", nullable = false)
    private String idioma;
    @Column(name = "numeroDePaginas", nullable = false)
    private String numeroDePaginas;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "disponibilidad", nullable = false)
    private boolean disponibilidad;

    // Relaciones
    @ManyToMany
    @JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @OneToMany(mappedBy = "libro")
    private List<DetalleVenta> detallesVenta;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    
    @OneToMany(mappedBy = "libro")
    private List<Inventario> inventarios;

}
