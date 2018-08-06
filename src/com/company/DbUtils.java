package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    String jdbc;
    String user;
    String password;

    public DbUtils(String jdbc, String user, String password){

        this.jdbc = jdbc;
        this.user = user;
        this.password = password;

    }

    public void insert (Document doc,
                        String name,
                        String typ,
                        String group,
                        String edinica,
                        String tiker,
                        String ref
                        ) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(jdbc,user,password);


        Statement statement = connection.createStatement();
        parser(doc,name,typ,group,edinica,tiker,ref,statement);
        connection.close();
    }

    void parser(Document doc,
                              String name,
                              String typ,
                              String group,
                              String edinica,
                              String tiker,
                              String ref,
                              Statement statement) throws SQLException {

      /*  class Par{
            String rus_name;
            String val;

            public Par(String rus_name, String val) {
                this.rus_name = rus_name;
                this.val = val;
            }
        }
    */

        Map m = new HashMap<Integer, String>();
        m.put(1, ""); //Дата
        m.put(2, ""); //Цена
        m.put(3, "");//Открытие
        m.put(4, "");//Макс
        m.put(5, "");//Мин
        m.put(6, "");//Объем
        m.put(7, "");//Изм

        final List<Element> elms = doc.select("body").select("div").select("table").select("tbody").first().select("tr");
        List<Element> tr;

        //System.out.println(elms.size());
        for (Element c : elms) {
            tr = c.select("tr").select("td");

            int i = 0;
            for (Element td : tr) {
                i = i + 1;
               /* Par p = (Par) m.get(i);
                p.val = td.text();*/
                m.put(i, td.text());
                //System.out.println(i+" "+ m.get(i));
                //System.out.println(p.rus_name+" "+ p.val);
            }

            String insert = "insert into testa (dt_torg, price,open_price, max_prica, min_price, val_torg, delt, name, typ, group_, ed, tiker, ref_)values" +
                    "('" + m.get(1)+ "', '" + m.get(2)+ "', '"+ m.get(3)+ "', '"+ m.get(4)+ "', '"+ m.get(5)+ "', '"+ m.get(6)+ "', '"+ m.get(7)+ "', '"+name + "', '"+typ + "', '"+group + "', '"+edinica + "', '"+tiker + "', '"+ref + "')";
            statement.executeUpdate(insert);

        }

    }


}
