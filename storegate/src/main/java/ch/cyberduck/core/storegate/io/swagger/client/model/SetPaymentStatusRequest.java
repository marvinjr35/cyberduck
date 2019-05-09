/*
 * Storegate.Web
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.storegate.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T17:31:35.366+02:00")
public class SetPaymentStatusRequest {
  @JsonProperty("transactionId")
  private String transactionId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("orderRef")
  private String orderRef = null;

  public SetPaymentStatusRequest transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * 
   * @return transactionId
  **/
  @ApiModelProperty(value = "")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public SetPaymentStatusRequest status(String status) {
    this.status = status;
    return this;
  }

   /**
   * 
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SetPaymentStatusRequest orderRef(String orderRef) {
    this.orderRef = orderRef;
    return this;
  }

   /**
   * 
   * @return orderRef
  **/
  @ApiModelProperty(value = "")
  public String getOrderRef() {
    return orderRef;
  }

  public void setOrderRef(String orderRef) {
    this.orderRef = orderRef;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetPaymentStatusRequest setPaymentStatusRequest = (SetPaymentStatusRequest) o;
    return Objects.equals(this.transactionId, setPaymentStatusRequest.transactionId) &&
        Objects.equals(this.status, setPaymentStatusRequest.status) &&
        Objects.equals(this.orderRef, setPaymentStatusRequest.orderRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, status, orderRef);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetPaymentStatusRequest {\n");
    
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orderRef: ").append(toIndentedString(orderRef)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

