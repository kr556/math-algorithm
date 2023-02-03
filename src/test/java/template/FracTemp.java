package template;

import com.algorithm.math.Frac;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FracTemp {
    public List<Frac> get(int mode) {
        List<Frac> re = new ArrayList<>();
        JsonNode jn;
        try {
            jn = new ObjectMapper().readTree("");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
}
