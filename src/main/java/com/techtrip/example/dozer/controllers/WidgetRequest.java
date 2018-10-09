package com.techtrip.example.dozer.controllers;

import java.util.Objects;

public class WidgetRequest {

    private String name;

    public WidgetRequest(String name) {
        this.name = name;
    }

    public WidgetRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WidgetRequest that = (WidgetRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
