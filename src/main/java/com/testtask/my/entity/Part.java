package com.testtask.my.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "part")
public class Part implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUST_GEN")
    @Column(name = "id")
    private int id;

    @Column(name = "detail")
    private String detail;

    @Column(name = "need")
    private byte need;

    @Column(name = "amount")
    private int amount;

    public Part() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public byte getNeed() {
        return need;
    }

    public void setNeed(byte need) {
        this.need = need;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", need=" + need +
                ", amount=" + amount +
                '}';
    }
}
