package com.training.uploadfileservice.service;

import com.training.uploadfileservice.Helper.Helper;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{


    private final Helper helper;

    public ServiceImpl(Helper helper) {
        this.helper = helper;
    }

    @Override
    public void uploadfile(MultipartFile file) throws Exception{

        Path tempDir = Files.createTempDirectory("");
        File tempFile=tempDir.resolve(file.getOriginalFilename()).toFile();

        file.transferTo(tempFile);

        Workbook workbook=WorkbookFactory.create(tempFile);

        Sheet sheet = workbook.getSheetAt(0);

        Supplier<Stream<Row>> rowStreamSupplier= helper.getRowStreamSupplier(sheet);

        Row headerRow = rowStreamSupplier.get().findFirst().get();

        List<String> headerCells = StreamSupport.stream(headerRow.spliterator(),false)
                .map(Cell::getStringCellValue)
                .collect(Collectors.toList());

        System.out.println(headerCells);

        rowStreamSupplier.get().forEach(row->{
            Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);

            List<String> cellVals=cellStream.map(cell ->{
                String cellVal=cell.getStringCellValue();
                return cellVal;
            })
            .collect(Collectors.toList());

            System.out.println(cellVals);
        });


    }
}
