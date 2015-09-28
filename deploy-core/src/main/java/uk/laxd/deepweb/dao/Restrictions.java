package uk.laxd.deepweb.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 27/09/2015.
 */
public class Restrictions {
    private List<Criteria> criterias;

    public Restrictions() {
        this.criterias = new ArrayList<Criteria>();
    }

    public Restrictions equals(String key, Object value) {
        criterias.add(new Criteria(Symbol.EQUALS, key, value));
        return this;
    }

    public Restrictions add(String key, Symbol symbol, Object value) {
        criterias.add(new Criteria(symbol, key, value));
        return this;
    }

    public Object[] getArguments() {
        Object[] output = new Object[criterias.size()];

        for(int i=0; i<criterias.size(); i++) {
            output[i] = criterias.get(i).getValue();
        }

        return output;
    }

    public String getWhereClauses() {
        StringBuilder sb = new StringBuilder();
        String separator = " WHERE ";

        for(Criteria criteria : criterias) {
            sb.append(separator).append(criteria.getKey()).append(criteria.getSymbol().getSqlSymbol()).append(" ?");
            separator = " AND ";
        }

        return sb.toString();
    }
}
