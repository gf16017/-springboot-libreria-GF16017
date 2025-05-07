package com.example.exacorto.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;
    
    @Column(name = "ubicacion")
    private String ubicacion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_ejemplar")
    private EstadoEjemplar estadoEjemplar;
    
    @Column(name = "precio_costo")
    private Double precioCosto;
    
    @Column(name = "precio_venta")
    private Double precioVenta;
    
    @Column(name = "numero_lote")
    private String numeroLote;
    
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
    
    @Column(name = "usuario_registro")
    private String usuarioRegistro;
    
    @Column(name = "notas")
    private String notas;

    //Relaciones
    @ManyToOne
    @JoinColumn(name ="libro_id",nullable=false)
    private Libro libro;
}
