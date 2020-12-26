package by.bsu.marchenko.service;

import by.bsu.marchenko.model.Product;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_NAME = "testdata.product.name";
    public static final String TESTDATA_PRODUCT_URL = "testdata.product.url";

    public static Product withNameAndUrlFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_PRODUCT_URL));
    }
}
