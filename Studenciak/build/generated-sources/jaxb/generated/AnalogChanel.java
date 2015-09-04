//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.04 at 06:40:58 PM CEST 
//


package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for analogChanel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="analogChanel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Chanel_number" type="{}counter"/>
 *         &lt;element name="Chanel_name" type="{}string64"/>
 *         &lt;element name="Phase_ID" type="{}phaseID"/>
 *         &lt;element name="Monitored_component" type="{}string64e"/>
 *         &lt;element name="Unit" type="{}units"/>
 *         &lt;element name="Multiplicity" type="{}string32"/>
 *         &lt;element name="Offset" type="{}float32e"/>
 *         &lt;element name="Time_skew" type="{}float32e"/>
 *         &lt;element name="Min_value" type="{}float32"/>
 *         &lt;element name="Max_value" type="{}float32"/>
 *         &lt;element name="Primary_ratio" type="{}float32Positive"/>
 *         &lt;element name="Secondary_ratio" type="{}float32Positive"/>
 *         &lt;element name="Scaling" type="{}winding"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analogChanel", propOrder = {
    "chanelNumber",
    "chanelName",
    "phaseID",
    "monitoredComponent",
    "unit",
    "multiplicity",
    "offset",
    "timeSkew",
    "minValue",
    "maxValue",
    "primaryRatio",
    "secondaryRatio",
    "scaling"
})
public class AnalogChanel {

    @XmlElement(name = "Chanel_number")
    protected int chanelNumber;
    @XmlElement(name = "Chanel_name", required = true)
    protected String chanelName;
    @XmlElement(name = "Phase_ID", required = true)
    protected String phaseID;
    @XmlElement(name = "Monitored_component", required = true)
    protected String monitoredComponent;
    @XmlElement(name = "Unit", required = true)
    protected String unit;
    @XmlElement(name = "Multiplicity", required = true)
    protected String multiplicity;
    @XmlElement(name = "Offset", required = true)
    protected String offset;
    @XmlElement(name = "Time_skew", required = true)
    protected String timeSkew;
    @XmlElement(name = "Min_value", required = true)
    protected String minValue;
    @XmlElement(name = "Max_value", required = true)
    protected String maxValue;
    @XmlElement(name = "Primary_ratio", required = true)
    protected String primaryRatio;
    @XmlElement(name = "Secondary_ratio", required = true)
    protected String secondaryRatio;
    @XmlElement(name = "Scaling", required = true)
    protected String scaling;
    @XmlAttribute(name = "nr", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger nr;

    /**
     * Gets the value of the chanelNumber property.
     * 
     */
    public int getChanelNumber() {
        return chanelNumber;
    }

    /**
     * Sets the value of the chanelNumber property.
     * 
     */
    public void setChanelNumber(int value) {
        this.chanelNumber = value;
    }

    /**
     * Gets the value of the chanelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChanelName() {
        return chanelName;
    }

    /**
     * Sets the value of the chanelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChanelName(String value) {
        this.chanelName = value;
    }

    /**
     * Gets the value of the phaseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhaseID() {
        return phaseID;
    }

    /**
     * Sets the value of the phaseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhaseID(String value) {
        this.phaseID = value;
    }

    /**
     * Gets the value of the monitoredComponent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonitoredComponent() {
        return monitoredComponent;
    }

    /**
     * Sets the value of the monitoredComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonitoredComponent(String value) {
        this.monitoredComponent = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the multiplicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultiplicity() {
        return multiplicity;
    }

    /**
     * Sets the value of the multiplicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultiplicity(String value) {
        this.multiplicity = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffset(String value) {
        this.offset = value;
    }

    /**
     * Gets the value of the timeSkew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeSkew() {
        return timeSkew;
    }

    /**
     * Sets the value of the timeSkew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeSkew(String value) {
        this.timeSkew = value;
    }

    /**
     * Gets the value of the minValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinValue(String value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the maxValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxValue(String value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the primaryRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryRatio() {
        return primaryRatio;
    }

    /**
     * Sets the value of the primaryRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryRatio(String value) {
        this.primaryRatio = value;
    }

    /**
     * Gets the value of the secondaryRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryRatio() {
        return secondaryRatio;
    }

    /**
     * Sets the value of the secondaryRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryRatio(String value) {
        this.secondaryRatio = value;
    }

    /**
     * Gets the value of the scaling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScaling() {
        return scaling;
    }

    /**
     * Sets the value of the scaling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScaling(String value) {
        this.scaling = value;
    }

    /**
     * Gets the value of the nr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNr() {
        return nr;
    }

    /**
     * Sets the value of the nr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNr(BigInteger value) {
        this.nr = value;
    }

}
