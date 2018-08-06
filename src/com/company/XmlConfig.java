package com.company;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlConfig {

    public String proxyHost;
    public String proxyPort;
    public String proxyUser;
    public String proxyPassword;
    public String jdbcHost;
    public String jdbcUser;
    public String jdbcPassword;


    void loadConfig() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("configXML.xml");
        prop.loadFromXML(fis);
        prop.list(System.out);
        //System.out.println(prop.getProperty("proxyHost"));
        proxyHost = prop.getProperty("proxyHost");
        proxyPort = prop.getProperty("proxyPort");
        proxyUser = prop.getProperty("proxyUser");
        proxyPassword = prop.getProperty("proxyPassword");

        jdbcHost = prop.getProperty("jdbcHost");
        jdbcUser = prop.getProperty("jdbcUser");
        jdbcPassword = prop.getProperty("jdbcPassword");
    }

    public  XmlConfig(){
        try {
            loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
