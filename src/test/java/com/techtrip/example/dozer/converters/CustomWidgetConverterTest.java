package com.techtrip.example.dozer.converters;

import com.techtrip.example.dozer.model.NewFangledWidget;
import com.techtrip.example.dozer.model.OriginalWidget;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomWidgetConverterTest {

    private LocalDate testLocalDate;

    private OriginalWidget o;
    private NewFangledWidget n;

    private static final String NAME = "ORIGINAL";
    private static final int ID = 1;

    private static final String DATE_PATTERN = "d/MM/yyyy";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private static final SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(DATE_PATTERN);

    private static final String DATE_STR = "4/08/2018";

    //convert String to LocalDate
    private static final LocalDate expectedLocalDate = LocalDate.parse(DATE_STR, dateTimeFormatter);
    private static final Date expectedDate;

    static {
        try {
            expectedDate = simpleDateFormatter.parse(DATE_STR);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @Before
    public void setUp() throws Exception {

//        o = OriginalWidget.newBuilder()
//                .withCreationDate(testDate)
//                .withId(ID)
//                .withName(NAME)
//                .build();
    }

    @Test
    public void convertOriginalWidgetToNewFangledWidget() {

    }
//
//    @Test
//    public void convertOriginalWidgetToNewFangledWidget() {
//        NewFangledWidget newfangled = converter.convert(null, createOriginalWidget(), );
//    }
//
//    @Test
//    public void convertNewFangledWidgetToOriginalWidget() {
//        OriginalWidget original = converter.convert(createNewFangledWidget());
//
//    }
//
//    private OriginalWidget createOriginalWidget() {
//        return OriginalWidget.newBuilder()
//                .withCreationDate(testDate)
//                .withId(ID)
//                .withName(NAME)
//                .build();
//    }
//
//    private NewFangledWidget createNewFangledWidget() {
//        return NewFangledWidget.builder()
//                .originationDate(testLocalDate)
//                .identifier(ID)
//                .name(NAME)
//                .build();
//    }
}