package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilidad {

    public String Saludo() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String s = sdf.format(cal.getTime());
        int n = Integer.parseInt(s);


        if (n <= 11 && n >= 6) {
            return "Buenos dias";
        }

        if (n <= 19 && n >= 12){
            return "Buenas tardes";
        }
        if (n <= 5 && n >= 20){
            return "Buenas tardes";
        }
        return "x";
    }

    public int validar(String valor, int saldo){

        if(valor.matches("[0-9]+")){
            if(Integer.parseInt(valor) > saldo){
                System.out.print("valor invalido, intente denuevo");
                return -1;
            }
            return Integer.parseInt(valor);
        }
        else {
            System.out.print("valor invalido, intente denuevo");
            return -1;
        }

    }

}
