package miu.edu.model_mapper_demo.service;

public enum Response {
    DELETED("Deleted"),
    SAVED("Saved"),
    UPDATED("Updated"),
    ERROR("Error");

    private final String val;

    Response(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
