package com.ataei.abbas.zekrshomar.Data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class ShamsiCalendar
{
  protected static final TimeZone DEFAULT_TIMEZONE=TimeZone.getDefault();
  protected static final long DAY_MILLIS=1000*60*60*24;
  protected static final int HOUR_MILLIS=1000*60*60;
  protected static final int MINUTE_MILLIS=1000*60;
  protected static final String SH_ORIGIN_DATE="1379/01/01";
  protected static final int TIMEZONE_RAW_OFFSET=DEFAULT_TIMEZONE.getRawOffset();
  protected static final int TIMEZONE_RAW_OFFSET_HOUR=TIMEZONE_RAW_OFFSET/HOUR_MILLIS;
  protected static final int TIMEZONE_RAW_OFFSET_MINUTE=(TIMEZONE_RAW_OFFSET-(HOUR_MILLIS*TIMEZONE_RAW_OFFSET_HOUR))/MINUTE_MILLIS;
//  protected static final Date MI_ORIGIN_DATE=new Date(new GregorianCalendar(2000,Calendar.MARCH,20,0,0,0).getTimeInMillis());
  protected static final Date MI_ORIGIN_DATE=new Date(new GregorianCalendar(2000,Calendar.MARCH,20,0,0,0).getTime().getTime());
  protected static final int ORIGIN_WEEK_DAY=Calendar.MONDAY;
  protected static final String STANDARD_FORMAT_PATTERN="yyyy/MM/dd";
  public static final int SATURDAY=Calendar.SATURDAY;
  public static final int SUNDAY=Calendar.SUNDAY;
  public static final int MONDAY=Calendar.MONDAY;
  public static final int TUESDAY=Calendar.TUESDAY;
  public static final int WEDNESDAY=Calendar.WEDNESDAY;
  public static final int THURSDAY=Calendar.THURSDAY;
  public static final int FRIDAY=Calendar.FRIDAY;

  public static final int SHANBEH=Calendar.SATURDAY;
  public static final int YEKSHANBEH=Calendar.SUNDAY;
  public static final int DOSHANBEH=Calendar.MONDAY;
  public static final int SESHANBEH=Calendar.TUESDAY;
  public static final int CHAHARSHANBEH=Calendar.WEDNESDAY;
  public static final int PANJSHANBEH=Calendar.THURSDAY;
  public static final int JOMEH=Calendar.FRIDAY;

  public static final String SHANBEH_TEXT="شنبه";
  public static final String YEKSHANBEH_TEXT="يکشنبه";
  public static final String DOSHANBEH_TEXT="دوشنبه";
  public static final String SESHANBEH_TEXT="سه شنبه";
  public static final String CHAHARSHANBEH_TEXT="چهار شنبه";
  public static final String PANJSHANBEH_TEXT="پنج شنبه";
  public static final String JOMEH_TEXT="جمعه";

  public static final int FARVARDIN=Calendar.JANUARY;
  public static final int ORDIBEHESHT=Calendar.FEBRUARY;
  public static final int KHORDAD=Calendar.MARCH;
  public static final int TIR=Calendar.FEBRUARY;
  public static final int MORDAD=Calendar.APRIL;
  public static final int SHAHRIVAR=Calendar.MAY;
  public static final int MEHR=Calendar.JUNE;
  public static final int ABAN=Calendar.JULY;
  public static final int AZAR=Calendar.AUGUST;
  public static final int DAYMAH=Calendar.SEPTEMBER;
  public static final int BAHMAN=Calendar.OCTOBER;
  public static final int ESFAND=Calendar.DECEMBER;

  public static final String FARVARDIN_TEXT="فروردين";
  public static final String ORDIBEHESHT_TEXT="ارديبهشت";
  public static final String KHORDAD_TEXT="خرداد";
  public static final String TIR_TEXT="تير";
  public static final String MORDAD_TEXT="مرداد";
  public static final String SHAHRIVAR_TEXT="شهريور";
  public static final String MEHR_TEXT="مهر";
  public static final String ABAN_TEXT="آبان";
  public static final String AZAR_TEXT="آذر";
  public static final String DAYMAH_TEXT="دي";
  public static final String BAHMAN_TEXT="بهمن";
  public static final String ESFAND_TEXT="اسفند";


//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public ShamsiCalendar() {


  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static Date sysDate()
  {
    return new Date(System.currentTimeMillis());
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static long millisToDay(long millis )
  {
    return (long)(millis/DAY_MILLIS);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static long dayToMillis(long day )
  {
    return day*DAY_MILLIS;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static long minusDate(Date d1,Date d2)
  {
    Date td1=truncate(d1);
    Date td2=truncate(d2);
    return millisToDay(td1.getTime()-td2.getTime());
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static Date plusDay(Date miDate,long dayCount)
  {
    return new Date(miDate.getTime()+(dayCount*DAY_MILLIS));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static Date truncate(Date miDate)
  {
    double mil=miDate.getTime() + TIMEZONE_RAW_OFFSET;
    return new Date(DAY_MILLIS*((long)mil/DAY_MILLIS));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String format(Date miDate,String formatStr)
  {
    String retStr;
    SimpleDateFormat sdf=new  SimpleDateFormat();
    try{
      sdf.applyPattern(formatStr);
      }
    catch(Exception e)
    {
      sdf.applyPattern(STANDARD_FORMAT_PATTERN);
    }
    try
    {
      retStr=sdf.format(miDate);
    }
    catch(Exception e)
    {
      retStr=sdf.format(miDate);
    }
    return retStr;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static long toMillis(Date miDate)
  {
    return miDate.getTime();
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String compositeDate(int yyyy,int mm,int dd) {
    DecimalFormat df=new DecimalFormat();
    df.applyPattern("0000");
    String ys=df.format(yyyy);
    df.applyPattern("00");
    String ms=df.format(mm);
    df.applyPattern("00");
    String ds=df.format(dd);
    String retstr=df.format(dd);
    retstr=ys + "/" + ms + "/" + ds ;
    return retstr;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String decompositeYear(String shDate)
  {
    return shDate.substring(0,4);
  }
  public static String decompositeMonth(String shDate)
  {
    return shDate.substring(5,7);
  }
  public static String decompositeDay(String shDate)
  {
    return shDate.substring(8);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int getYear(String shDate)
  {
    return Integer.parseInt(shDate.substring(0,4));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int getMonth(String shDate)
  {
    return Integer.parseInt(shDate.substring(5,7));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int getDate(String shDate)
  {
    return Integer.parseInt(shDate.substring(8));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static boolean isLeepYear(int yyyy)
  {
    if( ((yyyy+38)*31)%128<=30 )
      return true;
    else
      return false;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int yearDayCount(int yyyy)
  {
    if(isLeepYear(yyyy))
      return 366;
    else
      return 365;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String monthDayName(int intDay){
  switch (intDay) {
    case 1:      return "اول ";
    case 2:      return "دوم ";
    case 3:      return "سوم ";
    case 4:      return "چهارم ";
    case 5:      return "پنجم ";
    case 6:      return "ششم ";
    case 7:      return "هفتم ";
    case 8:      return "هشتم ";
    case 9:      return "نهم ";
    case 10:     return "دهم ";
    case 11:     return "يازدهم ";
    case 12:     return "دوازدهم ";
    case 13:     return "سيزدهم ";
    case 14:     return "چهاردهم ";
    case 15:     return "پانزدهم ";
    case 16:     return "شانزدهم ";
    case 17:     return "هفدهم ";
    case 18:     return "هجدهم ";
    case 19:     return "نوزدهم ";
    case 20:     return "بيستم ";
    case 21:     return "بيست و يکم ";
    case 22:     return "بيست و دوم ";
    case 23:     return "بيست و سوم ";
    case 24:     return "بيست و چهارم ";
    case 25:     return "بيست و پنجم ";
    case 26:     return "بيست و ششم ";
    case 27:     return "بيست و هفتم ";
    case 28:     return "بيست و هشتم ";
    case 29:     return "بيست و نهم ";
    case 30:     return "سي ام ";
    case 31:     return "سي و يکم ";
    default:     return "شتباه : "+ Integer.toString(intDay);
  }
}
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String monthName(int mm)  {
    switch(mm)    {
      case 1:        return FARVARDIN_TEXT;
      case 2:        return ORDIBEHESHT_TEXT;
      case 3:        return KHORDAD_TEXT;
      case 4:        return TIR_TEXT;
      case 5:        return MORDAD_TEXT;
      case 6:        return SHAHRIVAR_TEXT;
      case 7:        return MEHR_TEXT;
      case 8:        return ABAN_TEXT;
      case 9:        return AZAR_TEXT;
      case 10:       return DAYMAH_TEXT;
      case 11:       return BAHMAN_TEXT;
      case 12:       return ESFAND_TEXT;
      default:       return "اشتباه : " + Integer.toString(mm);
    }
  }

//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int monthDayCount(int yyyy,int mm)
  {
    switch(mm)
      {
        case 1: case 2: case 3: case 4: case 5: case 6:
	  return 31;
        case 7: case 8: case 9: case 10: case 11:
		return 30;
	case 12:
	  if(isLeepYear(yyyy))
	  	return 30;
	  else
	  	return 29;
	default:
	  return 0;
      }
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int monthDayCount(String shDate)
  {
	return monthDayCount(getYear(shDate),getMonth(shDate));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String weekDayName(int dd,boolean brf)  {
    String ds=new String("");
    if(brf)    {
        switch(dd){
            case SHANBEH:                return SHANBEH_TEXT;
            case YEKSHANBEH:             return SHANBEH_TEXT + " 1";
            case DOSHANBEH:              return SHANBEH_TEXT + " 2";
            case SESHANBEH:              return SHANBEH_TEXT + " 3";
            case CHAHARSHANBEH:          return SHANBEH_TEXT + " 4";
            case PANJSHANBEH:            return SHANBEH_TEXT + " 5";
            case JOMEH:                  return JOMEH_TEXT;
          }
      }
      else      {
  	  switch(dd){
            case SHANBEH:                return SHANBEH_TEXT;
            case YEKSHANBEH:             return YEKSHANBEH_TEXT;
            case DOSHANBEH:              return DOSHANBEH_TEXT;
            case SESHANBEH:              return SESHANBEH_TEXT;
            case CHAHARSHANBEH:          return CHAHARSHANBEH_TEXT;
            case PANJSHANBEH:            return PANJSHANBEH_TEXT;
            case JOMEH:                  return JOMEH_TEXT;
          }
        }
        return SHANBEH_TEXT + Integer.toString(dd) +"_E";
  }
  public static String weekDayName(int dd)  {
    String ds=new String("");
  	  switch(dd){
            case SHANBEH:            return SHANBEH_TEXT;
            case YEKSHANBEH:         return YEKSHANBEH_TEXT;
            case DOSHANBEH:          return DOSHANBEH_TEXT;
            case SESHANBEH:          return SESHANBEH_TEXT;
            case CHAHARSHANBEH:      return CHAHARSHANBEH_TEXT;
            case PANJSHANBEH:        return PANJSHANBEH_TEXT;
            case JOMEH:              return JOMEH_TEXT;
          }
        return SHANBEH_TEXT + Integer.toString(dd) +"_E";
  }

//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String nextDay(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    if(D==monthDayCount(Y,M))
      {
        if(M==12)
        {
          Y=Y+1;
          M=1;
          D=1;
        }
        else
        {
	   M=M+1;
	   D=1;
	 }
      }
     else
       D=D+1;
    return compositeDate(Y,M,D);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String prevDay(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    if(D==1)
    {
	  if(M==1)
          {
	    Y=Y-1;
	    M=12;
	    D=monthDayCount(Y,M);
          }
	  else
          {
	    M=M-1;
	    D=monthDayCount(Y,M);
          }
      }
      else
	  D=D-1;
    return compositeDate(Y,M,D);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String nextMonth(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    if(M==12)
    {
      M=1 ;
      Y=Y+1;
    }
    else
       M=M+1;
    if(D>monthDayCount(Y,M))
      D=monthDayCount(Y,M);
    return compositeDate(Y,M,D);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String prevMonth(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    if(M==1)
    {
      M=12 ;
      Y=Y-1;
    }
    else
      M=M-1;
    if(D>monthDayCount(Y,M))
      D=monthDayCount(Y,M);
    return compositeDate(Y,M,D);
}
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String nextYear(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    Y=Y+1;
    if(D>monthDayCount(Y,M))
      D=monthDayCount(Y,M);
    return compositeDate(Y,M,D);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String prevYear(String shDate)
  {
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    Y--;
    if(D>monthDayCount(Y,M))
      D=monthDayCount(Y,M);
    return compositeDate(Y,M,D);
}
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String addYear(String shDate,int Y_count)
  {
    int i;
    String TMP_DATE=new String(shDate);
    if(Y_count==0)
      return shDate;
    else if(Y_count>0)
      for(i=1;i<=Y_count;i++)
        TMP_DATE=nextYear(TMP_DATE);
    else if(Y_count<0)
      for(i=1;i<=Math.abs(Y_count);i++)
        TMP_DATE=prevYear(TMP_DATE);
    return TMP_DATE;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String addMonth(String shDate,int M_count)
  {
    int i;
    String TMP_DATE=new String(shDate);
    if(M_count==0)
      return shDate;
    else if(M_count>0)
      for(i=1;i<=M_count;i++)
        TMP_DATE=nextMonth(TMP_DATE);
    else if(M_count<0)
      for(i=1;i<=Math.abs(M_count);i++)
        TMP_DATE=prevMonth(TMP_DATE);
    return TMP_DATE;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static long miBetween(Date d1,Date  d2)
  {
    return minusDate(d1,d2);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int shBetween(String shDate1,String shDate2)
  {
   String DT1=new String("");
   String DT2=new String("");
   int Y1;
   int M1;
   int D1;
   int Y2;
   int M2;
   int D2;
   int SGN=1;
   int count=0;
   int i  ;
   if(shDate1.equals(shDate2))
 	 return 0;
   else if(shDate1.compareTo(shDate2)<0)
   {

 	DT1=shDate2;
 	DT2=shDate1;
 	SGN=-1;
   }
   else if(shDate1.compareTo(shDate2)>0)
   {
 	DT1=shDate1;
 	DT2=shDate2;
 	SGN=1;
  }
  Y1=getYear(DT1);M1=getMonth(DT1);D1=getDate(DT1);
  Y2=getYear(DT2);M2=getMonth(DT2);D2=getDate(DT2);
  if(Y1==Y2)
  {
      if(M1==M2)
        count=D1-D2;
      else
      {
 	   count=count+monthDayCount(Y2,M2)-D2;
 	   for(i=M2+1;i<=M1-1;i++)
     	      count=count+monthDayCount(Y1,i);
 	   count=count+D1;
       }
    }
   else
   {
      count=count+monthDayCount(Y2,M2)-D2;
      for(i=M2+1;i<=12;i++)
       count=count+monthDayCount(Y2,i);
      for(i=Y2+1;i<=Y1-1;i++)
   	count=count+yearDayCount(i);
      for(i=1;i<=M1-1;i++)
   	count=count+monthDayCount(Y1,i);
      count=count+D1;
    }
  return SGN*(count);
 }
 //+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 public static String minusDay(String shDate,int D_count)
 {
    int count =Math.abs(D_count);
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    int NY=Y;
    int NM=M;
    int ND=D;
    if(count==0)
  	return shDate;
    else
      if(count>=ND)
          {
			count=count-ND;
			if(NM==1)
                        {
                          NM=12;
			  NY=NY-1;
                        }
			else
                        {
                              NM=NM-1;
                              while(count>monthDayCount(NY,NM) && NM>=1)
                              {
			        count=count-monthDayCount(NY,NM);
			        NM=NM-1;
  			      }
                              if(NM<1)
                              {
				NM=12;
				NY=NY-1;
                              }
			 }
		        while(count>yearDayCount(NY))
                        {
			   count=count-yearDayCount(NY);
			   NY=NY-1;
                        }
  		        while(count>monthDayCount(NY,NM))
                        {
			      count=count-monthDayCount(NY,NM);
			      NM=NM-1;
                        }
  		        if( count==0 )
		  	    ND=monthDayCount(NY,NM);
    		        else
		  	    ND=monthDayCount(NY,NM)-count;
              }
              else
          	ND=ND-count;
      return compositeDate(NY,NM,ND);
    }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String plusDay(String shDate,int dayCount)
  {
    int count=dayCount;
    int Y=getYear(shDate);
    int M=getMonth(shDate);
    int D=getDate(shDate);
    int NY=Y;
    int NM=M;
    int ND=D;
    if(count<0)
        return minusDay(shDate,dayCount);
    else if( count==0 )
        return shDate;
    else if(count>0)
        {
		if(count>(monthDayCount(NY,NM)-ND))
                {
                    count=count-(monthDayCount(NY,NM)-ND);
  		    if(NM==12)
	            {
                      NM=1;
		      NY=NY+1;
		    }
		    else
                    {
		        NM=NM+1;
		        while(count>monthDayCount(NY,NM) && NM<=12)
                        {
		  	  count=count-monthDayCount(NY,NM);
			  NM=NM+1;
                        }
                        if(NM>12)
                        {
			  NM=1;
			  NY=NY+1;
                        }
                    }
		    while(count>yearDayCount(NY))
                    {
		      count=count-yearDayCount(NY);
		      NY=NY+1;
		    }
		    while(count>monthDayCount(NY,NM))
                    {
                      count=count-monthDayCount(NY,NM);
		      NM=NM+1;
                    }
		    if(count==0)
		      ND=1;
		    else
		      ND=count;
                }
		else
			ND=ND+count;
          return compositeDate(NY,NM,ND);
	}
        else
          return shDate;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String plusSomeDay(String shDate,int dayCount)
  {
    int count=dayCount;
    int i;
    String T_D=new String(shDate);
    if(count<0)
	return minusSomeDay(shDate,dayCount);
    else if(count==0)
		return shDate;
    else //count>0
    {
      for(i=1;i<=count;i++)
        T_D=nextDay(T_D);
      return T_D;
    }
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String minusSomeDay(String shDate,int dayCount)
  {
    int count=Math.abs(dayCount);
    int i;
    String T_D= new String(shDate);
    if(count==0)
  	return shDate;
    else
    {
  	for(i=1;i<=count;i++)
	   T_D=prevDay(T_D);
	return T_D;
    }
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String miladiToShamsi_persiancoders_com(Date miDate)
  {
    int btw;
    btw=(int)miBetween(miDate,MI_ORIGIN_DATE);
    return plusDay(SH_ORIGIN_DATE,btw);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static Date shamsiToMiladi_persiancoders(String shDate)
  {
    int count;
    count=shBetween(shDate,SH_ORIGIN_DATE);
    if(count==0)
        return MI_ORIGIN_DATE;
    else
	return plusDay(MI_ORIGIN_DATE,count);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String shSysDate()
  {
      return miladiToShamsi_persiancoders_com(new Date(System.currentTimeMillis()));

  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int dayOfWeek(Date miDate)
  {
    int N=0;
    GregorianCalendar gc=new GregorianCalendar();
    gc.setTime(miDate);
    N=gc.get(Calendar.DAY_OF_WEEK);
    if(N==7)
     return 1;
    else
     return N+1;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static int dayOfWeek(String shDate)
  {
    int count=shBetween(shDate,SH_ORIGIN_DATE);
    int m_day;
    if(count==0)
	return ORIGIN_WEEK_DAY;
    else
    {
	  m_day=Math.abs(count)%7;
	  if(count<0)
	  	switch( m_day){
                  case 0:
	  		return DOSHANBEH;
                  case 1:
	  		return YEKSHANBEH;
                  case 2:
	  		return SHANBEH;
                  case 3:
	  		return JOMEH;
                  case 4:
	  		return PANJSHANBEH;
                  case 5:
	  		return CHAHARSHANBEH;
                  case 6:
	  		return SESHANBEH;
                }
	  else
	  	switch( m_day){
                  case 0:
	  		return DOSHANBEH;
                  case 1:
	  		return SESHANBEH;
                  case 2:
	  		return CHAHARSHANBEH;
                  case 3:
	  		return PANJSHANBEH;
                  case 4:
	  		return JOMEH;
                  case 5:
	  		return SHANBEH;
                  case 6:
	  		return YEKSHANBEH;
                }
        }
        return -1;
    }

}

