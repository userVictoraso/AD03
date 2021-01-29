package Pareja_Victor_Actividad_1;

import Entidades.Departamento;

import java.util.HashMap;
import java.util.List;

public class Compare {
    static HashMap<Departamento, Integer> hashMap = new HashMap<Departamento, Integer>();

    public static <Departamento, Integer> HashMap mostrarResultado(List<Departamento> d, int[] i){
        for(int j = 0; j < d.size(); j++){
            hashMap.put((Entidades.Departamento) d.get(j), i[j]);
        }
        return hashMap;
    }
}
