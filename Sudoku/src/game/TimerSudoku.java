package game;

import java.util.Calendar;

/**
 * 
 * @author RosarioGarcia
 * This class calculate the time 
 * that an algorithm take to solver 
 * a sudoku game
 *
 */
public class TimerSudoku {

    static long totalTime;
    static Calendar calendario = Calendar.getInstance();
    /**
     *  This method take the start time
     *  when the algorithm solve the sudoku game
     */
    public static String startSudoku(){               
        return "00:00:00:0000";
    }
    
    /**
     * This method return the time that
     * the algorithm solve the sudoko game
     * 
     * @return System.currentTimeMillis() - startSudoku()
     */
    public static String stop(){
        Calendar calendarioActual = Calendar.getInstance();
        int hora =calendario. get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        int milSegundos = calendario.get(Calendar.MILLISECOND);
        int horaAc =calendarioActual. get(Calendar.HOUR_OF_DAY)-hora;
        int minutosAc= calendarioActual.get(Calendar.MINUTE)-minutos;
        int segundosAc= calendarioActual.get(Calendar.SECOND)-segundos;
        int milSegundosAc = calendario.get(Calendar.MILLISECOND);
        return  horaAc+":"+ minutosAc +":"+ segundosAc+":"+milSegundosAc;
    }

}