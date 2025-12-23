
package com.recette.client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recette complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recette"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idRecette" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomRecette" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recette", propOrder = {
    "idRecette",
    "nomRecette",
    "description"
})
public class Recette {

    protected int idRecette;
    protected String nomRecette;
    protected String description;

    /**
     * Gets the value of the idRecette property.
     * 
     */
    public int getIdRecette() {
        return idRecette;
    }

    /**
     * Sets the value of the idRecette property.
     * 
     */
    public void setIdRecette(int value) {
        this.idRecette = value;
    }

    /**
     * Gets the value of the nomRecette property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomRecette() {
        return nomRecette;
    }

    /**
     * Sets the value of the nomRecette property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomRecette(String value) {
        this.nomRecette = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
