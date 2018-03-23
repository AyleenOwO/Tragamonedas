package com.company;

import java.util.Random;
import java.util.Scanner;

public class Maquina {
    Scanner read = new Scanner(System.in);
    Random rand = new Random();
    Utilidad util = new Utilidad();
    private String v1 = new String();
    private String v2 = new String();
    private String v3 = new String();
    private int apuesta = 0;
    private int saldo = 1000;

    private String random(){
        int n = rand.nextInt(10) + 1;

        if (n == 10){
            return "*";
        }

        return Integer.toString(n);
    }


    public void sistema(){
        System.out.println("....:::::   Bienvenido al Tragamonedas   :::::....");
        System.out.println("==================================================");
        System.out.println("Su saldo actual es de $"+saldo+" ¿Cuanto desea apostar?");
        String valor = read.nextLine();
        apuesta = util.validar(valor,saldo);
        while(apuesta != 0) {
            if(apuesta != -1){
                saldo -= apuesta;
                v1 = random();
                v2 = random();
                v3 = random();
                String out = String.format("%30s", "+---+---+---+");
                String output = String.format("%16s | %s | %s | %s |", "", v1, v2, v3);
                System.out.println(out + "\n" + output + "\n" + out);

                premio();
            }
            System.out.println("\nSu saldo actual es de $"+saldo+" ¿Cuanto desea apostar?");
            valor = read.nextLine();
            apuesta = util.validar(valor,saldo);
        }
        String s =  util.Saludo();
        System.out.println(s+", gracias por jugar. Su saldo final es de $"+saldo);
        System.exit(0);


    }

    private void premio(){

        if(v1.equals("*") || v2.equals("*") || v3.equals("*")){
            
            if (v1.equals(v2) || v2.equals(v3) || v1.equals(v1)){
                saldo += 300;
                return;
            }
            
            if(v1.equals(v2) && v2.equals(v3) && v1.equals(v1)){
                saldo += 500;
                return;
            }
            saldo += 50;
            return;
        }

        if(v1.equals(v2) && v2.equals(v3) && v1.equals(v1)) {
            apuesta = apuesta * Integer.parseInt(v1);
            saldo += apuesta;
            return;
        }
    }

}



