package com.sjsq.pojo;

public class Customers {

    private String identity;
    private String custname;
    private String sex;
    private String address;
    private String phone;
    private String career;
    private String custpwd;

    public Customers() {
        super();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCustpwd() {
        return custpwd;
    }

    public void setCustpwd(String custpwd) {
        this.custpwd = custpwd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((career == null) ? 0 : career.hashCode());
        result = prime * result + ((custname == null) ? 0 : custname.hashCode());
        result = prime * result + ((custpwd == null) ? 0 : custpwd.hashCode());
        result = prime * result + ((identity == null) ? 0 : identity.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
        Customers other = (Customers) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (career == null) {
            if (other.career != null)
                return false;
        } else if (!career.equals(other.career))
            return false;
        if (custname == null) {
            if (other.custname != null)
                return false;
        } else if (!custname.equals(other.custname))
            return false;
        if (custpwd == null) {
            if (other.custpwd != null)
                return false;
        } else if (!custpwd.equals(other.custpwd))
            return false;
        if (identity == null) {
            if (other.identity != null)
                return false;
        } else if (!identity.equals(other.identity))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Car [identity=" + identity + ", custname=" + custname + ", sex=" + sex + ", address=" + address
                + ", phone=" + phone + ", career=" + career + ", custpwd=" + custpwd + "]";
    }
}
