package com.example.demo.bll.exception;

public class LaboException extends RuntimeException {

  private final int statut;
  private final Object message;

  public LaboException(String message) {
    super(message);
    this.statut = 500;
    this.message = message;
    }

  public LaboException(String message, int statut) {
    super(message);
    this.statut = statut;
    this.message = message;
  }

  public int getStatut() {
    return statut;
  }

  public String getMessage() {
    return message.toString();
  }

  @Override
  public String toString() {
    return "LaboException{" +
            "statut=" + statut +
            ", message=" + message +
            '}';
  }
}
