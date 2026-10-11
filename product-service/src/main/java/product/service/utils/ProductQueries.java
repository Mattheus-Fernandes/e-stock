package product.service.utils;

public class ProductQueries {

    //Insert a new product SQL NATIVE
    public static final String INSERT_PRODUCT_NAME = "Product.insertNewProduct";
    public static final String INSERT_PRODUCT_QUERY =
            """
            INSERT INTO products (
                id, name, brand, created_at
            )
            VALUES(
                :id, :name, :brand, :created_at
            );
            """;

    //Find a product by name SQL NATIVE
    public static final String EXISTS_PRODUCT_BY_NAME_NAME = "Product.existsProduct";
    public static final String EXISTS_PRODUCT_BY_NAME_QUERY = """
            SELECT EXISTS(
                SELECT 1 FROM products
                WHERE name ILIKE :name AND brand ILIKE :brand
            )
            """;
}
