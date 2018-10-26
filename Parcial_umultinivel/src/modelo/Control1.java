package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.*;


public class Control1 implements Observer{
    public String dat="";
    private double total=0;
    

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        dat=" Nota definitiva "+o1;
        total=(double) o1;
        if(total<3) dat=dat+"\n Asignatura perdida";
        else dat=dat+"\n Asignatura aprovada";
    }
    public void limpiar(){
        dat="";
    }
   @Override
    public String toString() {
        return  "" + dat;
    }

    

    
    
}
