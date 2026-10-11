package product.service.utils;

public class ProductQueries {

    //Insert a new product SQL NATIVE
    public static final String INSERT_PRODUCT_NAME = "Product.insertNewProduct";
    public static final String INSERT_PRODUCT_QUERY =
            """
            INSERT INTO (
                id, name, brand, created_at
            )
            VALUES(
                :id, :name, :brand, :created_at
            );
            """;
}
