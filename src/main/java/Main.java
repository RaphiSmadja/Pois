import exception.TsvException;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("You must pass a file as an args");
        }
    }

    public LinkedList<Poi> openFile(String[] args) throws Exception {
        String extension = FilenameUtils.getExtension(args[0]);
        LinkedList<Poi> map = new LinkedList<>();
        if (extension.equals("tsv")) {
            // Open File
            File file = new File(args[0]);
            BufferedReader reader;
            try {
                if (file.isFile()) {
                    reader = new BufferedReader(new FileReader(args[0]));
                    String line = reader.readLine();
                    while (line != null) {
                        if (line.charAt(0) != '@') {
                            String[] datas = line.split("\t");
                            Poi poi = new Poi(datas[0], datas[1], datas[2]);
                            map.push(poi);
                        }
                        line = reader.readLine();
                    }
                    reader.close();
                    return map;
                }
            } catch (Exception fileNotFoundException) {
                throw new Exception(fileNotFoundException);
            }
        } else {
            throw new TsvException("The format of file must be a 'tsv'");
        }
        return map;
    }

    int calculateNbPois(double minLat, double minLon, LinkedList<Poi> map) {
        int nbPois = 0;
        if (map.size() > 0) {
            for (Poi poi : map) {
                if (poi.getLat() > minLat && poi.getLon() > minLon) {
                    nbPois++;
                }
            }
        }
        return nbPois;
    }

    LinkedList<Poi> findNZonePois(int zone, LinkedList<Poi> map) {

        return map;
    }
}
