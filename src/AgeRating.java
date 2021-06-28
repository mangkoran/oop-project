public enum AgeRating {
    G("General Audience"), PG("Parental Guidance"), R("Restricted");

    private String description;

    private AgeRating(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
