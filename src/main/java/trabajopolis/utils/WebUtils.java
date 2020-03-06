package trabajopolis.utils;

import java.util.HashMap;

public class WebUtils {

    private HashMap<String,String> mapMonth = new HashMap<>();
    private HashMap<String,String> mapMaleMaritalStatus = new HashMap<>();
    private HashMap<String,String> mapFemaleMaritalStatus = new HashMap<>();
    private final String MALE = "Masculino";


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

        mapMaleMaritalStatus.put("Soltero(a)", "Soltero");
        mapMaleMaritalStatus.put("Casado(a)", "Casado");
        mapMaleMaritalStatus.put("Divorciado(a)", "Divorciado");
        mapMaleMaritalStatus.put("Viudo(a)", "Viudo");

        mapFemaleMaritalStatus.put("Soltero(a)", "Soltera");
        mapFemaleMaritalStatus.put("Casado(a)", "Casada");
        mapFemaleMaritalStatus.put("Divorciado(a)", "Divorciada");
        mapFemaleMaritalStatus.put("Viudo(a)", "Viuda");


    }

    public String getMonthWritten(String date) {
        String [] dateSplit = date.split("/");
        return mapMonth.get(dateSplit[1]);
    }

    public String getYear(String date){
        String [] dateSplit = date.split("/");
        return dateSplit[2];
    }

    public String getSexMaritalStatus(String sex, String maritalStatus) {
        String sexMaritalStatus = sex;
        if (sex.equals(MALE)) {
            sexMaritalStatus = getMaritalStatusMale(maritalStatus);
        } else {
            sexMaritalStatus = getMaritalStatusFemale(maritalStatus);
        }
        return sexMaritalStatus;
    }

    private String getMaritalStatusFemale(String maritalStatus) {
        return mapFemaleMaritalStatus.get(maritalStatus);
    }

    private String getMaritalStatusMale(String maritalStatus) {
        return mapMaleMaritalStatus.get(maritalStatus);
    }
}
