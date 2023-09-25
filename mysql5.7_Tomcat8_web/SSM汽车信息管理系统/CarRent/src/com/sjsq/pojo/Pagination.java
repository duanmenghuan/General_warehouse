package com.sjsq.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * easyui分页实体类
 */
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //总记录数
    private Integer total;
    //查到的数据集合
    private List<T> rows;

    public Pagination() {
        super();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rows == null) ? 0 : rows.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        Pagination<?> other = (Pagination<?>) obj;
        if (rows == null) {
            if (other.rows != null)
                return false;
        } else if (!rows.equals(other.rows))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pagination [total=" + total + ", rows=" + rows + "]";
    }
}
