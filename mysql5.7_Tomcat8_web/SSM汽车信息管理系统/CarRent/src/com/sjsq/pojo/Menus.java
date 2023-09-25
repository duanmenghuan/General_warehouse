package com.sjsq.pojo;

import java.io.Serializable;
import java.util.List;

public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double menuid;
    private String menuname;
    private String connurl;
    private Double fatherid;
    private List<Menus> menus;

    public Menus() {
        super();
    }

    public Double getMenuid() {
        return menuid;
    }

    public void setMenuid(Double menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getConnurl() {
        return connurl;
    }

    public void setConnurl(String connurl) {
        this.connurl = connurl;
    }

    public Double getFatherid() {
        return fatherid;
    }

    public void setFatherid(Double fatherid) {
        this.fatherid = fatherid;
    }

    public List<Menus> getMenus() {
        return menus;
    }

    public void setMenus(List<Menus> menus) {
        this.menus = menus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((connurl == null) ? 0 : connurl.hashCode());
        result = prime * result + ((fatherid == null) ? 0 : fatherid.hashCode());
        result = prime * result + ((menuid == null) ? 0 : menuid.hashCode());
        result = prime * result + ((menuname == null) ? 0 : menuname.hashCode());
        result = prime * result + ((menus == null) ? 0 : menus.hashCode());
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
        Menus other = (Menus) obj;
        if (connurl == null) {
            if (other.connurl != null)
                return false;
        } else if (!connurl.equals(other.connurl))
            return false;
        if (fatherid == null) {
            if (other.fatherid != null)
                return false;
        } else if (!fatherid.equals(other.fatherid))
            return false;
        if (menuid == null) {
            if (other.menuid != null)
                return false;
        } else if (!menuid.equals(other.menuid))
            return false;
        if (menuname == null) {
            if (other.menuname != null)
                return false;
        } else if (!menuname.equals(other.menuname))
            return false;
        if (menus == null) {
            if (other.menus != null)
                return false;
        } else if (!menus.equals(other.menus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Menus [menuid=" + menuid + ", menuname=" + menuname + ", connurl=" + connurl + ", fatherid=" + fatherid
                + ", menus=" + menus + "]";
    }
}
