/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alexy jr
 */
public class Guardar implements Serializable{
    ArrayList<Double> AbonoAgendado = new ArrayList();
    ArrayList<Double> Abono = new ArrayList();
    ArrayList<Double> Totales = new ArrayList();
    ArrayList<Double> TotalAbonado = new ArrayList();

    public void LlenarAbonoAgendado(ArrayList<Double> AbonoAgendado_guardados) {
        for (int i = 0; i < AbonoAgendado_guardados.size(); i++) {
            AbonoAgendado.add(AbonoAgendado_guardados.get(i));
        }
    }

    public void LlenarAbono(ArrayList<Double> Abono_guardados) {
        for (int i = 0; i < Abono_guardados.size(); i++) {
            Abono.add(Abono_guardados.get(i));
        }
    }
    
    public void LlenarTotales(ArrayList<Double> Totales_guardados) {
        for (int i = 0; i < Totales_guardados.size(); i++) {
            Totales.add(Totales_guardados.get(i));
        }
    }
    
    public void LlenarTotalAbonado(ArrayList<Double> TotalAbonado_guardados) {
        for (int i = 0; i < TotalAbonado_guardados.size(); i++) {
            TotalAbonado.add(TotalAbonado_guardados.get(i));
        }
    }
}
