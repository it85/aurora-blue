import app.marketdata.MDS;
import app.marketdata.MDSModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Sandbox {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MDSModule());

        MDS mds = injector.getInstance(MDS.class);
        mds.run();
    }

}
