package com.mitocode.model;


import javax.persistence.*;

@Entity
@Table(name = "signos")
public class Signos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSignos;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "pulso")
    private Double pulso;

    @Column(name = "ritmo")
    private Double ritmo;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_signo_paciente"))
    private Paciente paciente;

    public Signos() {
    }

    public Integer getIdSignos() {
        return idSignos;
    }

    public void setIdSignos(Integer idSignos) {
        this.idSignos = idSignos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPulso() {
        return pulso;
    }

    public void setPulso(Double pulso) {
        this.pulso = pulso;
    }

    public Double getRitmo() {
        return ritmo;
    }

    public void setRitmo(Double ritmo) {
        this.ritmo = ritmo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
