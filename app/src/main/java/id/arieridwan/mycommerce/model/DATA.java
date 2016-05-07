
package id.arieridwan.mycommerce.model;

import java.util.ArrayList;
import java.util.List;

public class DATA {

    private List<Filter> filter = new ArrayList<Filter>();
    private List<Product> products = new ArrayList<Product>();

    /**
     * 
     * @return
     *     The filter
     */
    public List<Filter> getFilter() {
        return filter;
    }

    /**
     * 
     * @param filter
     *     The filter
     */
    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }

    /**
     * 
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
