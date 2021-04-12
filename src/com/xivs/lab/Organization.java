package com.xivs.lab;


import com.xivs.parameters.EnumParameter;
import com.xivs.parameters.numericalParameters.IntegerParameter;

import java.io.Serializable;

public class Organization implements Serializable {
    private Integer annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null
    public static final Organization DEFAULT = new Organization(1, OrganizationType.NONE, Address.DEFAULT);

    public static class Params {
        public static IntegerParameter annualTurnover = new IntegerParameter(1).setLowerBound(0);
        public static EnumParameter<OrganizationType> type = new EnumParameter<>(OrganizationType.class, OrganizationType.NONE);
    }

    public Organization(Integer annualTurnover, OrganizationType type, Address officialAddress) {
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    public Organization() {
    }

    public Integer getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Integer annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }


}
