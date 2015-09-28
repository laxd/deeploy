package uk.laxd.deepweb.dao;

/**
 * Created by Lenny on 27/09/2015.
 */
public class Criteria {
    private Symbol symbol;
    private String key;
    private Object value;

    public Criteria(Symbol symbol, String key, Object value) {
        this.symbol = symbol;
        this.key = key;
        this.value = value;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
