package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class VersionIO {
    public static String SelectingVersion = "file not found";
    private final List<String> flName = new ArrayList<>();

    public VersionIO(File folderPath) {
        File[] fs = folderPath.listFiles();


        assert fs != null;
        for (File f : fs) {
            f = new File(f.toString().replace("..\\", ""));
            System.out.println(f); //del
            if (f.toString().startsWith(new JsonIO(new File("assets/io/io.json"))
                    .read("io/prefix").textValue())) {
                flName.add(f.toString());
            }
        }
    }

    public List<String> getFileName() {
        return flName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (VersionIO) obj;
        return Objects.equals(this.flName, that.flName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flName);
    }

    @Override
    public String toString() {
        return "VersionIO[" +
                "folderPath=" + flName + ']';
    }

}
