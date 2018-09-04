package com.ninemax.jpa.code.model;

import java.util.Date;

/**
 * User: zhhuiyan
 * Date: 12-7-18
 * Time: ÏÂÎç3:11
 */
public class Model {
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private Integer count1;
    private Integer count2;
    private Double rate1;
    private Double rate2;
    private Date fpsjDate;

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public Integer getCount1() {
        return count1;
    }

    public void setCount1(Integer count1) {
        this.count1 = count1;
    }

    public Integer getCount2() {
        return count2;
    }

    public void setCount2(Integer count2) {
        this.count2 = count2;
    }

    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

	public String getColumn6() {
		return column6;
	}

	public void setColumn6(String column6) {
		this.column6 = column6;
	}

	public Date getFpsjDate() {
		return fpsjDate;
	}

	public void setFpsjDate(Date fpsjDate) {
		this.fpsjDate = fpsjDate;
	}

	@Override
	public String toString() {
		return "Model [column1=" + column1 + ", column2=" + column2
				+ ", column3=" + column3 + ", column4=" + column4
				+ ", column5=" + column5 + ", column6=" + column6 + ", count1="
				+ count1 + ", count2=" + count2 + ", rate1=" + rate1
				+ ", rate2=" + rate2 + ", fpsjDate=" + fpsjDate + "]";
	}
    
	
}
