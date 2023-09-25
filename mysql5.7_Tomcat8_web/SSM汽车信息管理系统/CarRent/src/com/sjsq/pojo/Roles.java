package com.sjsq.pojo;

import java.io.Serializable;

public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double roleid;
    private String rolename;

    public Roles() {
        super();
    }

    public Double getRoleid() {
        return roleid;
    }

    public void setRoleid(Double roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
        result = prime * result + ((rolename == null) ? 0 : rolename.hashCode());
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
        Roles other = (Roles) obj;
        if (roleid == null) {
            if (other.roleid != null)
                return false;
        } else if (!roleid.equals(other.roleid))
            return false;
        if (rolename == null) {
            if (other.rolename != null)
                return false;
        } else if (!rolename.equals(other.rolename))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Roles [roleid=" + roleid + ", rolename=" + rolename + "]";
    }
}
