/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Observable;
import java.util.Observer;
import modelo.Persona;

public class Acu implements Observer, Persona {
    private String nombre,email,estudiante,cod_e,asignatura;
    private long id;
   
    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCod_e() {
        return cod_e;
    }

    public void setCod_e(String cod_e) {
        this.cod_e = cod_e;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    @Override
    public void Persona(String nombre, long id) {
        this.nombre=nombre;
        this.id=id;
    }

    public Acu() {
    }
    private double total;
    @Override
    public void update(Observable o, Object o1) {
        System.out.println("Acudiente: "+this.nombre+" Se le envia al correo "+this.email);
        System.out.println("El estudiante: "+this.estudiante+"\n"
                         + "Con codigo "+this.cod_e+" "
                         + "Nota definitiva del curso "+this.asignatura+": "+o1);
        total=(double) o1;
        if(total<3){
            System.out.println("Asignatura perdida");
    } else System.out.println("Asignatura aprovada");
    }
    
    
}
