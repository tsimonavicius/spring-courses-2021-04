package lt.codeacadamy.shop.api;

/**
 * @author Andrius Baltrunas
 */
public interface Endpoint {
    //PATH VARIABLE
    String UUID = "UUID";
    String NAME = "name";


    String API_ROOT = "/eshop/api";
    String PRODUCTS = "/products";
    String PRODUCT = "/{" + UUID + "}";
    String PRODUCT_BY_NAME = "/{" + NAME + "}/name";
    String SEARCH = "/search";


}
