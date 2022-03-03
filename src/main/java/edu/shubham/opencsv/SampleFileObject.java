package edu.shubham.opencsv;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

public class SampleFileObject {
    @CsvBindByName(column="Short Code")
    private String shortCode;

    @CsvBindAndJoinByName(column = ".*", elementType = String.class, mapType = HashSetValuedHashMap.class, required = true)
    private MultiValuedMap<String,String> first;

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public MultiValuedMap<String, String> getFirst() {
        return first;
    }

    public void setFirst(MultiValuedMap<String, String> first) {
        this.first = first;
    }
}