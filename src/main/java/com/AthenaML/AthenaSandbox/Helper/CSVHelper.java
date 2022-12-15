package com.AthenaML.AthenaSandbox.Helper;

import com.AthenaML.AthenaSandbox.Domain.MatchResult;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERS = {"Country","League","Season","Date","Time","Home","Away","HG","AG","Res","PH","PD","PA","MaxH","MaxD","MaxA","AvgH","AvgD","AvgA"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }



    public static List<MatchResult> csvToDatabase(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<MatchResult> matchResultList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                MatchResult matchResult = new MatchResult(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("country"),
                        csvRecord.get("league"),
                        csvRecord.get("season"),
                        csvRecord.get("date"),
                        csvRecord.get("time"),
                        csvRecord.get("home"),
                        csvRecord.get("away"),
                        csvRecord.get("homeGoals"),
                        csvRecord.get("awayGoals"),
                        csvRecord.get("result"),
                        csvRecord.get("pHomeOdds"),
                        csvRecord.get("pDrawOdds"),
                        csvRecord.get("pAwayOdds"),
                        csvRecord.get("maxHomeWinOdds"),
                        csvRecord.get("maxDrawOdds"),
                        csvRecord.get("maxAwayOdds"),
                        csvRecord.get("avgHomeOdds"),
                        csvRecord.get("avgDrawOdds"),
                        csvRecord.get("avgAwayOdds")
                );



                matchResultList.add(matchResult);
            }

            return matchResultList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}

