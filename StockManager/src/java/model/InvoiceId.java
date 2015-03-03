package model;
// Generated 3 mars 2015 09:18:13 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoiceId generated by hbm2java
 */
@Embeddable
public class InvoiceId extends Metier implements java.io.Serializable {


     private long idSupplier;
     private long idProduct;

    public InvoiceId() {
    }

    public InvoiceId(long idSupplier, long idProduct) {
       this.idSupplier = idSupplier;
       this.idProduct = idProduct;
    }
   


    @Column(name="IdSupplier", nullable=false)
    public long getIdSupplier() {
        return this.idSupplier;
    }
    
    public void setIdSupplier(long idSupplier) {
        this.idSupplier = idSupplier;
    }


    @Column(name="IdProduct", nullable=false)
    public long getIdProduct() {
        return this.idProduct;
    }
    
    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoiceId) ) return false;
		 InvoiceId castOther = ( InvoiceId ) other; 
         
		 return (this.getIdSupplier()==castOther.getIdSupplier())
 && (this.getIdProduct()==castOther.getIdProduct());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdSupplier();
         result = 37 * result + (int) this.getIdProduct();
         return result;
   }   


}


