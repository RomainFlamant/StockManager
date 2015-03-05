package model;
// Generated 5 mars 2015 20:30:42 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orderproduct generated by hbm2java
 */
@Entity
@Table(name="orderproduct"
    ,catalog="stockmanager2"
)
public class Orderproduct extends Metier implements java.io.Serializable {


     private Long ordPId;
     private Orders orders;
     private Product product;
     private Long quantityOrder;

    public Orderproduct() {
    }

    public Orderproduct(Orders orders, Product product,Long quantityOrder) {
       this.orders = orders;
       this.product = product;
       this.quantityOrder = quantityOrder;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="OrdP_id", unique=true, nullable=false)
    public Long getOrdPId() {
        return this.ordPId;
    }
    
    public void setOrdPId(Long ordPId) {
        this.ordPId = ordPId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NumOrder", nullable=false)
    public Orders getOrders() {
        return this.orders;
    }
    
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    
    @Column(name="QuantityOrder")
    public Long getQuantityOrder() {
        return this.quantityOrder;
    }
    
    public void setQuantityOrder(Long quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdProduct", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }




}


