package springbootapp.models;

import lombok.Data;

@Data
public class AttributeValueKeys {
    private Integer attributeId;
    private String attributeName;
    private Integer attributeValueId;
    private String attributeValueName;

    public AttributeValueKeys(Integer attributeId, String attributeName, Integer attributeValueId, String attributeValueName) {
        this.attributeId = attributeId;
        this.attributeName = attributeName;
        this.attributeValueId = attributeValueId;
        this.attributeValueName = attributeValueName;
    }
}
