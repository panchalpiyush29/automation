package nz.co.automation.regression.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Query {
    private String query;

    @JsonCreator
    public Query(
            @JsonProperty("query") String query)
    {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Query query1 = (Query) o;

        return query != null ? query.equals(query1.query) : query1.query == null;
    }

    @Override
    public int hashCode() {
        return query != null ? query.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Query{");
        sb.append("query='").append(query).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
