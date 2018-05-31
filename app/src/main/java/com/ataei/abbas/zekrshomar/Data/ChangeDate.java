package com.ataei.abbas.zekrshomar.Data;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;


public class ChangeDate
{

  public static String getCurrentDate()
  {
    FDate curDate = new FDate(System.currentTimeMillis());
    return curDate.toString();
  }

  public static String getCurrentTime()
  {
    FDate curDate = new FDate(System.currentTimeMillis());
//    String time = curDate.getHour() + ":"+curDate.getMinute()+":"+curDate.getSecond();
    return getCompleteTimeString_persiancoders(curDate);
  }

  public static String getCompleteTimeString_persiancoders(FDate fdate)
  {
    StringBuffer b = new StringBuffer();
    b.append((fdate.getHour() < 10) ? "0" + (fdate.getHour()) :
               String.valueOf(fdate.getHour()));
    b.append(":");
    b.append((fdate.getMinute() < 10) ? "0" + (fdate.getMinute()) :
               String.valueOf(fdate.getMinute()));
    b.append(":");
    b.append((fdate.getSecond() < 10) ? "0" + (fdate.getSecond()) :
             String.valueOf(fdate.getSecond()));
    return b.toString();
  }



  public static int getCurrentYear()
  {
    FDate curDate = new FDate(System.currentTimeMillis());
    return curDate.getYear();
  }

  public static int getCurrentMonth()
  {
    FDate curDate = new FDate(System.currentTimeMillis());
    return curDate.getMonth();
  }

  public static int getCurrentDay()
  {
    FDate curDate = new FDate(System.currentTimeMillis());
    return curDate.getDate();
  }


  public static Date toDate(String formattedDate)
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    ParsePosition pos = new ParsePosition(0);
    Date d = dateFormat.parse(formattedDate,pos);
    return d;
  }


  public static String invertDate(String fdate)
  {
    String yyyy = null;
    String mm = null;
    String dd = null;

    if (fdate==null || fdate.length()==0)
      return "";
    StringTokenizer strTokenizer = new StringTokenizer(fdate,"/");
    if (strTokenizer.hasMoreTokens())
    {
      yyyy = strTokenizer.nextToken();
      if (strTokenizer.hasMoreTokens())
      {
        mm = strTokenizer.nextToken();
        if (strTokenizer.hasMoreTokens())
        {
          dd = strTokenizer.nextToken();
          return dd+"/"+mm+"/"+yyyy;
        }
      }
    }
    return fdate;
  }



  public static String changeFarsiToMiladi(String farsiDate)
  {
    Date miladiDate = ShamsiCalendar.shamsiToMiladi_persiancoders(farsiDate);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    return dateFormat.format(miladiDate);
  }

  public static String changeMiladiToFarsi(String miladiDate)
  {
    return ShamsiCalendar.miladiToShamsi_persiancoders_com(toDate(miladiDate));
  }


  public static String getDayMounthYear(){
    return ShamsiCalendar.weekDayName(ShamsiCalendar.dayOfWeek(ChangeDate.getCurrentDate()))+ " "+
           ShamsiCalendar.monthDayName(ChangeDate.getCurrentDay())+
           ShamsiCalendar.monthName(ChangeDate.getCurrentMonth()) +" ماه "  +
           String.valueOf(ChangeDate.getCurrentYear());
  }

    public static String decreaseYear (String CurrDate , int cnt){
        String year = CurrDate.substring(0,4);
        int ny = Integer.decode(year) - cnt;
        return String.valueOf(ny) + CurrDate.substring(4);
    }

    public static String decreaseCurrentYear (int cnt){
        String cur = getCurrentDate();
        String year = cur.substring(0,4);
        int ny = Integer.decode(year) - cnt;
        return String.valueOf(ny) + cur.substring(4);
    }

    public static String increaseYear (String tavalodDate , int cnt){
        String year = tavalodDate.substring(0,4);
        int ny = Integer.decode(year) + cnt;
        return String.valueOf(ny) + tavalodDate.substring(4);
    }

    public static String increaseCurrentYear (int cnt){
        String cur = getCurrentDate();
        String year = cur.substring(0,4);
        int ny = Integer.decode(year) + cnt;
        return String.valueOf(ny) + cur.substring(4);
    }
    public static String getCurrentDateTimeString()
    {
      FDate curDate = new FDate(System.currentTimeMillis());
      return curDate.toString().concat(" ").concat(getCompleteTimeString_persiancoders(curDate));
    }

}

