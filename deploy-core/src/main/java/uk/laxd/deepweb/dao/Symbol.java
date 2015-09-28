package uk.laxd.deepweb.dao;

/**
 * Created by Lenny on 27/09/2015.
 */
public enum Symbol {
    EQUALS("="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    LIKE("%"),
    NOT_EQUALS("!=");

    private String sqlSymbol;

    Symbol(String sqlSymbol) {
        this.sqlSymbol = sqlSymbol;
    }

    public String getSqlSymbol() {
        return sqlSymbol;
    }

    public void setSqlSymbol(String sqlSymbol) {
        this.sqlSymbol = sqlSymbol;
    }
}
