package com.maria.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Maria
 * @program homework04
 * @date 2020/4/13 15:45
 */
public class ShoppingCart {
    HashMap<Integer,GoodsItem> items = null;

    public ShoppingCart() {
        items = new HashMap<Integer,GoodsItem>();
    }

    /**
     * 添加商品
     * @param goodsItem
     */
    public void add(GoodsItem goodsItem) {
        int productid = goodsItem.getProduct().getId();
        if(items.containsKey(productid)) {
            GoodsItem scitem = (GoodsItem) items.get(productid);
            scitem.setQuantity(scitem.getQuantity()+goodsItem.getQuantity());
        } else {
            items.put(productid, goodsItem);
        }
    }

    /**
     * 删除商品
      * @param productid
     */
    public void remove(Integer productid) {
        if(items.containsKey(productid)) {
            GoodsItem scitem = (GoodsItem) items.get(productid);
            scitem.setQuantity(scitem.getQuantity()-1);
            if(scitem.getQuantity() <= 0)
                items.remove(productid);
        }
    }

    /**
     * 返回所有的商品
     * @return
     */
    public Collection<GoodsItem> getItems() {
        return items.values();
    }

    /**
     * 计算所有商品价格
     * @return
     */
    public double getTotal() {
        double amount = 0.0;
        for(Iterator<GoodsItem> i = getItems().iterator(); i.hasNext(); ) {
            GoodsItem item = (GoodsItem) i.next();
            Product product = (Product) item.getProduct();
            amount += item.getQuantity() * product.getPrice();
        }
        return roundOff(amount);
    }

    /**
     * 对数值进行四舍五入并保留两位小数
     * @param x
     * @return
     */
    private double roundOff(double x) {
        long val = Math.round(x*100); // cents
        return val/100.0;
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }
}
