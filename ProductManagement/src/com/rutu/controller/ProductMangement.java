package com.rutu.controller;

import com.rutu.model.Product;

public class ProductMangement {
    private Product[] products;
    private int count;

    public ProductMangement(int size) {
        products = new Product[size];
        count = 0;
    }

    public boolean addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            return true;
        }
        return false;
    }

    public boolean updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_id() == id) {
                products[i] = updatedProduct;
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_id() == id) {
                products[i] = products[count - 1];
                products[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public Product[] getAllProducts() {
        Product[] result = new Product[count];
        System.arraycopy(products, 0, result, 0, count);
        return result;
    }

    public Product[] findProductsByName(String name) {
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_name().equalsIgnoreCase(name)) {
                result[index++] = products[i];
            }
        }
        return trimArray(result, index);
    }

    public Product[] filterProductsByPrice(double price, boolean lessThan) {
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if ((lessThan && products[i].getProduct_prize() < price)
                    || (!lessThan && products[i].getProduct_prize() > price)) {
                result[index++] = products[i];
            }
        }
        return trimArray(result, index);
    }

    public Product[] findProductsByType(String type) {
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_type().equalsIgnoreCase(type)) {
                result[index++] = products[i];
            }
        }
        return trimArray(result, index);
    }

    public Product findProductById(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_id() == id) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] filterProductsByQty(int qty) {
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_Qty() < qty) {
                result[index++] = products[i];
            }
        }
        return trimArray(result, index);
    }

    public Product[] searchProductsByPriceRange(double minPrice, double maxPrice) {
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (products[i].getProduct_prize() >= minPrice && products[i].getProduct_prize() <= maxPrice) {
                result[index++] = products[i];
            }
        }
        return trimArray(result, index);
    }

    public Product[] sortProductsByPrice(boolean ascending) {
        Product[] result = getAllProducts();
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (ascending ? result[i].getProduct_prize() > result[j].getProduct_prize() 
                        : result[i].getProduct_prize() < result[j].getProduct_prize()) {
                    Product temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }

    public int getProductCount() {
        return count;
    }

    private Product[] trimArray(Product[] array, int size) {
        Product[] result = new Product[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }
}
