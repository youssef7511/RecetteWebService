
package com.recette.client.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.recette.client.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChercherRecettesParIngredient_QNAME = new QName("http://ws.recette.com/", "chercherRecettesParIngredient");
    private final static QName _ChercherRecettesParIngredientResponse_QNAME = new QName("http://ws.recette.com/", "chercherRecettesParIngredientResponse");
    private final static QName _GetAllRecettes_QNAME = new QName("http://ws.recette.com/", "getAllRecettes");
    private final static QName _GetAllRecettesResponse_QNAME = new QName("http://ws.recette.com/", "getAllRecettesResponse");
    private final static QName _Hello_QNAME = new QName("http://ws.recette.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ws.recette.com/", "helloResponse");
    private final static QName _Recette_QNAME = new QName("http://ws.recette.com/", "recette");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.recette.client.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChercherRecettesParIngredient }
     * 
     */
    public ChercherRecettesParIngredient createChercherRecettesParIngredient() {
        return new ChercherRecettesParIngredient();
    }

    /**
     * Create an instance of {@link ChercherRecettesParIngredientResponse }
     * 
     */
    public ChercherRecettesParIngredientResponse createChercherRecettesParIngredientResponse() {
        return new ChercherRecettesParIngredientResponse();
    }

    /**
     * Create an instance of {@link GetAllRecettes }
     * 
     */
    public GetAllRecettes createGetAllRecettes() {
        return new GetAllRecettes();
    }

    /**
     * Create an instance of {@link GetAllRecettesResponse }
     * 
     */
    public GetAllRecettesResponse createGetAllRecettesResponse() {
        return new GetAllRecettesResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Recette }
     * 
     */
    public Recette createRecette() {
        return new Recette();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChercherRecettesParIngredient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChercherRecettesParIngredient }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "chercherRecettesParIngredient")
    public JAXBElement<ChercherRecettesParIngredient> createChercherRecettesParIngredient(ChercherRecettesParIngredient value) {
        return new JAXBElement<ChercherRecettesParIngredient>(_ChercherRecettesParIngredient_QNAME, ChercherRecettesParIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChercherRecettesParIngredientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChercherRecettesParIngredientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "chercherRecettesParIngredientResponse")
    public JAXBElement<ChercherRecettesParIngredientResponse> createChercherRecettesParIngredientResponse(ChercherRecettesParIngredientResponse value) {
        return new JAXBElement<ChercherRecettesParIngredientResponse>(_ChercherRecettesParIngredientResponse_QNAME, ChercherRecettesParIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRecettes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRecettes }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "getAllRecettes")
    public JAXBElement<GetAllRecettes> createGetAllRecettes(GetAllRecettes value) {
        return new JAXBElement<GetAllRecettes>(_GetAllRecettes_QNAME, GetAllRecettes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRecettesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRecettesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "getAllRecettesResponse")
    public JAXBElement<GetAllRecettesResponse> createGetAllRecettesResponse(GetAllRecettesResponse value) {
        return new JAXBElement<GetAllRecettesResponse>(_GetAllRecettesResponse_QNAME, GetAllRecettesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recette }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Recette }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.recette.com/", name = "recette")
    public JAXBElement<Recette> createRecette(Recette value) {
        return new JAXBElement<Recette>(_Recette_QNAME, Recette.class, null, value);
    }

}
