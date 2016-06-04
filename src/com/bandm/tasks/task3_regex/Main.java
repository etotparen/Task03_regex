package com.bandm.tasks.task3_regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        String regex = "";
        String pathToTxtFileWithDataList = "IP_list.txt";
        regex_match(pathToTxtFileWithDataList, regex);
    }

    public static void regex_match( String pathToTxtFileWithDataList, String regex) throws Exception {
//        InputStream inputfile = new InputStreamReader(new FileReader(pathToTxtFileWithDataList));
        BufferedReader reader = new BufferedReader(new FileReader(pathToTxtFileWithDataList));
        ArrayList<String> listIP = new ArrayList<String>();
        String stringWithIP;
        while ((stringWithIP = reader.readLine())!= null) {
            listIP.add(stringWithIP);
        }

        FileWriter writer = new FileWriter("IP_list_result.txt", true);
        for (String s : listIP) {
            Pattern p = Pattern.compile("0-9");
            Matcher m = p.matcher(s);
//            System.out.println(m.matches());
            writer.append(s + "     " + m.matches());

            writer.flush();
        }


    }
}