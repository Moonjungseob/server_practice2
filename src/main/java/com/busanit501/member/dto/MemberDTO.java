package com.busanit501.member.dto;

import java.time.LocalDate;

public class MemberDTO {
  // 인스턴스 멤버.
  private Long meNo;
  private String meName;
  private LocalDate Date;

  public Long getMeNo() {
    return meNo;
  }

  public void setMeNo(Long meNo) {
    this.meNo = meNo;
  }

  public String getMeName() {
    return meName;
  }

  public void setMeName(String meName) {
    this.meName = meName;
  }

  public LocalDate getDate() {
    return Date;
  }

  public void setDate(LocalDate date) {
    Date = date;


  }

  @Override
  public String toString() {
    return "MemberDTO{" +
            "meNo=" + meNo +
            ", meName='" + meName + '\'' +
            ", Date=" + Date +
            '}';
  }
}








