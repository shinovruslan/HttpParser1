package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args)  {

        XmlConfig x = new XmlConfig();



        BusObj s = new BusObj();
        //Date d = new Date();
        Calendar date_end = Calendar.getInstance();
        date_end.setTime(new Date());
        date_end.add(Calendar.DATE, -1); /*TODO Нужно продумать запуск в выходные*/

        Calendar date_begin = Calendar.getInstance();
        date_begin.setTime(new Date());
        date_begin.add(Calendar.DATE, -1); /*TODO Нужно продумать запуск в выходные*/

        DbUtils db = new DbUtils(x.jdbcHost, x.jdbcUser, x.jdbcPassword);


        if (args.length>0) //Первый запуск - любой параметр
        {
            Calendar s_date_end = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                s_date_end.setTime(format.parse("01/01/1970"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            while (s_date_end.getTime().compareTo(date_begin.getTime()) < 0) {
            //    System.out.println(s_date_end.getTime().toString());

                Date s_date_begin = s_date_end.getTime();

                s_date_end.add(Calendar.MONTH, 1);

                for (BusObj.marketUnit u : s.units) {

                    try {
                        db.insert(
                                HttpUtils.getReq(u.id, s_date_begin, s_date_end.getTime(), x.proxyHost, x.proxyPort, x.proxyUser, x.proxyPassword),
                                u.name,
                                u.typ,
                                u.group,
                                u.edinica,
                                u.tiker,
                                u.ref);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            for (BusObj.marketUnit u : s.units) {

                try {
                    db.insert(
                            HttpUtils.getReq(u.id, s_date_end.getTime(), date_begin.getTime(), x.proxyHost, x.proxyPort, x.proxyUser, x.proxyPassword),
                            u.name,
                            u.typ,
                            u.group,
                            u.edinica,
                            u.tiker,
                            u.ref);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }//Конец первый запуск

        for (BusObj.marketUnit u:s.units)
        {

            try {
                db.insert(
                        HttpUtils.getReq(u.id,date_begin.getTime(),date_end.getTime(), x.proxyHost, x.proxyPort, x.proxyUser, x.proxyPassword),
                        u.name,
                        u.typ,
                        u.group,
                        u.edinica,
                        u.tiker,
                        u.ref);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //

    }
}
