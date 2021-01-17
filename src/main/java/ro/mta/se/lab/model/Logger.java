package ro.mta.se.lab.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *  Funcția singleton Logger are rol de
 *  jurnalizare.
 *
 *
 */

public class Logger {

    private static Logger loggerInstance = null;

    private Logger()
    {

    }


    public static Logger getLoggerInstance()
    {
        if (loggerInstance == null)
            loggerInstance = new Logger();

        return loggerInstance;
    }
    public String getDateAndTime()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String aux="[ "+formatter.format(date)+" ]:";
        return aux;
    }

    public  void log_event(String filename,String message) throws IOException {
        File file=new File(filename);
        FileWriter fwr=null;
        fwr =new FileWriter(file,true);
        String datetime=getDateAndTime();
        String line= datetime+ message + "\n";
        fwr.write(line);
        fwr.close();
    }


}
