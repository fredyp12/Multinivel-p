/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;
import modelo.Persona;
public class Estudiante extends Observable implements Persona  {
    private String nombre;
    private long id,cod;
    private String asignatura;
    //
    ArrayList nota,porsentaje=new ArrayList();
    private double dat=0,dat1=0;
    private String acudinte,eacu;
    private double def;
    @Override
    public void Persona(String nombre, long id) {
        this.nombre=nombre;
        this.id=id;
    }

    public Estudiante(String nombre, long id, long cod, String signatura) {
        this.nombre = nombre;
        this.id = id;
        this.cod = cod;
        this.asignatura = asignatura;
    }

    public Estudiante() {
    }

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

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public ArrayList getNota() {
        return nota;
    }

    public void setNota(ArrayList nota) {
        this.nota = nota;
    }

    public String getAcudinte() {
        return acudinte;
    }

    public void setAcudinte(String acudinte) {
        this.acudinte = acudinte;
    }

    public String getEacu() {
        return eacu;
    }

    public void setEacu(String eacu) {
        this.eacu = eacu;
    }
  
    public void setPorsentaje(ArrayList porsentaje) {
        this.porsentaje = porsentaje;
    }

    public double getDef() {
        return def;
    }
    //
    public void total_def(){
        def=0;
        for (int i = 0; i <4; i++) {
            dat=(double) nota.get(i);
            dat1=(double) porsentaje.get(i);
            def=def+((dat*dat1)/100);
        }
        setChanged();
        notifyObservers();
    }
    @Override
    public void  notifyObservers(){
        
    }
}
