//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.03 at 10:20:29 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conversionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conversionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="album" type="{}strAlbum"/>
 *         &lt;element name="nazwisko" type="{}string64"/>
 *         &lt;element name="imie" type="{}string64"/>
 *         &lt;element name="sygnaly_zrodlowe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sygnaly_analogowe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="sygnaly_cyfrowe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversionInfo", propOrder = {
    "album",
    "nazwisko",
    "imie",
    "sygnalyZrodlowe"
})
public class ConversionInfo {

    @XmlElement(required = true)
    protected String album;
    @XmlElement(required = true)
    protected String nazwisko;
    @XmlElement(required = true)
    protected String imie;
    @XmlElement(name = "sygnaly_zrodlowe", required = true)
    protected ConversionInfo.SygnalyZrodlowe sygnalyZrodlowe;

    /**
     * Gets the value of the album property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Sets the value of the album property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlbum(String value) {
        this.album = value;
    }

    /**
     * Gets the value of the nazwisko property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets the value of the nazwisko property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwisko(String value) {
        this.nazwisko = value;
    }

    /**
     * Gets the value of the imie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets the value of the imie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImie(String value) {
        this.imie = value;
    }

    /**
     * Gets the value of the sygnalyZrodlowe property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionInfo.SygnalyZrodlowe }
     *     
     */
    public ConversionInfo.SygnalyZrodlowe getSygnalyZrodlowe() {
        return sygnalyZrodlowe;
    }

    /**
     * Sets the value of the sygnalyZrodlowe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionInfo.SygnalyZrodlowe }
     *     
     */
    public void setSygnalyZrodlowe(ConversionInfo.SygnalyZrodlowe value) {
        this.sygnalyZrodlowe = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="sygnaly_analogowe">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="sygnaly_cyfrowe">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sygnalyAnalogowe",
        "sygnalyCyfrowe"
    })
    public static class SygnalyZrodlowe {

        @XmlElement(name = "sygnaly_analogowe", required = true)
        protected ConversionInfo.SygnalyZrodlowe.SygnalyAnalogowe sygnalyAnalogowe;
        @XmlElement(name = "sygnaly_cyfrowe", required = true)
        protected ConversionInfo.SygnalyZrodlowe.SygnalyCyfrowe sygnalyCyfrowe;

        /**
         * Gets the value of the sygnalyAnalogowe property.
         * 
         * @return
         *     possible object is
         *     {@link ConversionInfo.SygnalyZrodlowe.SygnalyAnalogowe }
         *     
         */
        public ConversionInfo.SygnalyZrodlowe.SygnalyAnalogowe getSygnalyAnalogowe() {
            return sygnalyAnalogowe;
        }

        /**
         * Sets the value of the sygnalyAnalogowe property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConversionInfo.SygnalyZrodlowe.SygnalyAnalogowe }
         *     
         */
        public void setSygnalyAnalogowe(ConversionInfo.SygnalyZrodlowe.SygnalyAnalogowe value) {
            this.sygnalyAnalogowe = value;
        }

        /**
         * Gets the value of the sygnalyCyfrowe property.
         * 
         * @return
         *     possible object is
         *     {@link ConversionInfo.SygnalyZrodlowe.SygnalyCyfrowe }
         *     
         */
        public ConversionInfo.SygnalyZrodlowe.SygnalyCyfrowe getSygnalyCyfrowe() {
            return sygnalyCyfrowe;
        }

        /**
         * Sets the value of the sygnalyCyfrowe property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConversionInfo.SygnalyZrodlowe.SygnalyCyfrowe }
         *     
         */
        public void setSygnalyCyfrowe(ConversionInfo.SygnalyZrodlowe.SygnalyCyfrowe value) {
            this.sygnalyCyfrowe = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sygnal"
        })
        public static class SygnalyAnalogowe {

            @XmlElement(required = true)
            protected List<SygnalNr> sygnal;

            /**
             * Gets the value of the sygnal property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sygnal property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSygnal().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SygnalNr }
             * 
             * 
             */
            public List<SygnalNr> getSygnal() {
                if (sygnal == null) {
                    sygnal = new ArrayList<SygnalNr>();
                }
                return this.sygnal;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="sygnal" type="{}sygnal_nr" maxOccurs="3" minOccurs="3"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sygnal"
        })
        public static class SygnalyCyfrowe {

            @XmlElement(required = true)
            protected List<SygnalNr> sygnal;

            /**
             * Gets the value of the sygnal property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sygnal property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSygnal().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SygnalNr }
             * 
             * 
             */
            public List<SygnalNr> getSygnal() {
                if (sygnal == null) {
                    sygnal = new ArrayList<SygnalNr>();
                }
                return this.sygnal;
            }

        }

    }

}
