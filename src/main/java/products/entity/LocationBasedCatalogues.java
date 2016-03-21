package products.entity;

public class LocationBasedCatalogues implements Entity{
    private String location;
    private Catalogue catalogue;

    public LocationBasedCatalogues() {
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
