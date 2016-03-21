package products.entity;

import java.util.List;

public class CatalogueList implements Entity{

    private List<LocationBasedCatalogues> catalogues;

    public CatalogueList() {
    }

    public List<LocationBasedCatalogues> getCatalogues() {
        return catalogues;
    }

    public void setCatalogues(List<LocationBasedCatalogues> catalogues) {
        this.catalogues = catalogues;
    }
}
