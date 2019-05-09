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
 * Update a accounts settings. Properties that are null/undefined/missing are not updated
 */
@ApiModel(description = "Update a accounts settings. Properties that are null/undefined/missing are not updated")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T17:31:35.366+02:00")
public class UpdateConfiguration {
  @JsonProperty("hideSplash")
  private Boolean hideSplash = null;

  public UpdateConfiguration hideSplash(Boolean hideSplash) {
    this.hideSplash = hideSplash;
    return this;
  }

   /**
   * Hide the startup splash
   * @return hideSplash
  **/
  @ApiModelProperty(value = "Hide the startup splash")
  public Boolean isHideSplash() {
    return hideSplash;
  }

  public void setHideSplash(Boolean hideSplash) {
    this.hideSplash = hideSplash;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateConfiguration updateConfiguration = (UpdateConfiguration) o;
    return Objects.equals(this.hideSplash, updateConfiguration.hideSplash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hideSplash);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateConfiguration {\n");
    
    sb.append("    hideSplash: ").append(toIndentedString(hideSplash)).append("\n");
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

