package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class Spend implements Serializable{
    private int id;
    private String nameSpend;
    private int chiphi;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSpend() {
        return nameSpend;
    }

    public void setNameSpend(String nameSpend) {
        this.nameSpend = nameSpend;
    }

    public int getChiphi() {
        return chiphi;
    }

    public void setChiphi(int chiphi) {
        this.chiphi = chiphi;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Spend(int id, String nameSpend, int chiphi, LocalDate date) {
        this.id = id;
        this.nameSpend = nameSpend;
        this.chiphi = chiphi;
        this.date = date;
    }
    public Spend(){

    }



}
