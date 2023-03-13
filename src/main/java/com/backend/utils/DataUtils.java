package com.backend.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class DataUtils {
    public static String getDataFromTestDataFile(String sheetName, String id, String field) {
        String result = null;
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.
                    getConnection(
                            "C:\\Users\\Mustafa\\IdeaProjects\\restAssured\\resources\\BookingData.xlsx");
            String strQuery = "Select * from " + sheetName + " where ID='" + id + "'";
            Recordset recordset = connection.executeQuery(strQuery);

            while (recordset.next()) {
                result = recordset.getField(field);
            }

            recordset.close();
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        }
        return result;
    }
}
