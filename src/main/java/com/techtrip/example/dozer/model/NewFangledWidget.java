package com.techtrip.example.dozer.model;

import com.techtrip.example.dozer.config.AppDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class NewFangledWidget implements Serializable {

    private static final long serialVersionUID = -1838226448100456949L;

    private String name;
    private int     identifier;
    private LocalDateTime originationDate;

    public NewFangledWidget() {
    }

    private NewFangledWidget(Builder builder) {
        setName(builder.name);
        setIdentifier(builder.identifier);
        setOriginationDate(builder.originationDate);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(NewFangledWidget copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.identifier = copy.getIdentifier();
        builder.originationDate = copy.getOriginationDate();
        return builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getOriginationDate() {
        return originationDate;
    }

    public void setOriginationDate(LocalDateTime originationDate) {
        this.originationDate = originationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewFangledWidget)) return false;
        NewFangledWidget that = (NewFangledWidget) o;
        return identifier == that.identifier &&
                Objects.equals(name, that.name) &&
                Objects.equals(originationDate, that.originationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identifier, originationDate);
    }

    @Override
    public String toString() {
        return AppDefaults.TOP_DIVIDER + "NewFangledWidget{" +
                "name='" + name + '\'' +
                ", identifier=" + identifier +
                ", originationDate=" + originationDate +
                '}' + AppDefaults.BOTTOM_DIVIDER;
    }


    public static final class Builder {
        private String name;
        private int identifier;
        private LocalDateTime originationDate;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withIdentifier(int val) {
            identifier = val;
            return this;
        }

        public Builder withOriginationDate(LocalDateTime val) {
            originationDate = val;
            return this;
        }

        public NewFangledWidget build() {
            return new NewFangledWidget(this);
        }
    }
}
