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
    String FILE = "/file";
    String FILE_UPLOAD = FILE + "/upload";
    String FILE_BY_NAME = FILE + "/NAME/{" + NAME + "}";
    String FILE_BY_UUID = FILE + "/{" + UUID + "}";
    String FILE_BY_UUID_AS_BLOB = FILE + "/{" + UUID + "}/blob";
    String FILE_UPLOAD_AS_BLOB = FILE + "/upload/blob";

}
