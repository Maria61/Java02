package com.maria.model;

/**
 * @author Maria
 * @program homework04
 * @date 2020/4/13 15:44
 */
public class GoodsItem {
    private Product product;    // 商品信息
    private int quantity;       // 商品数量

    public GoodsItem(Product product) {
        this.product = product;
        quantity = 1;
    }
    public GoodsItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
