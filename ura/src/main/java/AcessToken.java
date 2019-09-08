import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class AcessToken {

    private String acessToken;

    private Map<String, Object> fields = new HashMap<>();

    public AcessToken() {
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    @JsonAnySetter
    public void setOtherField(String name, Object value) {
        fields.put(name, value);
    }

    @Override
    public String toString() {
        return acessToken;
    }
}
