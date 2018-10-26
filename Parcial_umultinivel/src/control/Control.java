/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.*;
import vista.*;

public class Control  implements ActionListener {
    private String dat;
    private Acu acu=new Acu();
    private Estudiante est=new Estudiante();
    private Formulario formu=new Formulario();
    private Control1 ob1=new Control1();
    private Jop mensaje=new Jop();
    private ArrayList<Acu> listaa=new ArrayList();
    private ArrayList<Estudiante> listae=new ArrayList();
    private ArrayList nota, pors=new ArrayList();
    private double total=0;
    private boolean very=false;
    public Control() {
        this.formu.getBtn_crear().addActionListener(this);
        this.formu.getBtn_calcular().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.formu.getBtn_crear()){
            nota=new ArrayList();
            pors=new ArrayList();
            est=new Estudiante();
            acu=new Acu();
            est.setNombre(this.formu.getTxt_nombre().getText());
            est.setId(Long.parseLong(this.formu.getTxt_id().getText()));
            est.setCod(Long.parseLong(this.formu.getTxt_cod().getText()));
            est.setAsignatura(this.formu.getTxt_asig().getText());
            nota.add(Double.parseDouble(this.formu.getTxt_not1().getText()));
            nota.add(Double.parseDouble(this.formu.getTxt_not2().getText()));
            nota.add(Double.parseDouble(this.formu.getTxt_not3().getText()));
            nota.add(Double.parseDouble(this.formu.getTxt_not4().getText()));
            est.setNota(nota);
            pors.add(Double.parseDouble(this.formu.getTxt_por1().getText()));
            pors.add(Double.parseDouble(this.formu.getTxt_por2().getText()));
            pors.add(Double.parseDouble(this.formu.getTxt_por3().getText()));
            pors.add(Double.parseDouble(this.formu.getTxt_por4().getText()));
            //
            acu.setNombre(this.formu.getTxt_acu().getText());
            acu.setId(Long.parseLong(this.formu.getTxt_ida().getText()));
            acu.setEmail(this.formu.getTxt_email().getText());
            acu.setEstudiante(formu.getTxt_nombre().getText());
            acu.setCod_e(this.formu.getTxt_cod().getText());
            acu.setAsignatura(this.formu.getTxt_asig().getText());
            total=0;
            for (int i = 0; i < 4; i++) {
                total=total+(double) pors.get(i);
            }
            if(total<100)mensaje.mostrar("Los porsentajes no suman 100\n"
                                       + "Vuelva a ingrsar los valores correctos");
            else{
                est.addObserver(acu);
                est.addObserver(ob1);
                listae.add(est);
                listaa.add(acu);
                est.setPorsentaje(pors);
                est.setAcudinte(this.formu.getTxt_acu().getText());
                mensaje.mostrar("Estudiante agregado correctamente");
            }
        }
        if(e.getSource()==formu.getBtn_calcular()){
            very=false;
            for (int i = 0; i <listae.size(); i++) {
                if(Long.parseLong(this.formu.getTxt_codd().getText())==listae.get(i).getCod()){
                    very=true;
                    listae.get(i).total_def();
                    listaa.get(i).update(listae.get(i), listae.get(i).getDef());
                    ob1.update(listae.get(i),listae.get(i).getDef());
                    formu.getTxta_def().setText(" "+this.listaa.get(i).getAsignatura()+"\n"+ob1.toString());
                    ob1.limpiar();
                }
            }
            if(very==false) mensaje.mostrar("El estudiante no existe");
        }
    }
    public void iniciar(){
        formu.setVisible(true);
    }

   
}
