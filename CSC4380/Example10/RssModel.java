import java.util.Vector;

import javafx.concurrent.Task;

import java.util.Random;

public class RssModel {
    private Vector<ErrorHandler> errorHandlers = new Vector<ErrorHandler>();
    private Vector<ResultsHandler> resultsHandlers = new Vector<ResultsHandler>();

    Task<Vector<RssResult>> task = null;

    public void startFetch(String path) throws RssException {
        if (path.length() < 1) {
            throw new RssException("invalid path");
        }

        if (task != null) {
            throw new RssException("RSS already processing");
        }

        task = new Task<Vector<RssResult>>() {
            Vector<RssResult> results;

            @Override
            protected Vector<RssResult> call() throws Exception {
                Thread.sleep(2500); // millis

                Random r = new Random();
                if (r.nextDouble() < 0.1) {
                    throw new RssException("Rss Error");
                }

                Thread.sleep(2500);

                results = new Vector<RssResult>();

                RssResult r1 = new RssResult();
                r1.enclosure = "https://nowhere.land";
                r1.title = "nowhere";

                results.add(r1);

                RssResult r2 = new RssResult();
                r2.enclosure = "https://nota.url";
                r2.title = "not nothing";

                results.add(r2);

                return results;
            }

            @Override
            protected void succeeded() {
                super.succeeded();
                RssModel.this.task = null;
                RssModel.this.fireResultsEvent(results);
            }

            @Override
            protected void failed() {
                super.failed();
                RssModel.this.task = null;
                RssModel.this.fireErrorEvent("Kerbang!");
            }
        };

        Thread th = new Thread(task);
        th.start();
    }

    public void addErrorHandler(ErrorHandler handler) {
        errorHandlers.add(handler);
    }

    private void fireErrorEvent(String error) {
        for (ErrorHandler eh: errorHandlers) {
            eh.handleError(error);
        }
    }

    public void addResultsHandler(ResultsHandler handler) {
        resultsHandlers.add(handler);
    }

    private void fireResultsEvent(Vector<RssResult> results) {
        for (ResultsHandler rh: resultsHandlers) {
            rh.handleResults(results);
        }
    }
}
