package com.training.uploadfileservice.Helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class Helper {

    public Supplier<Stream<Row>> getRowStreamSupplier(Iterable<Row> rows){

        return () -> getStream(rows);
    }

    public <T> Stream<T> getStream(Iterable<T> iterable){
        return StreamSupport.stream(iterable.spliterator(),false);
    }

//    public Stream<Row> getRowStream(Iterable<Row> rows){
//        return StreamSupport.stream(rows.spliterator(),false);
//    }
//
//    public Stream<Cell> getCellStream(Iterable<Cell> cells){
//        return StreamSupport.stream(cells.spliterator(),false);
//    }
}
