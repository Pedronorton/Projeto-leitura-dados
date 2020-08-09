package com.projetos.processamentodados.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class DateConversion {

    public Calendar stringToCalendar(String reg){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(reg.substring(0,4)));
        System.out.println(Integer.parseInt(reg.substring(4,6)));
        cal.set(Calendar.MONTH, Integer.parseInt(reg.substring(4,6))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(reg.substring(6,8)));
        System.out.println(sdf.format(cal.getTime()));
        return cal;
    }

    public Calendar stringHourToCalendar(String stringHora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(stringHora.substring(0, 2)));
        cal.set(Calendar.MINUTE, Integer.parseInt(stringHora.substring(2, 4)));
        cal.set(Calendar.SECOND, Integer.parseInt(stringHora.substring(4, 6)));
        System.out.println(sdf.format(cal.getTime()));

        return cal;
    }

}
