package com.switchone.payment.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = Visibility.NONE
    , getterVisibility = Visibility.NONE
    , isGetterVisibility = Visibility.NONE)
@JsonInclude
public abstract class AbstractEntity<K extends Serializable> implements Serializable {
  private static final long serialVersionUID = -8494127021211076111L;

  public abstract String toString();

  public abstract K getId();
}
