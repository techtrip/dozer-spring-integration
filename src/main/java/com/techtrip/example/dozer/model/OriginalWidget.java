package com.techtrip.example.dozer.model;

import com.techtrip.example.dozer.config.AppDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OriginalWidget implements Serializable {

    private static final long serialVersionUID = -9115580884834990516L;
    
    private String name;
    private int    id;
    private Date   creationDate;

    public OriginalWidget() {
    }

    private OriginalWidget(Builder builder) {
        setName(builder.name);
        setId(builder.id);
        setCreationDate(builder.creationDate);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(OriginalWidget copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.id = copy.getId();
        builder.creationDate = copy.getCreationDate();
        return builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OriginalWidget)) return false;
        OriginalWidget that = (OriginalWidget) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, creationDate);
    }

    @Override
    public String toString() {
        return AppDefaults.TOP_DIVIDER + "OriginalWidget{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", creationDate=" + creationDate +
                '}' + AppDefaults.BOTTOM_DIVIDER;
    }


    public static final class Builder {
        private String name;
        private int id;
        private Date creationDate;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withCreationDate(Date val) {
            creationDate = val;
            return this;
        }

        public OriginalWidget build() {
            return new OriginalWidget(this);
        }
    }
}
