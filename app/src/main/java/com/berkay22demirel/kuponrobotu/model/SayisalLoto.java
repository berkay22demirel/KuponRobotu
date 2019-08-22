package com.berkay22demirel.kuponrobotu.model;

import com.berkay22demirel.kuponrobotu.enums.Status;
import com.berkay22demirel.kuponrobotu.utils.CollectionUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class SayisalLoto extends Game {

    private static final int MAX_COLON_NUMBER = 8;
    private static final int MAX_VALUE_NUMBER = 6;
    private static final int MAX_VALUE_SIZE = 49;

    public SayisalLoto(String name, BigDecimal deposit) {
        SayisalLoto sayisalLoto = new SayisalLoto();
        sayisalLoto.setName(name);
        sayisalLoto.setCreateDate(new Date());
        sayisalLoto.setStatus(Status.PENDING);
        sayisalLoto.setDeposit(deposit);
        sayisalLoto.setColonList(new ArrayList<Colon>());
    }

    private SayisalLoto() {

    }

    @Override
    public void addColon(Colon colon) throws Exception {
        if (colon != null && getColonList().size() < MAX_COLON_NUMBER) {
            getColonList().add(colon);
        } else {
            throw new Exception("Kolon eklenirken beklenmeyen bir hata oluştu!");
        }
    }

    @Override
    public void createColon(PlayedValue[] values) throws Exception {
        if (CollectionUtil.isNotEmpty(values) && values.length <= MAX_VALUE_NUMBER) {
            Colon colon = new Colon();
            for (PlayedValue playedValue : values) {
                if (controlValueSize(playedValue.getSelectedValue(), MAX_VALUE_SIZE)) {
                    continue;
                } else {
                    throw new Exception("Kolona eklenen değer hatalı!");
                }
            }
            colon.setPlayedValueList(Arrays.asList(values));
        } else {
            throw new Exception("Kolon oluşturulurken beklenmeyen bir hata oluştu!");
        }
    }
}
