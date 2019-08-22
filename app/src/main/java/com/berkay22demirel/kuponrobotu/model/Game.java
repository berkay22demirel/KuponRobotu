package com.berkay22demirel.kuponrobotu.model;

import com.berkay22demirel.kuponrobotu.enums.Status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Game {

    private Integer id;
    private String name;
    private Date createDate;
    private BigDecimal deposit;
    private BigDecimal winnedAmount;
    private Status status;
    private List<Colon> colonList;

    public void Game() {
        colonList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWinnedAmount() {
        return winnedAmount;
    }

    public void setWinnedAmount(BigDecimal winnedAmount) {
        this.winnedAmount = winnedAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    protected List<Colon> getColonList() {
        return colonList;
    }

    protected void setColonList(List<Colon> colonList) {
        this.colonList = colonList;
    }

    protected boolean controlValueSize(Integer value, Integer maxValueSize) {
        if (value.compareTo(0) > 0 && value.compareTo(maxValueSize) <= 0) {
            return true;
        }
        return false;
    }

    public abstract void addColon(Colon colon) throws Exception;

    public abstract void createColon(PlayedValue[] values) throws Exception;
}
