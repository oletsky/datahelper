package mathcomp.oletsky.datareader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    public class CSVReader {
        private String fName;
        private String delimiter;

        public CSVReader(String fName, String delimiter) {
            this.fName = fName;
            this.delimiter = delimiter;
        }

        public ArrayList<ArrayList<String>> simpleReadFromCSV() {
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            try(BufferedReader br =new BufferedReader(
                    new FileReader(this.fName)

            )) {
                String line = null;

                while ((line = br.readLine()) != null) {
                    String[] arr=line.split(this.delimiter);
                    ArrayList<String> sarr = new ArrayList<>();
                    for (String s:arr) {
                        sarr.add(s);
                    }
                    list.add(sarr);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }


    }