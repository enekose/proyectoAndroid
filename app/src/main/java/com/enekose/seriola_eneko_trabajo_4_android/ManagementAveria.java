package com.enekose.seriola_eneko_trabajo_4_android;

import java.util.ArrayList;

public class ManagementAveria {

    static ArrayList <Averia> averias=new ArrayList<>();

    public static void addAveria(Averia a){
        averias.add(a);
    }

    public static ArrayList<Averia> getListAverias(){
        return averias;
    }

    public static Averia getAveriaPos(int pos){
        return averias.get(pos);
    }

}
