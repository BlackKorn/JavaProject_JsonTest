package com.test.model;

import java.util.List;

public class UserTotal {
	private int total; //��������  
    private List<Users> rows; //�����б�  
      
      
    public UserTotal() {  
    }  
    public UserTotal(int total, List<Users> rows) {  
        this.total = total;  
        this.rows = rows;  
    }  
    public int getTotal() {  
        return total;  
    }  
    public void setTotal(int total) {  
        this.total = total;  
    }  
    public List<Users> getRows() {  
        return rows;  
    }  
    public void setRows(List<Users> rows) {  
        this.rows = rows;  
    }  
      
}
