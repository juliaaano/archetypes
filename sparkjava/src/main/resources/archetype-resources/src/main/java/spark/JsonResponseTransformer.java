package ${package}.spark;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonResponseTransformer implements ResponseTransformer {

    private static final Gson gson = new Gson();

    @Override
    public String render(final Object model) {

        return gson.toJson(model);
    }
}
