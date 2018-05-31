package com.ataei.abbas.zekrshomar.Data;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class FDate
{
  protected static final long DAY_MILLIS=1000*60*60*24;
  protected static final int HOUR_MILLIS=1000*60*60;
  protected static final int MINUTE_MILLIS=1000*60;
  protected Date internalDate;
  protected String internalShamsiDate;

//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(long millis) {
    set(millis);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(){
    set();
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(int year, int month, int date) {
    set(year,month,date);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(int year, int month, int date,int hrs, int min, int sec){
    set(year,month,date,hrs,min,sec);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(int year, int month, int date,int hrs, int min){
    set(year,month,date,hrs,min);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(String shDate) {
    set(shDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(String shDate,long timeMillis) {
    set(shDate,timeMillis);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(String shDate ,int hrs, int min, int sec ) {
    set(shDate,hrs,min,sec);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(String shDate ,int hrs, int min) {
    set(shDate,hrs,min);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(Date miDate) {
    set(miDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(Date miDate,long timeMillis) {
     set(miDate,timeMillis);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(Date miDate ,int hrs, int min, int sec ) {
    set(miDate,hrs,min,sec);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FDate(Date miDate ,int hrs, int min) {
    set(miDate,hrs,min);
  }

//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public String composite(int year , int month , int date){
    String ys;
    String ms;
    String ds;
    DecimalFormat df=new DecimalFormat();
    df.applyPattern("0000");
    ys=df.format(year);
    df.applyPattern("00");
    ms=df.format(month);
    df.applyPattern("00");
    ds=df.format(date);
    return ys + "/" + ms + "/" + ds;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public int getField(int field){
    GregorianCalendar gc=new GregorianCalendar();
    gc.setTime(internalDate);
    return gc.get(field);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void setField(int field, int newValue){
    GregorianCalendar gc=new GregorianCalendar();
    gc.setTime(internalDate);
    gc.set(field,newValue);
    internalDate=gc.getTime();
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public Date get(){
    return internalDate;
  }
 //+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(long millis) {
    internalDate=new Date(millis);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(){
    internalDate=new Date();
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(int year, int month, int date) {
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(composite(year, month, date));
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(int year, int month, int date,int hrs, int min, int sec){
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(composite(year, month, date));
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    setField(Calendar.SECOND,sec);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(int year, int month, int date,int hrs, int min){
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(composite(year, month, date));
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(String shDate) {
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(shDate);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(String shDate,long timeMillis) {
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(shDate);
    internalDate= new Date(internalDate.getTime()+timeMillis);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(String shDate ,int hrs, int min, int sec ) {
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(shDate);
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    setField(Calendar.SECOND,sec);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);

  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(String shDate ,int hrs, int min) {
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(shDate);
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(Date miDate) {
    internalDate=miDate;
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(Date miDate,long timeMillis) {
    internalDate=new Date(miDate.getTime()+timeMillis);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(Date miDate ,int hrs, int min, int sec ) {
    internalDate=miDate;
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    setField(Calendar.SECOND,sec);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);

  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void set(Date miDate ,int hrs, int min) {
    internalDate=miDate;
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    internalShamsiDate=ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate);
  }

//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void setTime(int hrs,int min){
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
  }
  public void setTime(int hrs,int min,int sec){
    setField(Calendar.HOUR_OF_DAY,hrs);
    setField(Calendar.MINUTE,min);
    setField(Calendar.SECOND,sec);
  }
  public int getHour(){
    return getField(Calendar.HOUR_OF_DAY);
  }
  public int getMinute(){
    return getField(Calendar.MINUTE);
  }
  public int getSecond(){
    return getField(Calendar.SECOND);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public int getYear(){
    return ShamsiCalendar.getYear(ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate));
  }
  public int getMonth(){
    return ShamsiCalendar.getMonth(ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate));
  }
  public int getDate(){
    return ShamsiCalendar.getDate(ShamsiCalendar.miladiToShamsi_persiancoders_com(internalDate));
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public int dayOfWeek(){
    return getField(Calendar.DAY_OF_WEEK);
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public Date toMiladi(){
    return internalDate;
  }
  public String toString(){
    return internalShamsiDate;
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public boolean after(Date when){
    return internalDate.after(when);
  }
  public boolean after(FDate when){
    return internalDate.after(when.get());
  }
  public boolean before(Date when){
    return internalDate.before(when);
  }
  public boolean before(FDate when){
    return internalDate.before(when.get());
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public boolean equals(Date when){
    return internalDate.equals(when);
  }
  public boolean equals(FDate when){
    return internalDate.equals(when.get());
  }
  public int compareTo(Date when){
    return internalDate.compareTo(when);
  }
  public int compareTo(FDate when){
    return internalDate.compareTo(when.get());
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public long getMillis(){
   return internalDate.getTime();
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void nextDay(){
    internalDate.setTime(internalDate.getTime()+DAY_MILLIS);
    internalShamsiDate=ShamsiCalendar.nextDay(internalShamsiDate);
  }
  public void prevDay(){
    internalDate.setTime(internalDate.getTime()-DAY_MILLIS);
    internalShamsiDate=ShamsiCalendar.prevDay(internalShamsiDate);
  }
  public void nextMonth(){
    internalShamsiDate=ShamsiCalendar.nextMonth(internalShamsiDate);
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate);
  }
  public void prevMonth(){
    internalShamsiDate=ShamsiCalendar.prevMonth(internalShamsiDate);
    set(ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate),getHour(),getMinute(),getSecond());
  }
  public void nextYear(){
    internalShamsiDate=ShamsiCalendar.nextYear(internalShamsiDate);
    internalDate=ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate);
  }
  public void prevYear(){
    internalShamsiDate=ShamsiCalendar.prevYear(internalShamsiDate);
    set(ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate),getHour(),getMinute(),getSecond());
  }
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//|
//|
//+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public void plusDay(int dayCount){
    internalShamsiDate=ShamsiCalendar.plusDay(internalShamsiDate,dayCount);
    set(ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate),getHour(),getMinute(),getSecond());
  }
  public void minusDay(int dayCount){
    internalShamsiDate=ShamsiCalendar.minusDay(internalShamsiDate,dayCount);
    set(ShamsiCalendar.shamsiToMiladi_persiancoders(internalShamsiDate),getHour(),getMinute(),getSecond());
  }

  public int minusDate(String shDate)
  {
    long m1 = getMillis();
    long m2 = (new FDate(shDate)).getMillis();
    long diff = m1-m2;
    if (diff<0)
      diff *= -1;

    return (int)ShamsiCalendar.millisToDay(diff);
  }

  public static int diffDate(String shDt1, String shDt2)
  {
    FDate fd = new FDate(shDt1);
    return fd.minusDate(shDt2);
  }
}
