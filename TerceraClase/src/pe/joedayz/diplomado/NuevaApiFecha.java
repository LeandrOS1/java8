/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

/**
 *
 * @author NARUTO
 */
public class NuevaApiFecha {

    public static void main(String[] args) {
        Calendar mesQueViene
                = Calendar.getInstance();
        mesQueViene.add(Calendar.MONTH, 1);

        LocalDate mesQueViene2
                = LocalDate.now().plusMonths(1);

        //14-11-2014
        LocalDate anhoPasado
                = LocalDate.now().minusYears(1);
        
        
        LocalDateTime 
                ahora = LocalDateTime.now();
        
        
        LocalTime tiempo = LocalTime.now();
        
        
        
        LocalDateTime 
                mediodia = LocalDate.now().atTime(12,0);
        
        LocalDate hoy = LocalDate.now();
        
        LocalDateTime fechaAhora = hoy.atTime(tiempo);
        
        ZonedDateTime fechaConHoraTimeZone =
                fechaAhora.atZone(ZoneId.of("Europe/Paris"));
        
        LocalDateTime sintimeZone = fechaConHoraTimeZone.toLocalDateTime();
        
        
        LocalDate dateOf = LocalDate.of(2014, 11, 14);
        
         LocalDateTime dateTimeOf = LocalDateTime.of(2014, 11, 14, 10, 50);
        
       System.out.println(dateTimeOf);
       
       LocalDate anhoBienPasado = LocalDate.now().withYear(1974);
        
       System.out.println(anhoBienPasado.getYear());   
       
       
       LocalDate fechaHoy = LocalDate.now();
       LocalDate manhana = LocalDate.now().plusDays(1);
       
        System.out.println(fechaHoy.isBefore(manhana));
        System.out.println(fechaHoy.isAfter(manhana));
        System.out.println(fechaHoy.isEqual(manhana));
        
        //como comparar dos fechas en diferentes timezones
        ZonedDateTime tokyo = 
                ZonedDateTime.of(2014, 11, 14, 10, 30, 0,  0, ZoneId.of("Asia/Tokyo"));
        
        
        ZonedDateTime lima = 
                ZonedDateTime.of(2014, 11, 14, 10, 30, 0,  0, ZoneId.of("America/Sao_Paulo"));
        
        tokyo = tokyo.plusHours(12);
        
        System.out.println(tokyo.isEqual(lima));
       
        System.out.println("Que dia es hoy? " + MonthDay.now().getDayOfMonth());
        
        System.out.println(LocalDate.of(2014, 11, 14));
        
         System.out.println(LocalDate.of(2014, Month.NOVEMBER, 14));
         
         System.out.println(Month.NOVEMBER.plus(2));
    }
}
