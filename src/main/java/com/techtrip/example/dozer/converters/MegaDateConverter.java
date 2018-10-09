package com.techtrip.example.dozer.converters;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.dozer.MappingException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;


/**
 * Implements a MapperAware converter for converting between Date and LocalDate
 */
public class MegaDateConverter<T extends Temporal> extends DozerConverter<Date, T> implements MapperAware {

    private static final String ERROR_MSG = "MegaDateConverter error: Can only convert between a data and [LocalDate | LocalDateTime]";
    /**
     * mapper represents dozer bean mapper instance
     */
    private Mapper mapper;

    /** klassT is the constant type of the Target */
    Class<T> klassT;

    public MegaDateConverter(final Class<T> klassT) {
        super(Date.class, klassT);
        this.klassT = klassT;
    }

    @Override
    public T convertTo(Date date, T localDate) {

        switch (klassT.getSimpleName()) {
            case "LocalDate" :
                return (T) DateUtils.localDateFromDate(date);
            case "LocalDateTime" :
                return (T) DateUtils.localDateTimeFromDate(date);
            case "LocalTime" :
                return (T) DateUtils.localTimeFromDate(date);
            default:
                throw new MappingException(ERROR_MSG);
        }
    }

    @Override
    public Date convertFrom(T localDate, Date date) {
        switch (klassT.getSimpleName()) {
            case "LocalDate" :
                return DateUtils.dateFromLocalDate((LocalDate) localDate);
            case "LocalDateTime" :
                return DateUtils.dateFromLocalDateTime((LocalDateTime) localDate);
            case "LocalTime" :
                LocalTime source = (LocalTime) localDate;

                if (date == null) {
                    return DateUtils.dateFromLocalTime(source);
                } else {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    return DateUtils.dateFromLocalTime(source, year, month, day);
                }
            default:
                throw new MappingException(ERROR_MSG);
        }
    }

    @Override
    public void setMapper(Mapper mapper) {
        if (mapper == null) {
            throw new NullPointerException("Mapper cannot be null");
        }
        this.mapper = mapper;
    }

}
