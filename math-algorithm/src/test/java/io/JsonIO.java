package io;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonIO {
    private File file;

    public JsonIO(File file) {
        this.file = file;
    }

    public JsonNode read(String tree) {
        ObjectMapper om = new ObjectMapper();
        JsonNode re;
        try {
            re = om.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] fi = tree.split("/");
        for (String s : fi) {
            if (s.equals("\\d")) {
                re = re.get(Integer.parseInt(s));
            } else {
                re = re.get(s);
            }
        }
        return re;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
