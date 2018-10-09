package com.techtrip.example.dozer.controllers;

import java.io.Serializable;
import java.util.Objects;

public class WidgetResponse implements Serializable {

    private static final long serialVersionUID = 2972387458637977680L;

    private final String sourceClass;
    private final String name;
    private final String id;
    private final String date;

    public WidgetResponse(String sourceClass, String name, String id, String date) {
        this.sourceClass = sourceClass;
        this.name = name;
        this.id = id;
        this.date = date;
    }

    private WidgetResponse(Builder builder) {
        sourceClass = builder.sourceClass;
        name = builder.name;
        id = builder.id;
        date = builder.date;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(WidgetResponse copy) {
        Builder builder = new Builder();
        builder.sourceClass = copy.getSourceClass();
        builder.name = copy.getName();
        builder.id = copy.getId();
        builder.date = copy.getDate();
        return builder;
    }

    public String getSourceClass() {
        return sourceClass;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WidgetResponse that = (WidgetResponse) o;
        return Objects.equals(sourceClass, that.sourceClass) &&
                Objects.equals(name, that.name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceClass, name, id, date);
    }

    @Override
    public String toString() {
        return "WidgetResponse{" +
                "sourceClass='" + sourceClass + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public static final class Builder {
        private String sourceClass;
        private String name;
        private String id;
        private String date;

        private Builder() {
        }

        public Builder withSourceClass(String val) {
            sourceClass = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withDate(String val) {
            date = val;
            return this;
        }

        public WidgetResponse build() {
            return new WidgetResponse(this);
        }
    }
}
