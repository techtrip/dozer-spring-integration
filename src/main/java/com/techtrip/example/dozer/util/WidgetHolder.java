package com.techtrip.example.dozer.util;

import com.techtrip.example.dozer.model.NewFangledWidget;
import com.techtrip.example.dozer.model.OriginalWidget;

import java.util.Objects;

public class WidgetHolder {

    private NewFangledWidget newfangled;
    private OriginalWidget original;

    public WidgetHolder() {
    }

    private WidgetHolder(Builder builder) {
        newfangled = builder.newfangled;
        original = builder.original;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(WidgetHolder copy) {
        Builder builder = new Builder();
        builder.newfangled = copy.getNewfangled();
        builder.original = copy.getOriginal();
        return builder;
    }

    public NewFangledWidget getNewfangled() {
        return newfangled;
    }

    public OriginalWidget getOriginal() {
        return original;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WidgetHolder that = (WidgetHolder) o;
        return Objects.equals(newfangled, that.newfangled) &&
                Objects.equals(original, that.original);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newfangled, original);
    }

    @Override
    public String toString() {
        return "WidgetHolder{" +
                "newfangled=" + newfangled +
                ", original=" + original +
                '}';
    }


    public static final class Builder {
        private NewFangledWidget newfangled;
        private OriginalWidget original;

        private Builder() {
        }

        public Builder withNewfangled(NewFangledWidget val) {
            newfangled = val;
            return this;
        }

        public Builder withOriginal(OriginalWidget val) {
            original = val;
            return this;
        }

        public WidgetHolder build() {
            return new WidgetHolder(this);
        }
    }
}
