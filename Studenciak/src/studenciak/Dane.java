package studenciak;

import generated.AnalogChanels;
import generated.CFG;
import generated.ChanelsCount;
import generated.DigitalChanels;
import generated.Freq;
import generated.FreqSampling;
import generated.ObjectFactory;
import generated.StationInfo;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Dane {
    static String station_name; //Name of substation location
    static String rec_dev_id; //Identification number or name of the device
    static String rev_year; //COMTRADE file version
    static int TT; //total number of channels
    static int A; //number of analog channels
    static int D; //number of status channels
    static float If; //nominal line frequency in Hz
    static int nrates; //number of sampling rates
    static float samp; //sample rate;
    static int endsamp; //last sample number
    static String date1, date2; //date
    static float timemult; //multiplacion factor for the time differential (timestamp) field in the associated data
    static boolean ASCII = false;
    static long[] timestamps;
    
    static AnalogReceiver Analog[];
    static BinaryReceiver Binars[];
    
    private static boolean isASCII()
    {
        return ASCII;
    }
        
    private static boolean resizeReceiversData()
    {
        try
        {
             for (AnalogReceiver a : Analog) a.resizeData();
             for (BinaryReceiver b : Binars) b.resizeData();
             timestamps = new long[endsamp];
        }
        catch (Exception ex)
        {
            return false;
        }
        return true; 
    }
    private static boolean resizeReceivers()
    {
        try
        {
            Analog = new AnalogReceiver[A];
            Binars = new BinaryReceiver[D];
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
    private static List<String> loadFile(String path)
    {
        try
        {
            Path path_ = new File(path).toPath();
            List<String> lines = readAllLines(path_);
            return getSeparated(lines,",");
        }
        catch (IOException ex)
        {
            return null;
        }
    }
   
    /**
     * Method loads data from given path.
     * @param path Path to cfg file.
     * @param path_dat Path to dat file
     * @param step1
     * @return Exception on error, null on success
     */
    public static Exception loadData(String path, String path_dat, Step1 step1)
    {
        try 
        {
            List<String> objects = loadFile(path);
            if (objects==null) throw new Exception("podczas otwierania pliku cfg");
            if (!setData1(objects)) throw new Exception("niepoprawna pierwsza sekcja pliku .cfg");
            if (!resizeReceivers()) throw new Exception("podano nieprawidłowe ilości odbiorników"); //chyba kurwa ujemne 
            try
            {
                for (int a=0; a<A; a++)
                {
                    Analog[a] = new AnalogReceiver(objects); 
                }
                for (int a=0; a<D; a++)
                {
                    Binars[a] = new BinaryReceiver(objects);
                }
            }
            catch (Exception ex)
            {
                throw new Exception("wykryto nieprawidłowe dane odbiornika.");
            }
            if (!setData2(objects)) throw new Exception("niepoprawna ostatnia sekcja pliku .cfg");
            if (!resizeReceiversData()) throw new Exception("podano nieprawidłową liczbę sampli (endsamp)");
            getReceiversData(path_dat, step1);
        }
        catch (Exception ex)
        {
            return new Exception("Program zatrzymany: "+ex.getMessage());
        }
        return null;
    }
    private static void getReceiversData(String path, Step1 gui) throws Exception
    {
        List<String> objects = loadFile(path);
        if (objects==null) throw new Exception("podczas otwierania pliku dat");
        try
        {
            while (!objects.isEmpty())
            {
                int nr = Integer.parseInt(objects.remove(0));
                if (nr>endsamp) break;
                timestamps[nr-1] = Long.parseLong(objects.remove(0));
                for (int a=0; a<A; a++) Analog[a].data[nr-1] = readScience(objects.remove(0));
                for (int a=0; a<D; a++) Binars[a].data[nr-1] = Integer.parseInt(objects.remove(0));
                gui.setProgress(nr, endsamp);
            }
        }
        catch (Exception ex)
        {
            throw new Exception("niepoprawne dane dotyczące odbiorników");
        }
    }
    private static boolean setData2(List<String> objs)
    {
        try
        {
            If = Float.parseFloat(objs.remove(0));
            nrates = Integer.parseInt(objs.remove(0));
            samp = Float.parseFloat(objs.remove(0));
            endsamp = Integer.parseInt(objs.remove(0));
            date1 = objs.remove(0)+" "+objs.remove(0); //mozna miec osobno godz i date if needed
            date2 = objs.remove(0)+" "+objs.remove(0);
            if (objs.remove(0).equals("ASCII")) ASCII = true; //default false
            timemult = Float.parseFloat(objs.remove(0));
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
    private static boolean setData1(List<String> objs)
    {
        try
        {
            station_name = objs.remove(0);
            rec_dev_id = objs.remove(0);
            rev_year = objs.remove(0);
            TT = Integer.parseInt(objs.remove(0));
            A = Integer.parseInt(objs.remove(0).replaceAll("A", ""));
            D = Integer.parseInt(objs.remove(0).replaceAll("D", ""));
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
    /**
     * Zwraca wszystkie wyrazy jakie mamy w pliku - info dla cb tustan trza to potem usunac
     * @param from
     * @param separator
     * @return 
     */
    public static List<String> getSeparated(List<String> from, String separator)
    {
        List<String> wynik = new ArrayList<>();
        for (String s : from) copyList(Arrays.asList(s.split(separator)),wynik);
        return wynik;
    }
    private static void copyList(List<String> from, List<String> to)
    {
        for (String s:from) to.add(s);
    }
    public static float readScience(String math){
        int where=math.indexOf('D');
        if(where==-1){
            return Float.valueOf(math);
        }
        String s1,s2;
        s1=math.substring(0, where);
        s2=math.substring(where+1);
        return (Float.parseFloat(s1)+(float)Math.pow(10, Float.parseFloat(s2)));
    }
    
    void makeXML(String path, int analogs[], int binaries[]){
        ObjectFactory factory=new ObjectFactory();
        
        CFG cfg = factory.createCFG();
        
        StationInfo stationInfo = factory.createStationInfo();
            
        stationInfo.setRevision(BigInteger.valueOf(Integer.valueOf(rec_dev_id)));
        stationInfo.setStationName(station_name);
        StationInfo.DeviceID deviceID = factory.createStationInfoDeviceID();
        deviceID.setValue(path);
        stationInfo.setDeviceID(deviceID);
                
        ChanelsCount chanelsCount = factory.createChanelsCount();
        Freq freq = factory.createFreq();
        FreqSampling freqSampling = factory.createFreqSampling();
        AnalogChanels analogchanels = factory.createAnalogChanels();
        DigitalChanels digitalchanels = factory.createDigitalChanels();
        
        cfg.setSTATION(stationInfo);
        cfg.setCHANELS(chanelsCount);  
        cfg.setFREQUENCY(freq);
        cfg.setSAMPLINGFREQCOUNT(BigInteger.valueOf(nrates));
        cfg.setSAMPLINGDATA(freqSampling);
        cfg.setFIRSTSAMPLETIME(date1);
        cfg.setLASTSAMPLETIME(date2);
        if (ASCII) cfg.setDATAFORMAT("ASCII");
        else cfg.setDATAFORMAT("Binary");
        cfg.setANALOGCHANELSDATA(analogchanels);
        cfg.setDIGITALCHANELSDATA(digitalchanels);
    }
}
    
abstract class Receiver
{
    
    int index; //index number
    String ch_id; //Channel identifier
    String ph; //Channel phase identification
    String ccbm; //circuit component being monitored XD CO
    
    
    abstract void resizeData();
}
class AnalogReceiver extends Receiver
{   
    float data[]; //data
    double rms = 0; // root mean square (wartosc srednia) //float bo mamy z instanceof w tamtym kawalku
    String/*int*/ uu; //channel units
    int a; //channel multiplier
    int b;// channel offset adder
    int skew; //channel time skew (in ms) from the start of sample period
    float min; //channel minimum data range value
    float max; //channel maximum data range value
    int primary; //channel voltage or current transformer ratio primary factor
    int secondary; //channel voltage or current transformer ratio secondary factor
    private boolean isprimary;//indicates whether the converted data is primary (P) or secondary (S)
    public AnalogReceiver(List<String> ls)
    {
        index = Integer.parseInt(ls.remove(0));
        ch_id = ls.remove(0);
        ph = ls.remove(0);
        ccbm = ls.remove(0);
        uu = ls.remove(0);
        a = Integer.parseInt(ls.remove(0));
        b = Integer.parseInt(ls.remove(0));
        skew = Integer.parseInt(ls.remove(0));
        min = Float.parseFloat(ls.remove(0));
        max = Float.parseFloat(ls.remove(0));
        primary = Integer.parseInt(ls.remove(0));
        secondary = Integer.parseInt(ls.remove(0));
        isprimary = ls.remove(0).equals("P");
    }
    public boolean isPrimary()
    {
        return isprimary;
    }
    /**
     * Oblicza wartość skuteczną
     * @return szukaną wartość
     */
    private double calculateRMS()
    {
        double sum = 0;
        for(float i : data) sum+=i;     
        sum = Math.pow(sum, 2);                   
        sum /= data.length;
        return Math.sqrt(sum);
    }

    @Override
    void resizeData() {
        this.data = new float[Dane.endsamp];
    }
    
    
}
class BinaryReceiver extends Receiver 
{
    BinaryReceiver(List<String> ls)
    {
        index = Integer.parseInt(ls.remove(0));
        ch_id = ls.remove(0);
        ph = ls.remove(0);
        ccbm = ls.remove(0);
        y = Integer.parseInt(ls.remove(0));
    }
    int y; //Normal state of status channel
    int data[];

    @Override
    void resizeData() {
        this.data = new int[Dane.endsamp];
    }
}
