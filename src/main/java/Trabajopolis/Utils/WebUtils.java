package Trabajopolis.Utils;

import java.util.HashMap;

public class WebUtils {

    private HashMap<String,String> mapMonth = new HashMap<>();

    public WebUtils(){
        initialze();
    }
    private void initialze() {
        mapMonth = new HashMap<>();
        mapMonth.put("1","Enero");
        mapMonth.put("2","Febrero");
        mapMonth.put("3","Marzo");
        mapMonth.put("4","Abril");
        mapMonth.put("5","Mayo");
        mapMonth.put("6","Junio");
        mapMonth.put("7","Julio");
        mapMonth.put("8","Agosto");
        mapMonth.put("9","Septiembre");
        mapMonth.put("10","Octubre");
        mapMonth.put("11","Noviembre");
        mapMonth.put("12","Diciembre");
    }

    public String getMonthWritten(String date) {
        String [] dateSplit = date.split("/");
        return mapMonth.get(dateSplit[0]);
    }

    public String getYear(String date){
        String [] dateSplit = date.split("/");
        return dateSplit[2];
    }
    
}
