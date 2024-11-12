package com.cardap.io.models;

public enum OrderPaymentMethod {
  CASH("Cash"),
  CREDIT_CARD("Credit Card"),
  DEBIT_CARD("Debit Card"),
  PIX("Pix");

  private final String value;

  OrderPaymentMethod(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
