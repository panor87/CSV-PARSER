package com.rod.demo.service;

import com.rod.demo.dao.VentaRepository;
import com.rod.demo.entity.Venta;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VentaService {

    public static final String SQL = "SELECT region AS \"Region\", country AS \"Country\", item_type AS \"Item Type\",sales_channel AS \"Sales Channel\",order_priority AS " +
            "\"Order Priority\" ,order_date AS \"Order Date\",order_id AS \"Order ID\" ,ship_date AS \"Ship Date\",units_sold AS \"Units Sold\"," +
            "unit_price AS \"Unit Price\",unit_cost AS \"Unit Cost\", total_revenue AS \"Total Revenue\",total_cost AS \"Total Cost\"," +
            "total_profit AS \"Total Profit\" FROM venta ORDER BY order_id ASC;";

    public static final String URL = "jdbc:postgresql://localhost:5432/venta";

    public static final String home = System.getProperty("user.home");

    public static final String OutputFile = "/home/user/Downloads/salida.csv";
    private String folder="src/main/resources/carga//";

    private final Logger logg = LoggerFactory.getLogger(VentaService.class);

    private final VentaRepository repository;

    private List<Venta> lista = new ArrayList<Venta>();
    private List<String> header;

    private String nombre="";

    public VentaService(VentaRepository ventaRepository) {
        this.repository = ventaRepository;
    }


    public String save(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                nombre=file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
                Path path = Paths.get(folder + file.getOriginalFilename());
                Files.write(path, bytes);
                logg.info("Archivo guardado");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {

            //FileReader fileReader = new FileReader(InputFile);
            FileReader fileReader = new FileReader("src/main/resources/carga/"+nombre+".csv");
            header = new ArrayList<>();
            header.add("Region");
            header.add("Country");
            header.add("Item Type");
            header.add("Sales Channel");
            header.add("Order Priority");
            header.add("Order Date");
            header.add("Order Id");
            header.add("Ship Date");
            header.add("Units Sold");
            header.add("Unit Price");
            header.add("Unit Cost");
            header.add("Total Revenue");
            header.add("Total Cost");
            header.add("Total Profit");
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {

                Venta venta = new Venta(
                        csvRecord.get("Region"),
                        csvRecord.get("Country"),
                        csvRecord.get("Item Type"),
                        csvRecord.get("Sales Channel"),
                        csvRecord.get("Order Priority"),
                        csvRecord.get("Order Date"),
                        Long.parseLong(csvRecord.get("Order Id")),
                        csvRecord.get("Ship Date"),
                        Long.parseLong(csvRecord.get("Units Sold")),
                        Float.parseFloat(csvRecord.get("Unit Price")),
                        Float.parseFloat(csvRecord.get("Unit Cost")),
                        Double.parseDouble(csvRecord.get("Total Revenue")),
                        Double.parseDouble(csvRecord.get("Total Cost")),
                        Double.parseDouble(csvRecord.get("Total Profit"))
                );

                lista.add(venta);
                if (lista.size() > 1000) {
                    repository.saveAll(lista);
                    lista.clear();
                }

            }
            if (lista.size() > 0) repository.saveAll(lista);
            fileReader.close();
            csvParser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Guardado correctamente en bbdd";
    }

    public String crearCSV() {
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(home+"/Downloads/" + nombre + "Ordenado.csv"));
            Connection connection = DriverManager.getConnection(URL);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);
            csvWriter.writeAll(resultSet, true);
            csvWriter.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Archivo exportado correctamente";

    }

}
