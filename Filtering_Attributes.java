import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

public class Filtering_Attributes {
    public static void main(String args[]) {
        try {
            ConverterUtils.DataSource src = new ConverterUtils.DataSource("Weather.arff");
            // DataSource src = new DataSource("weather.arff");

            Instances data = src.getDataSet();
            String[] options = new String[]{"-R", "2-4"};
            Remove remove = new Remove();
            remove.setOptions(options);
            remove.setInputFormat(data);
            Instances n_d = Filter.useFilter(data, remove);

            ArffSaver s = new ArffSaver();
            s.setInstances(n_d);
            s.setFile(new File("Output"));
            s.writeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Extra exception-handlers if needed

//            @Override
//            public <T> T unwrap(Class<T> iface) throws SQLException {
//                return null;
//            }
//            ^
//            public boolean isWrapperFor(Class<?> iface) throws SQLException {
//                return false;
//            }
//            ^
//            public Connection getConnection() throws SQLException {
//                return null;
//            }
//            ^
//            public Connection getConnection(String username, String password) throws SQLException {
//                return null;
//            }
//            ^
//            public PrintWriter getLogWriter() throws SQLException {
//                return null;
//            }
//            ^
//            public void setLogWriter(PrintWriter out) throws SQLException {
//            }
//            ^
//            public void setLoginTimeout(int seconds) throws SQLException {
//            }
//            ^
//            public int getLoginTimeout() throws SQLException {
//                return 0;
//            }
//            ^
//            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//                return null;
//            }
//        };