package com.sjsq.pojo;

import java.io.Serializable;

public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    private String carnumber;
    private String cartype;
    private String color;
    private Double rentprice;
    private Double deposit;
    private String isrenting;
    private String cardesc;
    private String carimg;
    private Integer seat;

    public Cars() {
        super();
    }

    public Cars(String carnumber, String cartype, String color, Double rentprice, Double deposit, String isrenting,
                String cardesc, String carimg, Integer seat) {
        super();
        this.carnumber = carnumber;
        this.cartype = cartype;
        this.color = color;
        this.rentprice = rentprice;
        this.deposit = deposit;
        this.isrenting = isrenting;
        this.cardesc = cardesc;
        this.carimg = carimg;
        this.seat = seat;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRentprice() {
        return rentprice;
    }

    public void setRentprice(Double rentprice) {
        this.rentprice = rentprice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(String isrenting) {
        this.isrenting = isrenting;
    }

    public String getCardesc() {
        return cardesc;
    }

    public void setCardesc(String cardesc) {
        this.cardesc = cardesc;
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardesc == null) ? 0 : cardesc.hashCode());
        result = prime * result + ((carimg == null) ? 0 : carimg.hashCode());
        result = prime * result + ((carnumber == null) ? 0 : carnumber.hashCode());
        result = prime * result + ((cartype == null) ? 0 : cartype.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
        result = prime * result + ((isrenting == null) ? 0 : isrenting.hashCode());
        result = prime * result + ((rentprice == null) ? 0 : rentprice.hashCode());
        result = prime * result + ((seat == null) ? 0 : seat.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cars other = (Cars) obj;
        if (cardesc == null) {
            if (other.cardesc != null)
                return false;
        } else if (!cardesc.equals(other.cardesc))
            return false;
        if (carimg == null) {
            if (other.carimg != null)
                return false;
        } else if (!carimg.equals(other.carimg))
            return false;
        if (carnumber == null) {
            if (other.carnumber != null)
                return false;
        } else if (!carnumber.equals(other.carnumber))
            return false;
        if (cartype == null) {
            if (other.cartype != null)
                return false;
        } else if (!cartype.equals(other.cartype))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (deposit == null) {
            if (other.deposit != null)
                return false;
        } else if (!deposit.equals(other.deposit))
            return false;
        if (isrenting == null) {
            if (other.isrenting != null)
                return false;
        } else if (!isrenting.equals(other.isrenting))
            return false;
        if (rentprice == null) {
            if (other.rentprice != null)
                return false;
        } else if (!rentprice.equals(other.rentprice))
            return false;
        if (seat == null) {
            if (other.seat != null)
                return false;
        } else if (!seat.equals(other.seat))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cars [carnumber=" + carnumber + ", cartype=" + cartype + ", color=" + color + ", rentprice=" + rentprice
                + ", deposit=" + deposit + ", isrenting=" + isrenting + ", cardesc=" + cardesc + ", carimg=" + carimg
                + ", seat=" + seat + "]";
    }


}
