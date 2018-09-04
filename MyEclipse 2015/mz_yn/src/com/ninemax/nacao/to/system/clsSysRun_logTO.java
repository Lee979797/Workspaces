package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsSysRun_logTO implements Serializable
{
  private String operId;
  private String operdate;
  private String message;
  
  private static final long serialVersionUID = 100004l;
  public String getOperdate()
  {
    return this.operdate; }

  public void setOperdate(String operdate) {
    this.operdate = operdate;
  }

  public String getOperId() {
    return this.operId; }

  public void setOperId(String operId) {
    this.operId = operId; }

  public String getMessage() {
    return this.message; }

  public void SetMessage(String message) {
    this.message = message;
  }
}