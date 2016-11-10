package com.psmodel.perscription;

import com.psmodel.product.Drug;
import java.util.ArrayList;

public interface IPrescription {
        public String getCustomerName();
        public String getGPName();
        public String getItems();
        public int getPrescriptionID();    
}

