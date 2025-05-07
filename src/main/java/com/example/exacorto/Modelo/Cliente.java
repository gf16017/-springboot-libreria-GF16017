package com.example.exacorto.Modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name="apellido",nullable = false, length = 100)
    private String apellido;
    
    @Column(name = "telefono", length = 20)
    private String numero;
    
    @Column(unique = true, length = 100)
    private String email;
    
    @Column(name = "edad", length = 2)
    private Integer edad;
    
    @Column(length = 1)
    private String sexo;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    @Column(name = "activo")
    private Boolean activo = true;
    
    // Relación
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas;
}
